//Транспонирование матрицы (Пока что работает только с квадратной)
import java.util.Scanner;
class q5{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество строк матрицы: ");
        int stroki = in.nextInt();
        System.out.print("Введите количество столбцов матрицы: ");
        int stolb = in.nextInt();
        int[][] matrix = new int[stroki][stolb];
        for (int i=0; i<matrix.length;i++){
            for (int j=0; j<matrix[i].length; j++){
                matrix[i][j]= (int)(Math.random() * 10);
            }
        }
        System.out.println("Начальная матрица: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length	; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        transpose(matrix);
    }
    public static void transpose(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println("Транспонированная матрица: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length	; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}