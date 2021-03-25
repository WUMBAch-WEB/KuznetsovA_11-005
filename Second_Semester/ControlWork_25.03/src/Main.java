

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static ArrayList<City> getCities(Map<String, Map<String, Integer>> cities) {
        return (ArrayList<City>) cities;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Buyer> buyersArrayList = new ArrayList<>();
        Map<String, Map<String, Map<String, Integer>>> buyers = new HashMap<>();
        File file = new File("C:\\Users\\WUMBAch\\IdeaProjects\\KuznetsovA_11-005\\Second_Semester\\ControlWork_25.03\\orders.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while (line != null) {
            String[] strings = line.split("\\|");
            if (buyers.containsKey(strings[0])) {
                Map<String, Map<String, Integer>> cities = buyers.get(strings[0]);
                if (cities.containsKey(strings[1])) {
                    Map<String, Integer> orders = cities.get(strings[1]);
                    if (orders.containsKey(strings[2])) {
                        orders.put(strings[2], orders.get(strings[2]) + Integer.parseInt(strings[3]));
                    } else {
                        orders.put(strings[2], Integer.parseInt(strings[3]));
                    }
                } else {
                    HashMap<String, Integer> orders = new HashMap<>();
                    cities.put(strings[1], orders);
                    orders.put(strings[2], Integer.parseInt(strings[3]));
                }
            } else {
                HashMap<String, Map<String, Integer>> cities = new HashMap<>();
                HashMap<String, Integer> orders = new HashMap<>();
                buyers.put(strings[0], cities);
                cities.put(strings[1], orders);
                orders.put(strings[2], Integer.parseInt(strings[3]));
            }
            line = bufferedReader.readLine();
        }
        for (Map.Entry<String, Map<String, Map<String, Integer>>> entry : buyers.entrySet()) {
            buyersArrayList.add(new Buyer(entry.getKey(), getCities(entry.getValue())));
        }
    }
}
