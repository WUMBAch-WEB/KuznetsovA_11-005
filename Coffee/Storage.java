package Coffee;

public class Storage{
    Cappuccino cappuccino = new Cappuccino();
    SelectedCoffee selectedCoffee = new SelectedCoffee();
    int bottleOfMilk = 3;
    int bottleOfWater = 3;
    int packOfCoffeeBeans = 3;
    int milk = 0;
    int water = 0;
    int coffeeBeans = 0;


    public void addMilk(){
        if (bottleOfMilk > 0){
            bottleOfMilk -= 1;
            milk += 1000;
        }
    }
    public void addWater(){
        if (bottleOfWater > 0){
            bottleOfWater -= 1;
            water += 1000;
        }
    }
    public void addCoffeeBeans(){
        if (packOfCoffeeBeans > 0){
            packOfCoffeeBeans -= 1;
            coffeeBeans += 100;
        }
    }
    public int getMilk(){
        return this.milk;
    }
    public  int getWater(){
        return this.water;
    }
    public int getCoffeeBeans(){
        return this.coffeeBeans;
    }

    public boolean checkMilk(){
        boolean checkMilk = false;
        if (getMilk() >= selectedCoffee.getMilk()){
            checkMilk = true;
        }
        return checkMilk;
    }
    public boolean checkWater(){
        boolean checkWater = false;
        if (getWater() >= selectedCoffee.getWater()){
            checkWater = true;
        }
        return checkWater;
    }
    public boolean checkCoffeeBeans(){
        boolean checkCoffeeBeans = false;
        if (getCoffeeBeans() >= selectedCoffee.getCoffeeBeans()){
            checkCoffeeBeans = true;
        }
        return checkCoffeeBeans;
    }

}
