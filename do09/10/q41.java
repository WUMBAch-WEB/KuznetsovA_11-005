//Реализовать умножение матриц (алгоритм не должен зависеть от размера матрицы) и Вычислить определитель матрицы (2х2, 3х3).


import java.util.Scanner;
class q41 {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число, которое необходимо найти в массиве:");
        int input = in.nextInt();
        System.out.print("Введите размер массива:");
        int arrsize = in.nextInt();
        System.out.println("Заполните массив:");
        int[] arr = new int[arrsize];
        for (int i = 0; i<arrsize; i++){
            arr[i] = in.nextInt();
        }
        int itog = 0;
        int flag = 0;
        int min = 0;
        int max = arr.length - 1;
        while (min <= max){
            int mid = min + (max - min) / 2;
            if (input < arr[mid]){
                max = mid - 1;
            }
            else if (input > arr[mid]){
                min = mid + 1;
            }
            else{
                flag = 1;
                itog = mid;
                break;
            }
        }
        if (flag == 0){
            System.out.print("Такого числа нет в массиве");
        }
        else {
            System.out.print("Индекс искомого числа в массиве: ");
            System.out.print(itog);
        }
    }
}
