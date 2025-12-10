package combatente;
public class Assassino extends Combatente {
    private boolean furtivo = true;
    public Assassino(String nome){ super(nome,42,26,3); }
    @Override public void descricao(){ System.out.println(nome + " — Assassino"); }
    @Override public int atacar(Combatente alvo){ boolean crit = Math.random()<0.40; int dano = ataque + (int)(Math.random()*12); if(crit){ dano*=3; System.out.println(nome+" CRÍTICO x3!"); } else System.out.println(nome+" golpeia"); return alvo.defender(dano); }
    public void entrarFurtivo(){ furtivo=true; System.out.println(nome+" entra em furtivo."); }
}
