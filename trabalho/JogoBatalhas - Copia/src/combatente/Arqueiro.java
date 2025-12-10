package combatente;
import java.util.Random;
public class Arqueiro extends Combatente {
    public Arqueiro(String nome){ super(nome,55,16,5); }
    @Override public void descricao(){ System.out.println(nome + " — Arqueiro"); }
    @Override public int atacar(Combatente alvo){
        Random r = new Random(); boolean crit = r.nextDouble() < 0.25; int base = ataque + r.nextInt(8); int dano = crit? base*2 : base;
        if(crit) System.out.println("CRÍTICO x2!");
        System.out.println(nome + " dispara ("+dano+")");
        return alvo.defender(dano);
    }
}
