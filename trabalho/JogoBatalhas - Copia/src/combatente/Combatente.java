package combatente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Combatente implements Serializable {
    protected String nome;
    protected int vida;
    protected int vidaMax;
    protected int ataque;
    protected int defesa;

    protected int nivel = 1;
    protected int xp = 0;
    protected int xpToNext = 50;

    protected transient List<Buff> buffs = new ArrayList<>();

    public Combatente(String nome, int vida, int ataque, int defesa){
        this.nome = nome;
        this.vida = vida;
        this.vidaMax = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.buffs = new ArrayList<>();
    }

    public boolean estaVivo(){ return vida > 0; }
    public String getNome(){ return nome; }
    public int getVida(){ return vida; }
    public int getVidaMax(){ return vidaMax; }
    public int getAtaque(){ return ataque + buffTotal(Buff.Tipo.ATAQUE); }
    public int getDefesa(){ return defesa + buffTotal(Buff.Tipo.DEFESA); }

    public void iniciarTurno(){}

    public void adicionarBuff(Buff b){
        if(b == null) return;
        if(b.getTipo() == Buff.Tipo.VIDA_MAX){
            vidaMax += b.getAmount();
            vida += b.getAmount();
        }
        if(buffs==null) buffs = new ArrayList<>();
        buffs.add(b);
        System.out.printf("%s recebeu buff %s (%+d) por %d turnos\n", nome, b.getTipo().name(), b.getAmount(), b.getDuration());
    }

    public void tickBuffs(){
        if(buffs==null) buffs = new ArrayList<>();
        Iterator<Buff> it = buffs.iterator();
        while(it.hasNext()){
            Buff b = it.next();
            b.tick();
            if(b.expirou()){
                if(b.getTipo() == Buff.Tipo.VIDA_MAX){
                    vidaMax -= b.getAmount();
                    if(vida > vidaMax) vida = vidaMax;
                }
                it.remove();
                System.out.printf("%s perdeu buff %s\n", nome, b.getTipo().name());
            }
        }
    }

    private int buffTotal(Buff.Tipo tipo){
        if(buffs==null) return 0;
        int total=0;
        for(Buff b:buffs) if(b.getTipo()==tipo) total+=b.getAmount();
        return total;
    }

    public void receberCura(int cura){
        vida = Math.min(vida + cura, vidaMax);
        System.out.printf("%s recuperou %d pontos de vida. (vida: %d)\n", nome, cura, vida);
    }

    public int defender(int dano){
        int defAtual = getDefesa();
        int danoFinal = Math.max(0, dano - defAtual);
        vida -= danoFinal;
        if(vida < 0) vida = 0;
        System.out.printf("%s recebeu %d de dano. Vida restante: %d\n", nome, danoFinal, vida);
        return danoFinal;
    }

    public void ganharXp(int qtd){
        xp += qtd;
        System.out.printf("%s ganhou %d XP (atual: %d/%d)\n", nome, qtd, xp, xpToNext);
        while(xp >= xpToNext){
            xp -= xpToNext;
            levelUp();
        }
    }

    protected void levelUp(){
        nivel++;
        vidaMax += 8;
        ataque += 2;
        defesa += 1;
        vida = vidaMax;
        xpToNext = (int)(xpToNext * 1.4);
        System.out.printf("%s subiu para o nível %d! (vidaMax=%d, atk=%d, def=%d)\n", nome, nivel, vidaMax, ataque, defesa);
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
        in.defaultReadObject();
        buffs = new ArrayList<>();
    }

    public abstract int atacar(Combatente alvo);
    public abstract void descricao();
}
