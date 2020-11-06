//Бинарный поиск
import java.util.Scanner;
class n2 {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int number1 = in.nextInt();
        System.out.println("Введите второе число:");
        int number2 = in.nextInt();
        number1 += number2;
        number2 += number1;
        number1 -= number2;
        if (number1 < 0){
            number1 = Math.abs(number1);
        }
        number2 -= (2*number1);
        System.out.println("Итог: ");
        System.out.println(number1);
        System.out.println(number2);
    }
}
