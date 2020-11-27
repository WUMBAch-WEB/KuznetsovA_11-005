package OnlineShop;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminPanel extends Souts{
    AbstractEngineOfShop engine;
    ArrayList<Product> productsList = new ArrayList<>();
    private String nickName;
    private String password;
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
        if (flag == 3){
            addNewProduct();
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
        messageAboutFunctionsOfAdmin();
        adminChoice();
    }
    public void showAllProducts(){
        for (int i = 0; i <= productsList.size() - 1; i++){
            productsList.get(i).showInfoAboutProduct();
        }
        System.out.println("Все товары выведены выше.");
        messageAboutFunctionsOfAdmin();
        adminChoice();
    }
}
