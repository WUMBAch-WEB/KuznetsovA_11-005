import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class FirstTask {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите длину массива: ");
        int length = in.nextInt();
        System.out.println("Теперь заполните массив: ");
        String[] array = new String[length];
        for (int i = 0; i < length; i++){
            array[i] = in.next();
        }
        Stream<String>stream = Arrays.stream(array).filter(x -> x.charAt(0) != 'a');
        System.out.println("Результат работы: ");
        stream.forEach(System.out::println);
    }
}
