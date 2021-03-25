import java.util.ArrayList;

public class City {

    String name;
    ArrayList<Order> orders = new ArrayList<>();

    public City(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}
