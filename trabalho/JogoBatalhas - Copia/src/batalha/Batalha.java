package batalha;
import equipe.Equipe; import combatente.Combatente; import item.Consumivel; import util.IOHelper;
public class Batalha {
    private Equipe e1, e2; private String[] historia;
    public Batalha(Equipe e1, Equipe e2, String[] historia){ this.e1 = e1; this.e2 = e2; this.historia = historia; }
    public void iniciar(){
        System.out.println("\n=== BATALHA INICIADA ===");
        if(historia != null){
            for(String linha : historia){
                util.IOHelper.printSlow(linha, 20);
                util.IOHelper.pausar();
            }
        }
        int turno = 1;
        while(e1.existeVivo() && e2.existeVivo()){
            System.out.println("\n--- TURNO " + turno + " ---");
            executarTurno(e1, e2, true);
            if(!e2.existeVivo()) break;
            executarTurno(e2, e1, false);
            turno++;
        }
        System.out.println("\n=== FIM DA BATALHA ===");
        util.IOHelper.pausar();
    }
    private void executarTurno(Equipe ofensiva, Equipe defensiva, boolean humano){
        Combatente atacante = ofensiva.escolherAtacante(humano);
        if(atacante == null) return;
        atacante.iniciarTurno(); atacante.tickBuffs();
        Combatente alvo = defensiva.escolherAlvo(humano);
        if(alvo == null) return;
        int acao = 1;
        if(humano){
            System.out.println("1. Atacar");
            System.out.println("2. Usar poção");
            acao = IOHelper.lerInteiro(1, 2);
        }
        if(acao == 2){
            new Consumivel("Poção de Vida", 30).efeito(atacante);
        } else {
            util.IOHelper.attackAnimation(atacante.getNome(), alvo.getNome());
            int dano = atacante.atacar(alvo);
            if(!alvo.estaVivo()){
                atacante.ganharXp(30);
            }
        }
        atacante.tickBuffs();
    }
}
