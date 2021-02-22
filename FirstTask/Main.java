package FirstTask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FourTuple<Integer, Integer, Integer, Integer> tuple = makeFourthValues();
        System.out.println(tuple.first);
        System.out.println(tuple.second);
        System.out.println(tuple.third);
        System.out.println(tuple.fourth);
    }

    public static FourTuple<Integer, Integer, Integer, Integer> makeFourthValues() {
        Scanner in = new Scanner(System.in);
        return new FourTuple(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
    }

}
