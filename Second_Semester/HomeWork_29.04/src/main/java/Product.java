import java.io.Serializable;

public class Product implements Serializable {
    String name;
    int count;

    public Product(String name, int count) {
        this.name = name;
        this.count = count;
    }
}