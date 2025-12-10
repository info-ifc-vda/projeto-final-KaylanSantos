package equipe;
import combatente.Combatente;
import util.IOHelper;
public class Equipe {
    private String nome;
    private Combatente[] membros;
    private int tamanho;
    public Equipe(String nome){ this.nome = nome; this.membros = new Combatente[10]; this.tamanho = 0; }
    public void adicionar(Combatente c){ membros[tamanho++] = c; }
    public boolean existeVivo(){ for(int i=0;i<tamanho;i++) if(membros[i].estaVivo()) return true; return false; }
    public boolean todasVivas(){ for(int i=0;i<tamanho;i++) if(!membros[i].estaVivo()) return false; return true; }
    public Combatente escolherAtacante(boolean humano){
        if(humano){
            System.out.println("Escolha atacante da " + nome + ":");
            for(int i=0;i<tamanho;i++) System.out.println((i+1) + ". " + membros[i].getNome() + " (vida: " + membros[i].getVida() + ")");
            return membros[IOHelper.lerInteiro(1, tamanho)-1];
        }
        return membros[(int)(Math.random()*tamanho)];
    }
    public Combatente escolherAlvo(boolean humano){
        if(humano){
            System.out.println("Escolha o alvo da " + nome + ":");
            for(int i=0;i<tamanho;i++) System.out.println((i+1) + ". " + membros[i].getNome() + " (vida: " + membros[i].getVida() + ")");
            return membros[IOHelper.lerInteiro(1, tamanho)-1];
        }
        return membros[(int)(Math.random()*tamanho)];
    }
    public String getNome(){ return nome; }
    public Combatente[] getMembros(){ return membros; }
    public int getTamanho(){ return tamanho; }
}
