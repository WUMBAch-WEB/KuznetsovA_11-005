public class Order {
    String name;
    int count;

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public Order(String name, int count){
        this.name = name;
        this.count = count;
    }

    public String toString(){
        return "Покупка: " + name + " | " + "Кол-во: " + count;
    }
}
