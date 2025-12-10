package combatente;
public class Paladino extends Combatente {
    private int curaSkillCooldown = 0;
    public Paladino(String nome){ super(nome,75,12,12); }
    @Override public void descricao(){ System.out.println(nome + " — Paladino"); }
    @Override public int atacar(Combatente alvo){ int dano = ataque + (int)(Math.random()*4); System.out.println(nome + " golpeia ("+dano+")"); int d = alvo.defender(dano); if(Math.random()<0.12){ receberCura(6); System.out.println(nome+" curou 6 por passiva."); } if(curaSkillCooldown>0) curaSkillCooldown--; return d; }
    public void skillCura(Combatente alvo){ if(curaSkillCooldown>0){ System.out.println("Skill em cooldown: "+curaSkillCooldown); return; } System.out.println(nome+" usa Luz Curativa em "+alvo.getNome()+" (+25)"); alvo.receberCura(25); curaSkillCooldown=4; }
}
