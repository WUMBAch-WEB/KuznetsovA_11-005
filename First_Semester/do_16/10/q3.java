//Максимальное значение массива
import java.util.Scanner;
class q3{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int arrsize = in.nextInt();
        int[] arr = new int[arrsize];
        System.out.print("Заполните массив: ");
        for (int i = 0; i<arrsize; i++){
            arr[i] = in.nextInt();
        }
        maxDigit(arr, arrsize);
    }
    public static void maxDigit (int[] arr, int arrsize){
        int max = -99999;
        for (int i = 0; i<arrsize; i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        System.out.print("Максимальное значение массива: "+max);
    }
}