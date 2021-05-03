package ThirdTask;
import java.util.ArrayList;

public class Sklad {
    ProductsSaver saver;
    ArrayList<Product> products;

    private ArrayList<ProductsListener> listeners = new ArrayList<>();

    public void addListener(ProductsListener listener){
        if (!listeners.contains(listener))
            listeners.add(listener);
    }

    public void removeListener(ProductsListener listener) {
        if (listeners.contains(listener))
            listeners.remove(listener);
    }

    public void addProduct(String name, int count) {
        boolean flag = false;
        for (int i = 0; i < products.size(); i++){
            if (products.get(i).getName().equals(name)){
                products.get(i).count = products.get(i).getCount() + count;
                System.out.println("New delivery for: " + products.get(i).getName() + " Count: " + count);
                flag = true;
            }
        }
        if (flag == false){
            createNewProduct(name, count);
        }
        for (ProductsListener l: listeners)
            l.productsUpdated(products);
    }

    public Sklad(ProductsSaver saver) {
        this.saver = saver;
        products = saver.getProducts();
    }

    public void createNewProduct(String name, int count) {
        Product product = new Product(name, count);
        products.add(product);
        System.out.println("On storage added new product. " + product);
        saver.saveProducts(products);
    }

    public Product getProduct(String name) {
        for (Product p : products) {
            if (p.name.equals(name))
                return p;
        }

        return null;
    }

    public void deleteProduct(String name, int i) {
        Product p = getProduct(name);

        if (p != null)
            products.remove(p);

        saver.saveProducts(products);
    }

    public void printAllProducts() {
        for (Product p : products) {
            System.out.println(p.name + ": " + p.count);
        }
    }
}