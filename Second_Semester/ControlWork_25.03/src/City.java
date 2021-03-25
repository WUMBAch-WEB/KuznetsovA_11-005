import java.util.ArrayList;

public class City {

    String name;
    ArrayList<Order> orders = new ArrayList<>();

    public City(String name, ArrayList<Order> orders){
        this.name = name;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}
