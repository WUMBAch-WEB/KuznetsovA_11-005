package OnlineShop;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    AbstractEngineOfShop engine;
    AdminPanel adminPanel;
    private String status;
    String recipient;
    private String priceOfProduct;
    private String nameOfProduct;
    private String producerOfProduct;
    private String setName;
    private String setRecipient;
    public void setDataForOrder(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите название продукта, который хотите заказать: ");
        setName = in.next();
        boolean flag = false;
        for (int i = 0; i <= adminPanel.getProductsList().size() - 1; i++){
            if ((adminPanel.getProductsList().get(i).getNameOfProduct()).equals(setName)){
                flag = true;
                nameOfProduct = adminPanel.getProductsList().get(i).getNameOfProduct();
                producerOfProduct = adminPanel.getProductsList().get(i).getProducerOfProduct();
                priceOfProduct = adminPanel.getProductsList().get(i).getPriceOfProduct();
            }
        }
        if (!flag){
            System.out.println("Продукт с таким названием не найден.");
        }
    }
    public String  setRecipient(){
        Scanner in = new Scanner(System.in);
        System.out.print("Укажите ваш никнейм: ");
        setRecipient = in.next();
        boolean flag = false;
        for (int i = 1; i <= engine.getBuyersList().size() - 1; i++){
            if ((engine.getBuyersList().get(i).getNickName()).equals(setRecipient)){
                flag = true;
                recipient = engine.getBuyersList().get(i).getUserName();
                return recipient;
            }
        }
        if (!flag){
            System.out.println("Аккаунт с таким никнеймом не найден.");
        }
        return null;
    }
    public Order(AbstractEngineOfShop engine,  AdminPanel adminPanel){
        this.engine = engine;
        this.adminPanel = adminPanel;
        this.status = "Ожидает оплаты";
        this.setDataForOrder();
        this.recipient = setRecipient();
    }
    public void showInfoAboutOrder(){
        System.out.println("О товаре: ");
        System.out.println("Название: " + this.nameOfProduct);
        System.out.println("Цена: " + this.priceOfProduct);
        System.out.println("Производитель: " + this.producerOfProduct);
        System.out.println("О заказе: ");
        System.out.println("Получатель: " + this.recipient);
        System.out.println("Статус: " + this.status);
    }
}

