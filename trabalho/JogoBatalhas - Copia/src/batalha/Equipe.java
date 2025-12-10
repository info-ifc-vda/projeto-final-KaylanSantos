package batalha;

import java.util.ArrayList;
import java.util.List;
import combatente.Combatente;

public class Equipe {
    private String nome;
    private List<Combatente> membros = new ArrayList<>();

    public Equipe(String nome){ this.nome = nome; }
    public String getNome(){ return nome; }

    public void adicionar(Combatente c){ membros.add(c); }
    public List<Combatente> getMembros(){ return membros; }

    public boolean existeVivo(){
        return membros.stream().anyMatch(Combatente::estaVivo);
    }

    public int forcaTotal(){
        return membros.stream().mapToInt(Combatente::getVida).sum();
    }
}
