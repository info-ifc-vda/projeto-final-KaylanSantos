package util;
import java.util.Scanner;
public class IOHelper {
    public static int lerInteiro(int min, int max){
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                int v = Integer.parseInt(sc.nextLine());
                if(v >= min && v <= max) return v;
            } catch(Exception e){}
            System.out.println("Digite entre " + min + " e " + max);
        }
    }
    public static void pausar(){
        System.out.println("\n[ENTER] para continuar...");
        new Scanner(System.in).nextLine();
    }
    public static void printSlow(String msg, int ms){
        for(char c : msg.toCharArray()){
            System.out.print(c);
            try{ Thread.sleep(ms); } catch(Exception e){}
        }
        System.out.println();
    }
    public static void attackAnimation(String attacker, String target){
        for(int i=0;i<25;i++){
            System.out.print("\r" + attacker + " " + " ".repeat(i) + "-> " + target);
            try{ Thread.sleep(20); } catch(Exception e){}
        }
        System.out.println();
    }
    public static void damageBar(int dano){
        int max = 30;
        int filled = Math.min(30, dano);
        System.out.print("DANO: " + dano + " [");
        for(int i=0;i<filled;i++) System.out.print("#");
        for(int i=filled;i<max;i++) System.out.print("-");
        System.out.println("]");
    }
}
