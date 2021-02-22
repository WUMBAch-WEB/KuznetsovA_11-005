//Бинарный поиск
import java.util.Scanner;
class n1 {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите длину массива");
        int arr_size = in.nextInt();
        int[] arr = new int[arr_size];
        for(int i = 0; i<arr_size; i++){
            arr[i] = (int)(Math.random() * 10);
        }
        System.out.println("Начальный массив: ");
        for(int i = 0; i<arr_size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Введите индекс первого числа:");
        int number1 = in.nextInt();
        System.out.println("Введите индекс второго числа:");
        int number2 = in.nextInt();
        arr[number1] += arr[number2];
        arr[number2] += arr[number1];
        arr[number1] -= arr[number2];
        if (arr[number1] < 0){
            arr[number1] = Math.abs(arr[number1]);
        }
        arr[number2] -= (2 * arr[number1]);
        System.out.println("Измененный массив: ");
        for(int i = 0; i<arr_size; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
