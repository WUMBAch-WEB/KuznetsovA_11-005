

public class Product {
    private String name;
    private int count;

    Product(String name, int count){
        this.name = name;
        this.count = count;
    }

    public int getCount(){
        return count;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return "Товар: " + name + " | Кол-во на складе: " + count;
    }

    public void incCount(int count){ this.count += count; }

    public Boolean equals(Product product) {
        if (this.name.equals(product.name)){ return true; }
        else{ return false; }
    }
}
