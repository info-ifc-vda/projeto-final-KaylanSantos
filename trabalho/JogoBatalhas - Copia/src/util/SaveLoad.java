package util;
import java.io.*;
import item.Inventario;
public class SaveLoad {
    public static class GameState implements Serializable {
        private static final long serialVersionUID = 1L;
        public Inventario inventario;
        public java.util.List<String> playerNames = new java.util.ArrayList<>();
        public java.util.List<String> playerClasses = new java.util.ArrayList<>();
        public java.util.List<Integer> playerVida = new java.util.ArrayList<>();
        public java.util.List<Integer> playerXp = new java.util.ArrayList<>();
        public int newGamePlusLevel = 0;
    }

    public static void salvarState(GameState state, String file){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(state);
            System.out.println("Estado do jogo salvo em: " + file);
        } catch(Exception e){
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    public static GameState carregarState(String file){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            GameState st = (GameState) ois.readObject();
            System.out.println("Estado carregado de: " + file);
            return st;
        } catch(FileNotFoundException fnf){
            System.out.println("Nenhum save encontrado.");
            return null;
        } catch(Exception e){
            System.out.println("Erro ao carregar: " + e.getMessage());
            return null;
        }
    }
}
