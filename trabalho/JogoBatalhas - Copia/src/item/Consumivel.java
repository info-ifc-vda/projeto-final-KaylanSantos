package item;

import combatente.Combatente;

public class Consumivel extends Item {
    private int cura;
    public Consumivel(String nome, int cura){ super(nome); this.cura = cura; }

    @Override
    public void efeito(Combatente alvo){
        alvo.receberCura(cura);
        System.out.printf("%s usou %s em %s! (+%d vida)\n", alvo.getNome(), nome, alvo.getNome(), cura);
    }
}
