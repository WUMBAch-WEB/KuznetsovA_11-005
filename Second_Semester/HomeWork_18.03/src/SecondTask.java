import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class SecondTask
{
    static boolean tryParseInt(String input){
        try {
            Integer.parseInt(input);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    static String[] cleanArray(String purchase){
        for (int i = 0; i < purchase.length(); i++){
            boolean flag1 = false;
            boolean flag2 = false;
            boolean flag3 = false;
            if (purchase.charAt(i) == ',' && flag1 == false){
                purchase = purchase.replaceAll(",", " ");
                flag1 = true;
            }
            if (purchase.charAt(i) == '.' && flag2 == false){
                purchase = purchase.replaceAll(".", " ");
                flag2 = true;
            }
            if (purchase.charAt(i) == '!' && flag3 == false){
                purchase = purchase.replaceAll("!", " ");
                flag3 = true;
            }
        }
        purchase = purchase.replaceAll("  ", " ");
        String[] array = purchase.split(" ");
        for (int i = 0; i < array.length; i++){
            if (!tryParseInt(array[i])){
                array[i] = array[i].toLowerCase(Locale.ROOT);
            }
        }
        return array;
    }

    public static Map<String, Map<String, Integer>> addNewPurchase(String purchase, Map<String, Map<String, Integer>> buyerAndPurchases) {
        Map<String, Integer> purchaseAndCount = new HashMap<>();
        String[] array = cleanArray(purchase);
        boolean flag = false;
        if (array.length != 3) {
            System.out.println("Incorrect string");
        } else if (tryParseInt(array[2])) {
            flag = true;
        } else {
            System.out.println("Incorrect string");
        }
        if (flag) {
            if (buyerAndPurchases.containsKey(array[0])) {
                if (buyerAndPurchases.get(array[0]).containsKey(array[1])) {
                    Integer count = Integer.parseInt(array[2]);
                    buyerAndPurchases.get(array[0]).put(array[1], buyerAndPurchases.get(array[0]).get(array[1]) + count);
                } else {
                    Integer count = Integer.parseInt(array[2]);
                    buyerAndPurchases.get(array[0]).put(array[1], count);
                }
            } else {
                Integer count = Integer.parseInt(array[2]);
                purchaseAndCount.put(array[1], count);
                buyerAndPurchases.put(array[0], purchaseAndCount);
            }

        }
        return buyerAndPurchases;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        Map<String, Map<String, Integer>> buyerAndPurchases = new HashMap<>();
        System.out.println("Добро пожаловать в менеджер покупок.");
        while (flag) {
            System.out.println("Выберите необходимое действие: ");
            System.out.println("[1]Добавить покупку [2]Вывести общий список покупок [3]Завершить работу программы");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Введите покупку ниже: ");
                    System.out.println("Обратите внимание, что строка должна быть следующей формы: ");
                    System.out.println("Покупатель товар кол-во");
                    String purchase = buff.readLine();
                    addNewPurchase(purchase, buyerAndPurchases);
                    break;
                case 2:
                    System.out.println(buyerAndPurchases);
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Функции с таким номером не существует.");;
            }
        }
    }
}
