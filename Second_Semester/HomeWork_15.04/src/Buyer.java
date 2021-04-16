import java.util.HashMap;

public class Buyer {
    public String name;
    HashMap<String, String> ticketsMap;

    public Buyer(String name){
        this.name = name;
        this.ticketsMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public HashMap<String, String> getTicketsMap() {
        return ticketsMap;
    }
}
