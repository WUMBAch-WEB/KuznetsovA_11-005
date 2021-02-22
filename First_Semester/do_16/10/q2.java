//Разворачивание строки
import java.util.Scanner;
class q2{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку, которую нужно развернуть: ");
        String str1 = in.nextLine();
        miror(str1);

    }
    public static void miror(String str1){
        char[] arr = str1.toCharArray();
        String str2 = "";
        for (int i=arr.length-1; i>=0; i--){
            str2+=arr[i];
        }
        System.out.print("Развернутая строка: "+ str2);
    }
}