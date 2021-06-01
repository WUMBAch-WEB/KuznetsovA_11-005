import java.util.Scanner;
public class FirstTask {
    public static volatile long factorial = 1;
    public static volatile int index = 1;
    public static int n;

    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = index; i <= n; i++) {
                index++;
                factorial = factorial * i;
                System.out.println("Factorial of " + i + " = " + factorial);
                if (index == 5 || index == 10 || index == 15 || index == 20){
                    return;
                }
            }
            try {
                MyThread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        if (n > 20 || n < 0){
            System.out.println("Incorrect number");
            System.exit(0);
        }
        for (int i = 1; i < n; i+=4){
            MyThread thread = new MyThread();
            thread.start();
            thread.join();
        }

    }
}