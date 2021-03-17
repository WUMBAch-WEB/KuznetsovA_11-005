import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class ThirdTask {

    static boolean tryParseInt(String input){
        try {
            Integer.parseInt(input);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    static String[] cleanArray(String str){
        String fixedStr = str.replaceAll("[:.,!\\\"]", " ");
        String[] array = fixedStr.split("\\s+");
        for (int i = 0; i < array.length; i++){
            if (!tryParseInt(array[i])){
                array[i] = array[i].toLowerCase(Locale.ROOT);
            }
        }
        return array;
    }

    public static Map<String, Map<String, Integer>> analyseNewString(String string, Map<String, Map<String, Integer>> map){
        String[] array = cleanArray(string);
        String[] finalArray = new String[array.length + 2];
        finalArray[0] = "start";
        finalArray[array.length + 1] = "end";
        for (int i = 1; i < finalArray.length - 1; i++){
            finalArray[i] = array[i - 1];
        }
        for (int i = 0; i < finalArray.length; i ++) {
            if (finalArray[i].equals("end")) {

            }
            else {
                if (map.containsKey(finalArray[i])){
                    if (map.get(finalArray[i]).containsKey(finalArray[i + 1])){
                        map.get(finalArray[i]).put(finalArray[i + 1], map.get(finalArray[i]).get(finalArray[i + 1]) + 1);

                    }
                    else {
                        map.get(finalArray[i]).put(finalArray[i + 1], 1);

                    }
                }
                else {
                    Map<String, Integer> wordMap = new HashMap<>();
                    wordMap.put(finalArray[i + 1], 1);
                    map.put(finalArray[i], wordMap);

                }
            }
        }
        return map;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Integer>> chain = new HashMap<>();
        System.out.println("Добро пожаловать в генератор цепи Маркова.");
        boolean flag = true;
        while (flag){
            System.out.println("Выберете дальнейшее действие: ");
            System.out.println("[1]Обработать строку, введенную с консоли [2]Обработать файл [3]Показать результат [4]Завершить работу ");
            String choice = in.nextLine();
            switch (choice){
                case "1":
                    System.out.println("Введите строку: ");
                    String string = buff.readLine();
                    analyseNewString(string, chain);
                    break;
                case "2":
                    System.out.print("Введите полный путь до файла: ");
                    String way = in.nextLine();
                    BufferedReader buffFile = new BufferedReader(new FileReader(way)); // C:\Users\WUMBAch\Downloads\test.txt
                    String s;
                    while ((s = buffFile.readLine()) != null){
                        analyseNewString(s, chain);
                    }
                    break;
                case "3":
                    System.out.println(chain);
                    break;
                case "4":
                    flag = false;
                    break;
                default:
                    System.out.println("Функции с таким номером не существует.");
                    break;
            }
        }
    }
}
