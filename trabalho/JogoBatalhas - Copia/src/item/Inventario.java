package item;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import combatente.Combatente;

public class Inventario implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String,Integer> itens = new HashMap<>();
    private int ouro = 100;
    public void adicionar(String nome){ itens.put(nome, itens.getOrDefault(nome,0)+1); }
    public boolean possui(String nome){ return itens.getOrDefault(nome,0) > 0; }
    public void usar(String nome, Combatente alvo){
        if(!possui(nome)){ System.out.println("Você não possui " + nome); return; }
        switch(nome){
            case "Poção Cura": alvo.receberCura(30); break;
            case "Poção Força": alvo.adicionarBuff(new combatente.Buff(combatente.Buff.Tipo.ATAQUE,10,2,"Poção Força")); break;
            case "Poção Defesa": alvo.adicionarBuff(new combatente.Buff(combatente.Buff.Tipo.DEFESA,10,2,"Poção Defesa")); break;
            default: System.out.println("Item sem efeito."); break;
        }
        itens.put(nome, itens.get(nome)-1);
    }
    public void comprar(String nome,int custo){ if(ouro>=custo){ adicionar(nome); ouro-=custo; System.out.println("Comprou " + nome + ". Ouro: " + ouro); } else System.out.println("Ouro insuficiente."); }
    public int getOuro(){ return ouro; }
    public void adicionarOuro(int v){ ouro += v; }
    public void mostrar(){ System.out.println("--- Inventario ---"); itens.forEach((k,v)->System.out.println(k+": "+v)); System.out.println("Ouro: "+ouro); }
}
