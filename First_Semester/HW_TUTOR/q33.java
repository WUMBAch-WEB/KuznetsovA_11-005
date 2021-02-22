package HW_TUTOR;//Реализовать умножение матриц (алгоритм не должен зависеть от размера матрицы) и Вычислить определитель матрицы (2х2, 3х3).


import java.util.Scanner;
class q33 {
	public static void main (String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Ваша задача заключается в перемножении матриц? (Да/Нет)");
		String a = in.nextLine();
		if(a.equals("Да")){
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
			if (stolb1==stroki2){
		for (int i=0; i<matrix1.length;i++){
			for (int j=0; j<matrix1[i].length; j++){
				matrix1[i][j]= (int)(Math.random() * 2);
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
				matrix2[i][j]= (int)(Math.random() * 2);
			}
		}
		System.out.println("Матрица №2: ");
		for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length	; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
        int m = matrix1.length;
        int n = matrix2[0].length;
        int o = matrix2.length;
        int[][] matrix3 = new int[stroki1][stolb2];
         for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < o; k++) {
                    matrix3[i][j] += matrix1[i][k] * matrix2[k][j]; 
                }
            }
        }
        System.out.println("Итоговая матрица: ");
		for (int i = 0; i < matrix3.length; i++) {
            for (int j = 0; j < matrix3[i].length	; j++) {
                System.out.print(matrix3[i][j] + " ");
            }
            System.out.println();
        }
		}
		else{
			System.out.println("Перемножение невозможно");
		}
		System.exit(0);
		}
		System.out.print("Ваша задача заключается в вычислении определителя матрицы? (Да/Нет)");
		System.out.println();
		String b = in.nextLine();
		System.out.print(b);
		if (b.equals("Да")){
		System.out.print("Введите количество строк матрицы: ");
		int stroki4 = in.nextInt();
		System.out.print("Введите количество столбцов матрицы: ");
		int stolb4 = in.nextInt();
		int[][] matrix4 = new int[stroki4][stolb4];
		for (int i=0; i<matrix4.length;i++){
			for (int j=0; j<matrix4[i].length; j++){
				matrix4[i][j]= (int)(Math.random() * 5);
			}
		}
		System.out.println("Матрица: ");
		for (int i = 0; i < matrix4.length; i++) {
            for (int j = 0; j < matrix4[i].length	; j++) {
                System.out.print(matrix4[i][j] + " ");
            }
            System.out.println();
        }
        int opredelitel = 0;
        if (stroki4==2 && stolb4 == 2){
        	opredelitel= matrix4[0][0]*matrix4[1][1]-matrix4[0][1]*matrix4[1][0];
        	System.out.printf("Опеределитель: %d", opredelitel);
        }
        else{
        	opredelitel= (matrix4[1][1]*matrix4[2][2]-matrix4[1][2]*matrix4[2][1])-(matrix4[1][0]*matrix4[2][2]-matrix4[1][2]*matrix4[2][0])+(matrix4[1][0]*matrix4[2][1]-matrix4[0][1]*matrix4[2][0]);
        	System.out.printf("Опеределитель: %d", opredelitel);
        }
		}	
		else{
			System.out.println("К сожалению, ничем не могу помочь.");
		}		
		
	}
}
