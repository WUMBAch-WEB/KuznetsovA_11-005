

import java.io.*;
import java.util.*;

public class Main {

    public static ArrayList<Order> getOrders(Map<String, Integer> orders){
        ArrayList<Order> orderArrayList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : orders.entrySet()){
            orderArrayList.add(new Order(entry.getKey(), entry.getValue()));
        }
        return orderArrayList;
    }

    public static ArrayList<City> getCities(Map<String, Map<String, Integer>> cities) {
        ArrayList<City> cityArrayList = new ArrayList<>();
        for (Map.Entry<String, Map<String, Integer>> entry : cities.entrySet()){
            cityArrayList.add(new City(entry.getKey(), getOrders(entry.getValue())));
        }
        return cityArrayList;
    }

    public static void main(String[] args) throws IOException {

        BuyerByCityCountComparator cityCountComparator = new BuyerByCityCountComparator();
        BuyerByNameComparator nameComparator = new BuyerByNameComparator();
        BuyerByOrdersCountComparator ordersCountComparator = new BuyerByOrdersCountComparator();
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
//        for (int i = 0; i < buyersArrayList.size(); i ++){
//            System.out.println(buyersArrayList.get(i));
//        }
        Comparator<Buyer> compareFirstByNameThenByCityCountThenByOrdersCount = new BuyerByNameComparator().
                thenComparing(new BuyerByCityCountComparator()).
                thenComparing(new BuyerByOrdersCountComparator());
        TreeSet<Buyer> firstSet = new TreeSet<>(compareFirstByNameThenByCityCountThenByOrdersCount);
        firstSet.addAll(buyersArrayList);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("sortedByName.txt"))){
            bufferedWriter.write(String.valueOf(firstSet));
            bufferedWriter.close();
        }
        catch (IOException e){
            System.out.println(e);
        }

        Comparator<Buyer> comapareFirstByOrdersCountThenByCityCountThenByName = new BuyerByOrdersCountComparator().
                thenComparing(new BuyerByCityCountComparator()).
                thenComparing(new BuyerByNameComparator());

        TreeSet<Buyer> secondSet = new TreeSet<>(comapareFirstByOrdersCountThenByCityCountThenByName);
        secondSet.addAll(buyersArrayList);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("sortedByOrders.txt"))){
            bufferedWriter.write(String.valueOf(secondSet));
            bufferedWriter.close();
        }

        System.out.println("TEST:");
        System.out.println("FirstSet: ");
        System.out.println(firstSet);
        System.out.println("SecondSet: ");
        System.out.println(secondSet);
        System.out.println("На первый взгляд отличий нема, но в первом сете второй покупатель Боб, а во втором сете Вася");
    }
}
