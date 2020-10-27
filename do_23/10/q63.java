//Фибоначчи
import java.util.Scanner;
class q63 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер числа Фибоначи: ");
        int n = in.nextInt();
        n = n-2;
        long count1 = 0;
        long count2 = 1;
        long count3 = 0;
        fib(count1, count2, n, count3);

    }
    private static void fib(long count1, long count2, int n, long count3){
        if (n != 0){
            n--;
            count3 = count1 + count2;
            count1 = count2;
            count2 = count3;
        }
        else{
            System.out.print(count3);
            return;
        }
        fib(count1, count2, n, count3);

    }
}