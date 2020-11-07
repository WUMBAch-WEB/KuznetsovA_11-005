package Coffee;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class ControllPanel {
    private Cup OfCoffee;
    Storage sklad = new Storage();
    Reciepts.Americano americano = new Reciepts.Americano();
    Reciepts.Cappuccino cappuccino =  new Reciepts.Cappuccino();
    Reciepts.HotChocolate hotChocolate = new Reciepts.HotChocolate();
    Reciepts.Latte latte = new Reciepts.Latte();
    Reciepts.Mokka mokka = new Reciepts.Mokka();
    Reciepts.Irish irish = new Reciepts.Irish();
    Reciepts.Raf raf =  new Reciepts.Raf();
    Reciepts.Frappe frappe = new Reciepts.Frappe();
    Reciepts.Espresso espresso = new Reciepts.Espresso();
    CoffeeMachine siemens = new CoffeeMachine();
    SelectedCoffee selectedCoffee = new SelectedCoffee();
    public boolean falseCheckCoffeeBeans(){
         boolean falseCheckCoffeeBeans = false;
        if (sklad.checkCoffeeBeans(selectedCoffee) == false){
            System.out.println("У вас недостаточно кофейных зерен.");
            System.out.println("[1] Добавить зерна   [2] Выбрать другое кофе");
            int flagCoffeeBeans = in.nextInt();
            if (flagCoffeeBeans == 1){
                sklad.addCoffeeBeans();
                System.out.println("Зерна успешно добавлены");
                falseCheckCoffeeBeans = true;
            }
            if (flagCoffeeBeans == 2){
                choice();
            }
        }
        return falseCheckCoffeeBeans;
    }
    public boolean falseCheckMilk(){
        boolean falseCheckMilk = false;
        if (sklad.checkMilk(selectedCoffee) == false){
            System.out.println("У вас недостаточно молока.");
            System.out.println("[1] Добавить молоко   [2] Выбрать другое кофе");
            int flagMilk = in.nextInt();
            if (flagMilk == 1){
                sklad.addMilk();
                System.out.println("Молоко успешно добавлено");
                falseCheckMilk = true;
            }
            if (flagMilk == 2){
                choice();
            }
        }
        return falseCheckMilk;
    }
    public boolean falseCheckWater(){
        boolean falseCheckWater = false;
        if (sklad.checkWater(selectedCoffee) == false){
            System.out.println("У вас недостаточно воды.");
            System.out.println("[1] Добавить воду   [2] Выбрать другое кофе");
            int flagWater = in.nextInt();
            if (flagWater == 1){
                sklad.addWater();
                System.out.println("Вода успешно добавлена");
                falseCheckWater = true;
            }
            if (flagWater == 2){
                choice();
            }
        }
        return falseCheckWater;
    }

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
        assortment();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        if (n == 1){
          selectedCoffee.setMilk(cappuccino.getMilk());
          selectedCoffee.setWater(cappuccino.getWater());
          selectedCoffee.setCoffeeBeans(cappuccino.getCoffeeBeans());
          if (sklad.checkCoffeeBeans(selectedCoffee) == false){
              falseCheckCoffeeBeans();
          }
          if (sklad.checkMilk(selectedCoffee) == false){
              falseCheckMilk();
          }
          if (sklad.checkWater(selectedCoffee) == false){
              falseCheckWater();
          }
          if (sklad.checkCoffeeBeans(selectedCoffee) && sklad.checkMilk(selectedCoffee) && sklad.checkWater(selectedCoffee)){
              siemens.make();
              System.out.println("Ваш капучино готов");
          }
        }
        if(n == 2){
            selectedCoffee.setMilk(americano.getMilk());
            selectedCoffee.setWater(americano.getWater());
            selectedCoffee.setCoffeeBeans(americano.getCoffeeBeans());
            if (sklad.checkCoffeeBeans(selectedCoffee) == false){
                falseCheckCoffeeBeans();
            }
            if (sklad.checkMilk(selectedCoffee) == false){
                falseCheckMilk();
            }
            if (sklad.checkWater(selectedCoffee) == false){
                falseCheckWater();
            }
            if (sklad.checkCoffeeBeans(selectedCoffee) && sklad.checkMilk(selectedCoffee) && sklad.checkWater(selectedCoffee)){
                siemens.make();
                System.out.println("Ваш американо готов");
            }
        }
        if (n == 3){
            selectedCoffee.setMilk(hotChocolate.getMilk());
            selectedCoffee.setWater(hotChocolate.getWater());
            selectedCoffee.setCoffeeBeans(hotChocolate.getCoffeeBeans());
            if (sklad.checkCoffeeBeans(selectedCoffee) == false){
                falseCheckCoffeeBeans();
            }
            if (sklad.checkMilk(selectedCoffee) == false){
                falseCheckMilk();
            }
            if (sklad.checkWater(selectedCoffee) == false){
                falseCheckWater();
            }
            if (sklad.checkCoffeeBeans(selectedCoffee) && sklad.checkMilk(selectedCoffee) && sklad.checkWater(selectedCoffee)){
                siemens.make();
                System.out.println("Ваш горячий шоколад готов");
            }
        }
    }
    public int getN(){
        return this.n;
    }

}
