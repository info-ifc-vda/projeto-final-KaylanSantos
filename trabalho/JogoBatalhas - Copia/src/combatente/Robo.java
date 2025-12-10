package combatente;
import java.util.Random;
public class Robo extends Combatente {
    public Robo(String nome){ super(nome,65,15,9); }
    @Override public void descricao(){ System.out.println(nome + " — Robo"); }
    @Override public int atacar(Combatente alvo){ Random r=new Random(); int dano = ataque + r.nextInt(6); if(r.nextDouble()<0.30){ dano*=2; System.out.println(nome+" CRÍTICO!"); } else System.out.println(nome+" atira"); return alvo.defender(dano); }
}
