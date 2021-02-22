package Coffee;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class ControlPanel {

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
    Reciepts.Assortment assort = new Reciepts.Assortment(sklad);
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
    public boolean checkCaramelSyrup(){
        boolean checkCaramelSyrup = false;
        if (sklad.caramelSyrup == 0){
            System.out.println("У вас недостаточно сиропа.");
            System.out.println("[1] Добавить сироп на склад   [2] Сделать кофе без сиропа ");
            int flagCaramelSyrup = in.nextInt();
            if (flagCaramelSyrup == 1){
                sklad.addCaramelSyrupToStorage();
                System.out.println("Сироп успешно добавлен на склад");
                checkCaramelSyrup = true;
            }
            if (flagCaramelSyrup == 2){
                checkCaramelSyrup = false;
            }
        }
        return checkCaramelSyrup;
    }
    public boolean checkSugar(){
        boolean checkSugar = false;
        System.out.println("Сколько порций сахара добавить?");
        int count = in.nextInt();
        if ((sklad.sugar - count) <= 0 ){
            System.out.println("У вас недостаточно сахара.");
            System.out.println("[1] Добавить сахар на склад   [2] Сделать кофе без сахара ");
            int flagSugar = in.nextInt();
            if (flagSugar == 1){
                sklad.addSugarToStorage();
                System.out.println("Сахар успешно добавлен на склад");
                sklad.sugar -= count;
                checkSugar = true;
            }
            if (flagSugar == 2){
                checkSugar = false;
            }
        }
        return checkSugar;
    }

    int n = 0;
    Scanner in = new Scanner(System.in);
    public void newCup(){
        Scanner in = new Scanner(System.in);
        System.out.println("Хотите еще чашечку?");
        String newcup = in.nextLine();
        if (newcup.equals("Да")){
            choice();
        }
        else{
            System.out.println("Всего доброго");
            System.exit(0);
        }
    }
    public void addCaramelSyrup(){
        System.out.println("Хотите добавить карамельный сироп?");
        in.nextLine();
        String flagCaramelSyrup = in.nextLine();
        if (flagCaramelSyrup.equals("Да")){
            if (checkCaramelSyrup()){
                System.out.println("Сироп успешно добавлен в кофе");
                sklad.caramelSyrup -= 1;
            }
        }
    }
    public void addSugar(){
        System.out.println("Хотите добавить сахар в кофе?");
        in.nextLine();
        String flagSugar = in.nextLine();
        if (flagSugar.equals("Да")){
            if (checkSugar()){
                System.out.println("Сахар успешно добавлен в кофе");
            }
        }
    }


    public void choice(){
        System.out.println("Выберите подходящий вариант:");
        assort.screen();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        if (n == 1){
          selectedCoffee.setMilk(cappuccino.getMilk());
          selectedCoffee.setWater(cappuccino.getWater());
          selectedCoffee.setCoffeeBeans(cappuccino.getCoffeeBeans());
          if (!sklad.checkCoffeeBeans(selectedCoffee)){
              falseCheckCoffeeBeans();
          }
          if (!sklad.checkMilk(selectedCoffee)){
              falseCheckMilk();
          }
          if (!sklad.checkWater(selectedCoffee)){
              falseCheckWater();
          }
          if (sklad.checkCoffeeBeans(selectedCoffee) && sklad.checkMilk(selectedCoffee) && sklad.checkWater(selectedCoffee)){
              siemens.espresso();
              siemens.cappuccino();
              addCaramelSyrup();
              addSugar();
              System.out.println("Ваш капучино готов");
              newCup();
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
                siemens.espresso();
                siemens.americano();
                System.out.println("Ваш американо готов");
                newCup();
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
                siemens.hotChocolate();
                choice();
            }
        }
        if (n == 4){
            selectedCoffee.setMilk(latte.getMilk());
            selectedCoffee.setWater(latte.getWater());
            selectedCoffee.setCoffeeBeans(latte.getCoffeeBeans());
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
                System.out.println("Ваш латте готов");
            }
        }
        if (n == 5){
            selectedCoffee.setMilk(mokka.getMilk());
            selectedCoffee.setWater(mokka.getWater());
            selectedCoffee.setCoffeeBeans(mokka.getCoffeeBeans());
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
                System.out.println("Ваш моккачино готов");
            }
        }
        if (n == 6){
            selectedCoffee.setMilk(irish.getMilk());
            selectedCoffee.setWater(irish.getWater());
            selectedCoffee.setCoffeeBeans(irish.getCoffeeBeans());
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
                System.out.println("Ваш айриш готов");
            }
        }
        if (n == 7){
            selectedCoffee.setMilk(raf.getMilk());
            selectedCoffee.setWater(raf.getWater());
            selectedCoffee.setCoffeeBeans(raf.getCoffeeBeans());
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
                System.out.println("Ваш раф готов");
            }
        }
        if (n == 8){
            selectedCoffee.setMilk(frappe.getMilk());
            selectedCoffee.setWater(frappe.getWater());
            selectedCoffee.setCoffeeBeans(frappe.getCoffeeBeans());
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
                System.out.println("Ваш фраппе готов");
            }
        }
        if (n == 9){
            selectedCoffee.setMilk(espresso.getMilk());
            selectedCoffee.setWater(espresso.getWater());
            selectedCoffee.setCoffeeBeans(espresso.getCoffeeBeans());
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
                siemens.espresso();
                System.out.println("Ваш эспрессо готов");
            }
        }
        if (n == 0){
            System.out.println("пошел нахуй");
            System.exit(0);
        }
    }
    public int getN(){
        return this.n;
    }


}
