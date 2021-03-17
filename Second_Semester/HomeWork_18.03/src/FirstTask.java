import java.util.*;

public class FirstTask {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String string = in.nextLine();
        String[] array = string.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++){
            if (map.containsKey(array[i])){
                map.put(array[i], map.get(array[i]) + 1 );
            }
            else {
                map.put(array[i], 1);
            }
        }
        Set<String> keys = map.keySet();
        ArrayList<Integer> values = new ArrayList<>(map.values());
        System.out.println("Ключи: " + keys);
        System.out.println("Значения: " + values);
        System.out.println(map);
    }

}
