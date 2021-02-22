package Coffee;

public class Storage{

    int bottleOfMilk = 3;
    int bottleOfWater = 3;
    int bottleOfCaramelSyrup = 3;
    int packOfCoffeeBeans = 3;
    int packOfSugar = 3;
    int milk = 0;
    int water = 0;
    int coffeeBeans = 0;
    int caramelSyrup = 0;
    int sugar = 0;

    public void addSugarToStorage(){
        packOfSugar -= 1;
        sugar += 10;
    }
    public void addCaramelSyrupToStorage(){
        bottleOfCaramelSyrup -= 1;
        caramelSyrup += 5;
    }

    public void addMilk(){
        if (bottleOfMilk > 0){
            bottleOfMilk -= 1;
            milk += 50;
        }
    }
    public void addWater(){
        if (bottleOfWater > 0){
            bottleOfWater -= 1;
            water += 50;
        }
    }
    public void addCoffeeBeans(){
        if (packOfCoffeeBeans > 0){
            packOfCoffeeBeans -= 1;
            coffeeBeans += 20;
        }
    }

    public boolean checkMilk(SelectedCoffee selectedCoffee){
        return milk >= selectedCoffee.getMilk();
    }
    public boolean checkWater(SelectedCoffee selectedCoffee){

        return water >= selectedCoffee.getWater();
    }
    public boolean checkCoffeeBeans(SelectedCoffee selectedCoffee){
        return coffeeBeans >= selectedCoffee.getCoffeeBeans();
    }



}
