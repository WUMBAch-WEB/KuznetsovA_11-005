package Coffee;
import java.util.Scanner;

public class Main {

    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        ControlPanel admin = new ControlPanel();
        CoffeeMachine siemens = new CoffeeMachine();
        SelectedCoffee bla = new SelectedCoffee();

        System.out.println("Вы купили кофемашинку и привезли ее домой.");
        System.out.println("Чтобы начать пользовать кофемашинкой ее нужно подключить к электросети и включить ее.");
        System.out.println("Включить кофемашинку?");
        String flag = in.nextLine();
        if (flag.equals("Да")){
          siemens.plug();
          admin.choice();

        }
        else{
            System.out.println(".....");
            System.exit(0);
        }
    }
}
