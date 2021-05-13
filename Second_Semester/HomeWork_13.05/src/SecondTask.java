import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecondTask {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите длину массива: ");
        int length = in.nextInt();
        System.out.println("Теперь заполните массив: ");
        int[] array = new int[length];
        for (int i = 0; i < length; i++){
            array[i] = in.nextInt();
        }
       Arrays.stream(array)
                .boxed()
                .sorted((a, b) -> Integer.compare(a%10, b%10))
                .map(x -> x / 10)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }
}
