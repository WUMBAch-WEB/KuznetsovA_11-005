//Сумма матриц (Пока работает только с матрицами одного размера)
import java.util.Scanner;
class q6{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество строк первой матрицы: ");
        int stroki1 = in.nextInt();
        System.out.print("Введите количество столбцов первой матрицы: ");
        int stolb1 = in.nextInt();
        System.out.print("Введите количество строк второй матрицы: ");
        int stroki2 = in.nextInt();
        System.out.print("Введите количество столбцов второй матрицы: ");
        int stolb2 = in.nextInt();
        int[][] matrix1 = new int[stroki1][stolb1];
        int[][] matrix2 = new int[stroki2][stolb2];

        for (int i=0; i<matrix1.length;i++){
            for (int j=0; j<matrix1[i].length; j++){
                matrix1[i][j]= (int)(Math.random() * 5);
            }
        }
        System.out.println("Матрица №1: ");
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length	; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }
        for (int i=0; i<matrix2.length;i++){
            for (int j=0; j<matrix2[i].length; j++){
                matrix2[i][j]= (int)(Math.random() * 5);
            }
        }
        System.out.println("Матрица №2: ");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length	; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
        summ(matrix1, matrix2);
    }
    public static void summ(int[][] matrix1, int[][] matrix2){
        for (int i=0; i<matrix1.length;i++){
            for (int j=0; j<matrix1[i].length; j++){
                matrix1[i][j]+=matrix2[i][j];
            }
        }
        System.out.println("Сумма: ");
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length	; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }
    }
}