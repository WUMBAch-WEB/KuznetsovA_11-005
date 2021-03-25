import java.util.ArrayList;
import java.util.Map;

public class Buyer {
    String name;
    ArrayList<City> cities = new ArrayList<>();

    public Buyer(String name, ArrayList<City> cities){
        this.name = name;
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public ArrayList<City> getCities(Map<String, Map<String, Integer>> cities) {
        return (ArrayList<City>) cities;
    }
}
