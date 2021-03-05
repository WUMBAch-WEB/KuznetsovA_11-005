import java.util.Scanner;
import java.util.Stack;

public class FirstTask {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        Stack<Character> stack = new Stack<>();
        String string = in.next();
        char[] array = string.toCharArray();
        boolean flag = true;
        for (int i = 0; i < string.length(); i++){
            if (array[i] == '['){
                stack.add(array[i]);
            }
            if (array[i] == '('){
                stack.add(array[i]);
            }
            if (array[i] == '{'){
                stack.add(array[i]);
            }
            if (array[i] == ']'){
                char a = stack.peek();
                if (a == '['){
                    stack.pop();
                }
                else{
                    System.out.println("Error");
                    flag = false;
                    break;
                }
            }
            if (array[i] == ')'){
                char a = stack.peek();
                if (a == '('){
                    stack.pop();
                }
                else{
                    System.out.println("Error");
                    flag = false;
                    break;
                }
            }
            if (array[i] == '}'){
                char a = stack.peek();
                if (a == '{'){
                    stack.pop();
                }
                else{
                    System.out.println("Error");
                    flag = false;
                    break;
                }
            }
        }
        if (stack.empty() == false && flag == true){
            System.out.println("Error: Unclosed brackets");
        }
    }
}
