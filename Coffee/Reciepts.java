package Coffee;

public class Reciepts {
 public static class Americano{
     int milk = 2;
     int coffeeBeans = 3;
     int water = 1;
     public int getMilk(){
         return this.milk;
     }
     public  int getWater(){
         return this.water;
     }
     public int getCoffeeBeans(){
         return this.coffeeBeans;
     }
 }
    public static class Cappuccino {
        int milk = 2;
        int coffeeBeans = 3;
        int water = 1;
        public int getMilk(){
            return this.milk;
        }
        public  int getWater(){
            return this.water;
        }
        public int getCoffeeBeans(){
            return this.coffeeBeans;
        }
    }
    public static class HotChocolate{
        int milk = 2;
        int coffeeBeans = 3;
        int water = 1;
        public int getMilk(){
            return this.milk;
        }
        public  int getWater(){
            return this.water;
        }
        public int getCoffeeBeans(){
            return this.coffeeBeans;
        }
    }
    public static class Latte{
        int milk = 2;
        int coffeeBeans = 3;
        int water = 1;
        public int getMilk(){
            return this.milk;
        }
        public  int getWater(){
            return this.water;
        }
        public int getCoffeeBeans(){
            return this.coffeeBeans;
        }
    }
    public static class Mokka{
        int milk = 2;
        int coffeeBeans = 3;
        int water = 1;
        public int getMilk(){
            return this.milk;
        }
        public  int getWater(){
            return this.water;
        }
        public int getCoffeeBeans(){
            return this.coffeeBeans;
        }
    }
    public static class Irish{
        int milk = 2;
        int coffeeBeans = 3;
        int water = 1;
        public int getMilk(){
            return this.milk;
        }
        public  int getWater(){
            return this.water;
        }
        public int getCoffeeBeans(){
            return this.coffeeBeans;
        }
    }
    public static class Raf{
        int milk = 2;
        int coffeeBeans = 3;
        int water = 1;
        public int getMilk(){
            return this.milk;
        }
        public  int getWater(){
            return this.water;
        }
        public int getCoffeeBeans(){
            return this.coffeeBeans;
        }
    }
    public static class Frappe{
        int milk = 2;
        int coffeeBeans = 3;
        int water = 1;
        public int getMilk(){
            return this.milk;
        }
        public  int getWater(){
            return this.water;
        }
        public int getCoffeeBeans(){
            return this.coffeeBeans;
        }
    }
    public static class Espresso{
        int milk = 2;
        int coffeeBeans = 3;
        int water = 1;
        public int getMilk(){
            return this.milk;
        }
        public  int getWater(){
            return this.water;
        }
        public int getCoffeeBeans(){
            return this.coffeeBeans;
        }
    }
    public static class Assortment{
        public Assortment(Storage sklad){
            this.sklad = sklad;
        }
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
     SelectedCoffee selectedCoffee = new SelectedCoffee();
        Reciepts.Americano americano = new Reciepts.Americano();
        Reciepts.Cappuccino cappuccino =  new Reciepts.Cappuccino();
        Reciepts.HotChocolate hotChocolate = new Reciepts.HotChocolate();
        Reciepts.Latte latte = new Reciepts.Latte();
        Reciepts.Mokka mokka = new Reciepts.Mokka();
        Reciepts.Irish irish = new Reciepts.Irish();
        Reciepts.Raf raf =  new Reciepts.Raf();
        Reciepts.Frappe frappe = new Reciepts.Frappe();
        Reciepts.Espresso espresso = new Reciepts.Espresso();
        Storage sklad;
        String[] assort = {"[0]Отмена", "[1]Капучино", "[2]Американо",
                "[3]Горячий шоколад", "[4]Латте", "[5]Моккачино",
                "[6]Айриш", "[7]Раф", "[8]Фраппе", "[9]Эспрессо"};
        public void screen(){
            for (int i = 0; i < 10; i++){
                if (i == 1){
                    selectedCoffee.setMilk(cappuccino.getMilk());
                    selectedCoffee.setWater(cappuccino.getWater());
                    selectedCoffee.setCoffeeBeans(cappuccino.getCoffeeBeans());
                    if (sklad.checkCoffeeBeans(selectedCoffee) && sklad.checkMilk(selectedCoffee) && sklad.checkWater(selectedCoffee)){
                        System.out.println(ANSI_GREEN + assort[i] + ANSI_RESET);
                    }
                    else{
                        System.out.println(ANSI_RED + assort[i] + ANSI_RESET);
                    }
                }
                if (i == 2){
                    selectedCoffee.setMilk(americano.getMilk());
                    selectedCoffee.setWater(americano.getWater());
                    selectedCoffee.setCoffeeBeans(americano.getCoffeeBeans());
                    if (sklad.checkCoffeeBeans(selectedCoffee) && sklad.checkMilk(selectedCoffee) && sklad.checkWater(selectedCoffee)){
                        System.out.println(ANSI_GREEN + assort[i] + ANSI_RESET);
                    }
                    else{
                        System.out.println(ANSI_RED + assort[i] + ANSI_RESET);
                    }
                }
                if (i == 3){
                    selectedCoffee.setMilk(hotChocolate.getMilk());
                    selectedCoffee.setWater(hotChocolate.getWater());
                    selectedCoffee.setCoffeeBeans(hotChocolate.getCoffeeBeans());
                    if (sklad.checkCoffeeBeans(selectedCoffee) && sklad.checkMilk(selectedCoffee) && sklad.checkWater(selectedCoffee)){
                        System.out.println(ANSI_GREEN + assort[i] + ANSI_RESET);
                    }
                    else{
                        System.out.println(ANSI_RED + assort[i] + ANSI_RESET);
                    }
                }
                if (i == 4){
                    selectedCoffee.setMilk(latte.getMilk());
                    selectedCoffee.setWater(latte.getWater());
                    selectedCoffee.setCoffeeBeans(latte.getCoffeeBeans());
                    if (sklad.checkCoffeeBeans(selectedCoffee) && sklad.checkMilk(selectedCoffee) && sklad.checkWater(selectedCoffee)){
                        System.out.println(ANSI_GREEN + assort[i] + ANSI_RESET);
                    }
                    else{
                        System.out.println(ANSI_RED + assort[i] + ANSI_RESET);
                    }

                }
                if (i == 5){
                    selectedCoffee.setMilk(mokka.getMilk());
                    selectedCoffee.setWater(mokka.getWater());
                    selectedCoffee.setCoffeeBeans(mokka.getCoffeeBeans());
                    if (sklad.checkCoffeeBeans(selectedCoffee) && sklad.checkMilk(selectedCoffee) && sklad.checkWater(selectedCoffee)){
                        System.out.println(ANSI_GREEN + assort[i] + ANSI_RESET);
                    }
                    else{
                        System.out.println(ANSI_RED + assort[i] + ANSI_RESET);
                    }
                }
                if (i == 6){
                    selectedCoffee.setMilk(irish.getMilk());
                    selectedCoffee.setWater(irish.getWater());
                    selectedCoffee.setCoffeeBeans(irish.getCoffeeBeans());
                    if (sklad.checkCoffeeBeans(selectedCoffee) && sklad.checkMilk(selectedCoffee) && sklad.checkWater(selectedCoffee)){
                        System.out.println(ANSI_GREEN + assort[i] + ANSI_RESET);
                    }
                    else{
                        System.out.println(ANSI_RED + assort[i] + ANSI_RESET);
                    }
                }
                if (i == 7){
                    selectedCoffee.setMilk(raf.getMilk());
                    selectedCoffee.setWater(raf.getWater());
                    selectedCoffee.setCoffeeBeans(raf.getCoffeeBeans());
                    if (sklad.checkCoffeeBeans(selectedCoffee) && sklad.checkMilk(selectedCoffee) && sklad.checkWater(selectedCoffee)){
                        System.out.println(ANSI_GREEN + assort[i] + ANSI_RESET);
                    }
                    else{
                        System.out.println(ANSI_RED + assort[i] + ANSI_RESET);
                    }
                }
                if (i == 8){
                    selectedCoffee.setMilk(frappe.getMilk());
                    selectedCoffee.setWater(frappe.getWater());
                    selectedCoffee.setCoffeeBeans(frappe.getCoffeeBeans());
                    if (sklad.checkCoffeeBeans(selectedCoffee) && sklad.checkMilk(selectedCoffee) && sklad.checkWater(selectedCoffee)){
                        System.out.println(ANSI_GREEN + assort[i] + ANSI_RESET);
                    }
                    else{
                        System.out.println(ANSI_RED + assort[i] + ANSI_RESET);
                    }
                }
                if (i == 9){
                    selectedCoffee.setMilk(espresso.getMilk());
                    selectedCoffee.setWater(espresso.getWater());
                    selectedCoffee.setCoffeeBeans(espresso.getCoffeeBeans());
                    if (sklad.checkCoffeeBeans(selectedCoffee) && sklad.checkMilk(selectedCoffee) && sklad.checkWater(selectedCoffee)){
                        System.out.println(ANSI_GREEN + assort[i] + ANSI_RESET);
                    }
                    else{
                        System.out.println(ANSI_RED + assort[i] + ANSI_RESET);
                    }
                }
                if (i == 0){
                    System.out.println(ANSI_RED + assort[i] + ANSI_RESET);
                }
            }
        }
    }
}

