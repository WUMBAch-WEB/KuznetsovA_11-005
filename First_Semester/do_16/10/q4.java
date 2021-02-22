//Склеивание двух массивов
import java.util.Scanner;
class q4{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите длину первого массива: ");
        int arrsize1 = in.nextInt();
        int[] arr1 = new int[arrsize1];
        System.out.print("Заполните массив: ");
        for (int i = 0; i<arrsize1; i++){
            arr1[i] = in.nextInt();
        }
        System.out.print("Введите длину второго массива: ");
        int arrsize2 = in.nextInt();
        int[] arr2 = new int[arrsize2];
        System.out.print("Заполните массив: ");
        for (int i = 0; i<arrsize2; i++){
            arr2[i] = in.nextInt();
        }
        glue(arr1, arr2, arrsize1, arrsize2);
    }
    public static void glue (int[] arr1, int[] arr2, int arrsize1, int arrsize2){
        int count = 0;
        int[] resultArr = new int[arrsize1+arrsize2];
        for (int i = 0; i<arrsize1; i++){
                resultArr[i]=arr1[i];
                count++;
        }
        for (int i = 0; i<arrsize2; i++){
            resultArr[count++]=arr2[i];

        }

        System.out.print("Результат: ");
        for (int i = 0; i<resultArr.length; i++){
            System.out.println(resultArr[i]);
        }
    }
}