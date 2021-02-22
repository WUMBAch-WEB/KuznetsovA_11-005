package ThirdTask;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter length: ");
        int length = in.nextInt();
        Fibonacci fibonacci = new Fibonacci(length);
        Iterator iterator = fibonacci.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
