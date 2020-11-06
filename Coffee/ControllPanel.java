package Coffee;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class ControllPanel {
    private Cup OfCoffee;
    Storage sklad = new Storage();
    Cappuccino cappuccino = new Cappuccino();
    CoffeeMachine siemens = new CoffeeMachine();
    SelectedCoffee selectedCoffee = new SelectedCoffee();

    int n = 0;
    Scanner in = new Scanner(System.in);
    public static void assortment(){
        System.out.println("[1]Капучино [2]Американо [3]Горячий шоколад");
        System.out.println("[4]Латте    [5]Моккачино [6]Айриш");
        System.out.println("[7]Раф      [8]Фраппе    [9]Эспрессо");
        System.out.println("            [0]Отмена ");
    }

    public void choice(){
        System.out.println("Выберите подходящий вариант:");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        if (n == 1){
          selectedCoffee.setMilk(cappuccino.getMilk());
          selectedCoffee.setWater(cappuccino.getWater());
          selectedCoffee.setCoffeeBeans(cappuccino.getCoffeeBeans());
          if (sklad.checkCoffeeBeans() && sklad.checkMilk() && sklad.checkWater()){
              siemens.make();
              System.out.println("Ваш капучино готов");
          }
          else{
              System.out.println("У вас недастаточно какого-то ингридиента");
              System.out.println("Добавить ингридиенты?");
              in.nextLine();
              String flag1 = in.nextLine();
              if (flag1.equals("Да")){
                  sklad.addCoffeeBeans();
                  sklad.addMilk();
                  sklad.addWater();
                  choice();
              }
          }
        }
        else if(n == 2){

        }
    }
    public int getN(){
        return this.n;
    }

}
