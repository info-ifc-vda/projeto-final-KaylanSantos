package npc;
import item.Inventario; import util.IOHelper;
public class Mercador {
    public static void abrirLoja(Inventario inv){
        System.out.println("\n=== MERCADOR ===");
        boolean run = true;
        while(run){
            System.out.println("1) Poção Cura (+30) - 20 ouro");
            System.out.println("2) Poção Força (+10 ATK por 2 turnos) - 35 ouro");
            System.out.println("3) Poção Defesa (+10 DEF por 2 turnos) - 35 ouro");
            System.out.println("4) Sair");
            int op = IOHelper.lerInteiro(1,4);
            switch(op){
                case 1: inv.comprar("Poção Cura",20); break;
                case 2: inv.comprar("Poção Força",35); break;
                case 3: inv.comprar("Poção Defesa",35); break;
                default: run=false; break;
            }
        }
    }
}
