package SecondTask;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter start_index: ");
        int start = in.nextInt();
        System.out.print("Enter end_index: ");
        int end = in.nextInt();
        RangeInterval rangeInterval = new RangeInterval(start, end);
        Iterator<Integer> iterator = rangeInterval.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


}
