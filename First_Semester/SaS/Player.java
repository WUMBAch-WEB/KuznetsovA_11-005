package SaS;
import java.util.Random;
import java.util.Scanner;
public class Player {
    int HP = 100;
    static public int getPower(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите силу удара: ");
        int power = in.nextInt();
        return power;
    }
    public static boolean punch(int powerg){
        Random rnd = new Random();
        int power = powerg;
        int success = 0;
        if (power == 1){
            success = rnd.nextInt(11) + 89;
        }
        if (power == 2){
            success = rnd.nextInt(20) + 80;
        }
        if (power == 3){
            success = rnd.nextInt(30) + 70;
        }
        if (power == 4){
            success = rnd.nextInt(40) + 60;
        }
        if (power == 5){
            success = rnd.nextInt(50) + 50;
        }
        if (power == 6){
            success = rnd.nextInt(60) + 40;
        }
        if (power == 7){
            success = rnd.nextInt(70) + 30;
        }
        if (power == 8){
            success = rnd.nextInt(80) + 20;
        }
        if (power == 9){
            success = rnd.nextInt(90) + 10;
        }
        if (success >= 90){
            System.out.println("Успешный удар");
            return true;
        }
        else{
            System.out.println("Промах");
            return false;
        }
    }
}
