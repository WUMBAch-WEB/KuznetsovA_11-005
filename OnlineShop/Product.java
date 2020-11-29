package OnlineShop;

import java.util.Scanner;

public class Product {
    private String nameOfProduct;
    private String  price;
    private String producer;
    Scanner in = new Scanner(System.in);
    public Product(){
        System.out.print("Введите название товара: ");
        this.nameOfProduct = in.nextLine();
        System.out.print("Введите цену товара: ");
        this.price = in.next();
        System.out.print("Укажите производителя товара: ");
        this.producer = in.next();
    }
    public void showInfoAboutProduct(){
        System.out.println("Название товара: " + this.nameOfProduct);
        System.out.println("Цена: " + this.price);
        System.out.println("Производитель: " + this.producer);
    }
    public String getNameOfProduct(){
        return this.nameOfProduct;
    }
    public String getProducerOfProduct() { return this.producer; }
    public String getPriceOfProduct() { return this.price; }
}
