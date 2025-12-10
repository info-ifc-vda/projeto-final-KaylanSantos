package combatente;
import java.util.Random;
public class Boss extends Combatente {
    private int enragedAt; private int fase = 1;
    public Boss(String nome){ super(nome,220,22,10); enragedAt=(int)(vidaMax*0.35); }
    @Override public void descricao(){ System.out.println(nome + " — Boss"); }
    @Override public int atacar(Combatente alvo){ Random r=new Random(); if(vida<enragedAt && fase==1){ fase=2; ataque+=12; System.out.println(nome+" entra em fúria!"); } int dano; if(r.nextDouble()<0.18){ dano=ataque+18; System.out.println(nome+" usa Investida Devastadora!"); } else { dano=ataque + r.nextInt(12); System.out.println(nome+" ataca ("+dano+")"); } return alvo.defender(dano); }
}
