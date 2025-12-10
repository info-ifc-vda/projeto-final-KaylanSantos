package combatente;
import java.util.Random;
public class Mago extends Combatente {
    public Mago(String nome){ super(nome,45,18,4); }
    @Override public void descricao(){ System.out.println(nome + " — Mago"); }
    @Override public int atacar(Combatente alvo){ int bonus = new Random().nextInt(12)+2; int dano = ataque + bonus; System.out.println(nome + " lança Bola de Fogo! (dano " + dano + ")"); return alvo.defender(dano); }
}
