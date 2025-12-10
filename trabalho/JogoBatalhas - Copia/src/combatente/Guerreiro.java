package combatente;
import java.util.Random;
public class Guerreiro extends Combatente {
    public Guerreiro(String nome){ super(nome,80,14,8); }
    @Override public void descricao(){ System.out.println(nome + " — Guerreiro"); }
    @Override public int atacar(Combatente alvo){ int dano = ataque + new Random().nextInt(6); System.out.println(nome + " golpeia ("+dano+")"); return alvo.defender(dano); }
}
