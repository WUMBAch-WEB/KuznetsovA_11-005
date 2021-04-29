public class Main {
    public static void main(String[] args) {
        ProductsFileSaver fileSaver = new ProductsFileSaver("products.txt");
        Sklad sklad = new Sklad(fileSaver);

        sklad.createNewProduct("chair", 10);
        sklad.createNewProduct("table", 5);

        sklad.printAllProducts();
    }
}