package OnlineShop;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminPanel extends Souts{
    AbstractEngineOfShop engine;
    ArrayList<Product> productsList = new ArrayList<>();
    UserPanel userPanel;
    private String nickName;
    private String password;
    private String nameOfProduct;
    public AdminPanel(){

    }
    public AdminPanel(AbstractEngineOfShop engine) {
        this.nickName = "ADMINnick";
        this.password = "ADMINpass";
        this.engine = engine;
    }
    public void adminChoice(){
        Scanner in = new Scanner(System.in);
        messageAboutFunctionsOfAdmin();
        int flag = in.nextInt();
        if (flag == 1){
            engine.showAllBuyers();
        }
        if (flag == 2){
            banUser();
        }
        if (flag == 3){
            addNewProduct();
        }
        if (flag == 4){
            deleteProduct();
        }
        if (flag == 6){
            showAllProducts();
        }
        if (flag == 7){
            exitFromAdminAccount();
        }
    }
    public void exitFromAdminAccount(){
        welcomeMessage();
        engine.choiceSignUpOrSignIn();
    }
    public void addNewProduct(){
        Product product = new Product();
        productsList.add(product);
        System.out.println("Товар успешно добавлен.");
        adminChoice();
    }
    public void banUser(){
        Scanner in = new Scanner(System.in);
        System.out.print("Укажите никнейм пользователя, которого необходимо заблокировать: ");
        nickName = in.nextLine();
        boolean flag1 = false;
        for (int i = 0; i <= engine.getBuyersList().size() - 1; i++){
            if ((engine.getBuyersList().get(i).getNickName()).equals(nickName)){
                flag1 = true;
                engine.getBuyersList().get(i).showInfoAboutUser();
                System.out.println("Вы уверены, что хотите заблокировать этого пользователя? (y / n)");
                String flag = in.nextLine();
                if (flag.equals("y")){
                    engine.getBuyersList().remove(i);
                    System.out.println("Пользователь удален из базы.");
                    adminChoice();
                }
                if (flag.equals("n")){
                    adminChoice();
                }
            }
        }
        if (flag1){
            System.out.println("Пользователь с таким никнеймом не найден.");
            adminChoice();
        }
    }
    public void deleteProduct(){
        Scanner in = new Scanner(System.in);
        System.out.print("Укажите название товара, который хотите удалить: ");
        nameOfProduct = in.nextLine();
        boolean flag1 = false;
        for (int i = 0; i <= productsList.size() - 1; i++){
            if ((productsList.get(i).getNameOfProduct()).equals(nameOfProduct)){
                flag1 = true;
                productsList.get(i).showInfoAboutProduct();
                System.out.println("Вы уверены, что хотите удалить этот товар? (y / n)");
                String flag = in.nextLine();
                if (flag.equals("y")){
                    productsList.remove(i);
                    System.out.println("Товар успешно удален.");
                    adminChoice();
                }
                if (flag.equals("n")){
                    adminChoice();
                }
            }
        }
        if (flag1){
            System.out.println("Товар с таким названием не найден.");
            adminChoice();
        }
    }
    public void showAllProducts(){
        for (int i = 0; i <= productsList.size() - 1; i++){
            productsList.get(i).showInfoAboutProduct();
        }
        System.out.println("Все товары выведены.");
        adminChoice();
    }
    public ArrayList<Product> getProductsList(){
        return productsList;
    }
}
