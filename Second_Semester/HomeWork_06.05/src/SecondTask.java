import java.util.function.Predicate;

public class SecondTask {

    public static int[] siftArray(int[] array, Predicate<Integer> predicate){
        int count = 0;
        for (int i = 0; i < array.length; i++){
            if (predicate.test(array[i])){
                count++;
            }
        }
        int[] resultArray = new int[count];
        for (int i = 0, j = 0; i < array.length; i++){
            if (predicate.test(array[i])){
                resultArray[j] = array[i];
                j++;
            }
        }

        return resultArray;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 7, 10, 15, 23};
        int[] even5Array = siftArray(array, x -> x % 5 == 0);
        for (int i = 0; i < even5Array.length; i++){
            System.out.println(even5Array[i]);        }
    }
}
