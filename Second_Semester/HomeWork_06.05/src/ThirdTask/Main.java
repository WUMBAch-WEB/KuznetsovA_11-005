package ThirdTask;
public class  Main {

    public static void main(String[] args) {
        ProductsFileSaver fileSaver = new ProductsFileSaver("products.txt");
        Sklad sklad = new Sklad(fileSaver);
        sklad.addListener((products) -> {
            int count = 0;
            int maxCount = -1;
            String productWithMaxCount = new String();
            for (Product product : products){
                System.out.println("Full list of products: ");
                System.out.println(product);
            }
            for (Product product: products){
                count += product.getCount();
                if (product.getCount() > maxCount){
                    maxCount = product.getCount();
                    productWithMaxCount = product.getName();
                }
            }
            System.out.println("Total count of products on storage is: " + count);
            System.out.println("Product: " + productWithMaxCount + " have max count on storage, namely: " + maxCount);
        });
        sklad.addProduct("sofa", 10);
        sklad.addProduct("pivo", 20);

    }
}