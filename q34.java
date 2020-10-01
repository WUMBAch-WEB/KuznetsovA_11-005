//Отсортировать столбцы матрицы по элементам первой строки.

import java.util.Random;
import java.util.Scanner;
public class q34
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Введите количество строк");
        int stroka = in.nextInt();
        System.out.println("Введите количество столбцов");
        int stolb = in.nextInt();
        int[][] matrix1 = new int[stroka][stolb];
        for (int i=0; i<matrix1.length;i++){
            for (int j=0; j<matrix1[i].length; j++){
                matrix1[i][j]= (int)(Math.random() * 5);
            }
        }
        System.out.print("Исходная матрицы:");
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length   ; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }

        int min = Integer.MAX_VALUE;
        int index = 0;
        int counter = 0;
        int holder;
        int i;
        while (counter < stolb - 1)
        {
            for ( i = counter; i < stolb ; i++)
            {
                if (matrix1[0][i] < min)
                {
                    index = i;
                    min = matrix1[0][i];
                }

            }
            for(i = 0 ; i < stroka; i++ )
            {
                if (i == 0)
                {
                    holder = matrix1[i][0 + counter];
                    matrix1[i][0+counter]=min;
                    matrix1[i][index] = holder;
                }
                else
                {
                    holder = matrix1[i][0 + counter];
                    matrix1[i][0+counter]=matrix1[i][index];
                    matrix1[i][index] = holder;

                }


            }
            counter++;
            min = Integer.MAX_VALUE;
        }
        System.out.print("Итог:");
        for (int k = 0; k < matrix1.length; k++) {
            for (int j = 0; j < matrix1[k].length   ; j++) {
                System.out.print(matrix1[k][j] + " ");
            }
            System.out.println();
        }


    }
}
