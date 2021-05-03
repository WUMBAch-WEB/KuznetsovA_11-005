package ThirdTask;

import java.io.Serializable;

public class Product implements Serializable {
    String name;
    int count;

    public Product(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name of product: " + name + ", count: " + count;
    }
}