import java.util.Scanner;
class Tn1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int arr_size = in.nextInt();
        int[] arr = new int[arr_size];
        System.out.print("Массив: ");
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * 10000);
            System.out.print(arr[i] + " ");
        }
        //Разность между суммой четных и нечетных чисел массива
        int summ_chet = 0;
        int summ_nchet = 0;
        int raznost = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] % 2 == 0){
                summ_chet += arr[i];
            }
            else{
                summ_nchet += arr[i];
            }
        }
        System.out.println();
        raznost = summ_chet - summ_nchet;
        System.out.print("Разность между суммой четных и нечетных чисел массива равна: ");
        System.out.print(raznost);
        //Самое большое число и второе по величине
        int max = -99999;
        int pre_max = -99999;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > max){
                if (max > pre_max){
                    pre_max = max;
                    max = arr[i];
                }
                else {
                    max = arr[i];
                }
            }
            else if (arr[i] > pre_max){
                pre_max = arr[i];
            }
        }
        System.out.println();
        System.out.print("Наибольшее число: ");
        System.out.print(max);
        System.out.println();
        System.out.print("Второе по величине: ");
        System.out.print(pre_max);
        // мин разность между соседними элементами
        int sosedi = 99999;
        for (int i = 1; i < arr.length; i++){
            int j = arr[i] - arr[i - 1];
            if (Math.abs(j) < sosedi){
                sosedi = Math.abs(j);
            }
        }
        System.out.println();
        System.out.print("Минимальная разность соседних элементов: ");
        System.out.println(sosedi);
        // Макс сумма цифр числа
        int max_summ = -99999;
        for (int i = 0; i < arr.length; i++){
            int j = arr[i];
            int summ = 0;
            while (j>0){
                summ += j % 10;
                j /= 10;
            }
            if (summ > max_summ){
                max_summ = summ;
            }
        }
        System.out.print("Максимальная сумма цифр: ");
        System.out.println(max_summ);
        // Локальный максимум
        System.out.print("Локальные максимумы: ");
        for (int i = 1; i < arr.length - 1; i++){
            if (arr[i] >  arr[i - 1] && arr[i] > arr[i + 1]){
                System.out.print(arr[i] + " ");
            }
        }
    }
}
