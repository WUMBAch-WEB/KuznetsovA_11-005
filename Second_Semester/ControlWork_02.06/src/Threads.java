import java.util.Scanner;

public class Threads {

    public static void method0(){
        System.exit(0);
    }
    public static void method1(){
        System.out.println("run first method");
    }
    public static void method2(){
        System.out.println("run second method");
    }
    public static void method3(){
        System.out.println("run third method");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true){
            int mode = in.nextInt();
            switch (mode) {
                case 0 -> new Thread(Threads::method0).start();
                case 1 -> new Thread(Threads::method1).start();
                case 2 -> new Thread(Threads::method2).start();
                case 3 -> new Thread(Threads::method3).start();
                default -> System.out.println("Incorrect num");
            }
        }
    }

}
