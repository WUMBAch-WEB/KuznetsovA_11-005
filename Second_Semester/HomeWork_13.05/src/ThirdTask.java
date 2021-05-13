import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThirdTask {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\sascu\\IdeaProjects\\KuznetsovA_11-005\\Second_Semester\\HomeWork_13.05\\task3.txt");
        HashMap<String, Integer> map = new HashMap();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while (line != null) {
            Stream.of(line)
                    .map(x -> x.split("\\|"))
                    .map(x -> map.containsKey(x[0]) ?
                            map.put(x[0], map.get(x[0]) + Integer.parseInt(x[1])) :
                            map.put(x[0], Integer.parseInt(x[1]))).collect(Collectors.toList());
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        System.out.println(map);
    }
}
