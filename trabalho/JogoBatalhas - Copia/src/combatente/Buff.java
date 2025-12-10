package combatente;
import java.io.Serializable;
public class Buff implements Serializable {
    public enum Tipo { ATAQUE, DEFESA, VIDA_MAX }
    private Tipo tipo; private int amount; private int duration; private String origem;
    public Buff(Tipo tipo, int amount, int duration, String origem){
        this.tipo = tipo; this.amount = amount; this.duration = duration; this.origem = origem;
    }
    public Tipo getTipo(){ return tipo; } public int getAmount(){ return amount; }
    public int getDuration(){ return duration; } public void tick(){ duration--; }
    public boolean expirou(){ return duration <= 0; } public String getOrigem(){ return origem; }
}
