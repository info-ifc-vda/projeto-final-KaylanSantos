import equipe.Equipe;
import combatente.*;
import util.SaveLoad;
import item.Inventario;
import npc.Mercador;
import batalha.Batalha;

public class Main {
    public static void main(String[] args){
        String save = "data/gamestate.dat";

        SaveLoad.GameState st = SaveLoad.carregarState(save);
        Inventario inv = (st != null && st.inventario != null) ? st.inventario : new Inventario();
        int ng = (st != null) ? st.newGamePlusLevel : 0;

        Equipe jogador = new Equipe("Heróis");
        jogador.adicionar(new Mago("Lumi"));
        jogador.adicionar(new Guerreiro("Brutus"));
        jogador.adicionar(new Arqueiro("Shade"));

        Mercador.abrirLoja(inv);

        Equipe inimigos = new Equipe("Invasores");
        inimigos.adicionar(new Robo("Sentinela"));
        inimigos.adicionar(new Guerreiro("Brutal"));
        inimigos.adicionar(new Arqueiro("Espreitador"));

        Batalha b = new Batalha(jogador, inimigos, new String[]{
            "Você chega à vila...",
            "A torre foi tomada."
        });
        b.iniciar();

        SaveLoad.GameState gs = new SaveLoad.GameState();
        gs.inventario = inv;
        gs.newGamePlusLevel = ng;

        SaveLoad.salvarState(gs, save);
    }
}
