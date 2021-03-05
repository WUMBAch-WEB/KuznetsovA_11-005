import java.util.Scanner;
import java.util.Stack;

public class SecondTask {
    static boolean tryParseInt(String input) {
        try {
            Integer.parseInt(input);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        Stack<Integer> stack = new Stack<>();
        String string = in.nextLine();
        String[] array = string.split(" ");
        for (int i = 0; i < array.length; i++){
            if (tryParseInt(array[i])) {
                int x = Integer.parseInt(array[i]);
                stack.add(x);
            }
            if (array[i].equals("+")){
                int x = stack.pop();
                int y = stack.pop();
                int z = x + y;
                stack.add(z);
            }
            if (array[i].equals("-")){
                int x = stack.pop();
                int y = stack.pop();
                int z = y - x;

                stack.add(z);
            }
            if (array[i].equals("*")){
                int x = stack.pop();
                int y = stack.pop();
                int z = x * y;
                stack.add(z);
            }
            if (array[i].equals("/")){
                int x = stack.pop();
                int y = stack.pop();
                int z = x / y;
                stack.add(z);
            }
        }
        if (stack.size() == 1){
            System.out.println("Result: " + stack.pop());
        }
        else{
            System.out.println("Incorrect string");
        }
    }
}
