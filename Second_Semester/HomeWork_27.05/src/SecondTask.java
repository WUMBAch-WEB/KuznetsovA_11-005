import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Stream;

public class SecondTask extends Thread{
    static volatile ArrayList evenWords = new ArrayList();
    static volatile ArrayList oddWords = new ArrayList();
    static volatile int index = 0;
    static volatile ArrayList<String> firstList = new ArrayList<>();
    static volatile boolean oddIsReady = false;
    static volatile boolean evenIsReady = false;

    static class MyThread1 extends Thread {
        @Override
        public void run() {
            for (int i = index; i < firstList.size(); i++){
                index++;
                if (String.valueOf(firstList.get(i)).chars().distinct().count() % 2 == 1){
                    System.out.println(currentThread().getName() + " thread add to oddWords a word " + firstList.get(i));
                    oddWords.add(firstList.get(i));
                }
                try {
                    MyThread1.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            oddIsReady = true;
        }
    }

    static class MyThread2 extends Thread {
        @Override
        public void run() {
            for (int i = index; i < firstList.size(); i++){
                index++;
                if (String.valueOf(firstList.get(i)).chars().distinct().count() % 2 == 0){
                    System.out.println(currentThread().getName() + " thread add to evenWords a word " + firstList.get(i));
                    evenWords.add(firstList.get(i));
                }
                try {
                    MyThread2.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            evenIsReady = true;
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("C:\\Users\\sascu\\IdeaProjects\\KuznetsovA_11-005\\Second_Semester\\HomeWork_27.05\\src\\input.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while (line != null){

            String[] strings = line.toLowerCase(Locale.ROOT).split(" ");
            Stream<String> stream = Arrays.stream(strings);

            line = bufferedReader.readLine();
        }
        MyThread1 threadN1 = new MyThread1();
        MyThread2 threadN2 = new MyThread2();
        threadN1.setName("odd");
        threadN2.setName("even");
        threadN1.start();
        threadN2.start();
        threadN1.join();
        threadN2.join();
        if (evenIsReady == true && oddIsReady == true){
            System.out.println("EvenWords: ");
            for (int i = 0; i < evenWords.size(); i++){
                System.out.print(evenWords.get(i) + " | ");
            }
            System.out.println();
            System.out.println("OddWords: ");
            for (int i = 0; i < oddWords.size(); i++){
                System.out.print(oddWords.get(i) + " | ");
            }
        }
    }

}
