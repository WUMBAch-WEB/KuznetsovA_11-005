//Разворачивание строки
import java.util.Scanner;
class q62 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число, с которого требуется начать вывовод: ");
        int count1 = in.nextInt();
        System.out.print("Введите последнее число: ");
        int count2 = in.nextInt();
        otADoB(count1, count2);

    }
    private static void otADoB(int count1, int count2){
        if (count1 <= count2){
            System.out.println(count1);
            count1++;
        }
        else{
            return;
        }
        otADoB(count1, count2);

    }
}