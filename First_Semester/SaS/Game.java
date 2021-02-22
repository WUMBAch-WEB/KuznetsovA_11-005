package SaS;

import java.util.Scanner;

public class Game {
    static Player first = new Player();
    static Player second = new Player();
    public static void process(){
        System.out.println("Добро пожаловать в игру 'SaS'");
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя первого игрока: ");
        String nameOfFirstPlayer = in.nextLine();
        System.out.print("Введите имя второго игрока: ");
        String nameOfSecondPlayer = in.nextLine();
        System.out.println("Игра начинается.");
        while (first.HP > 0 && second.HP > 0){
            System.out.println("Удар первого игрока.");
            int powerFirst = first.getPower();
            if (first.punch(powerFirst)){
               second.HP -= powerFirst;
                System.out.println("Состояние здоровья второго игрока: " + second.HP);
            }
            System.out.println("Удар второго игрока.");
            int powerSecond = second.getPower();
            if (second.punch(powerSecond)){
                first.HP -= powerSecond;
                System.out.println("Состояние здоровья первого игрок: " + first.HP);
            }
        }
        if (first.HP <= 0){
            System.out.println("Первый игрок проиграл");
        }
        else{
            System.out.println("Второй игрок проиграл");
        }
    }
}
