//Количество разрядов числа
import java.util.Scanner;
class q1 {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число, разряды которого нужно посчитать: ");
        int n = in.nextInt();
        dichar(n);

    }
    public static void dichar(int n){
      String str = String.valueOf(n);
      System.out.print("Количество разрядов числа равно: "+str.length());
    }
}