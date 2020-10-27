//Разворачивание строки
import java.util.Scanner;
class q61 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число, факториал которого хотите узнать: ");
        int count = in.nextInt();
        System.out.print(factorial(count));

    }
    private static int factorial(int count){
        if (count == 1){
            return 1;
        }
        return count*factorial(count-1);
    }
}