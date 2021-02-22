package Coffee;

public class SelectedCoffee<n> {
    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    int milk = 0;
    int water = 0;
    int coffeeBeans = 0;
    public int getMilk(){
        return milk;
    }
    public  int getWater(){
        return water;
    }
    public int getCoffeeBeans(){
        return coffeeBeans;
    }

}
