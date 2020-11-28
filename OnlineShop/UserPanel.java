package OnlineShop;

import java.util.Scanner;

public class UserPanel extends Souts {
    AbstractEngineOfShop engine;
    AdminPanel adminPanel = new AdminPanel();
    private String nickname;
    private String password;
    private String newNickname;
    private String newPassword;
    public UserPanel(AbstractEngineOfShop engine){
        this.engine = engine;
    }
    public void exitFromUserAccount(){
        welcomeMessage();
        engine.choiceSignUpOrSignIn();
    }
    public void userChoice(){
        Scanner in = new Scanner(System.in);
        messageAboutFunctionsOfUser();
        int flag = in.nextInt();
        if (flag == 1){
            showAllProducts();
        }
        if (flag == 4){
            setNewInfoOfAccount();
        }
        if (flag == 5){
            System.out.println("??????????");
            userChoice();
        }
        if (flag == 6){
            exitFromUserAccount();
        }
    }
    public void showAllProducts(){
        for (int i = 0; i <= adminPanel.getProductsList().size() - 1; i++){
            adminPanel.getProductsList().get(i).showInfoAboutProduct();
        }
        System.out.println("Все товары выведены.");
        userChoice();
    }
    public void setNewInfoOfAccount(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите свой нынешний никнейм: ");
        nickname = in.next();
        boolean flag = false;
        for (int i = 1; i <= engine.getBuyersList().size() - 1; i++){
            if ((engine.getBuyersList().get(i).getNickName()).equals(nickname)){
                flag = true;
                System.out.println("Укажите, что имеено вы хотите изменить: ");
                System.out.println("[1]Изменить пароль   [2]Изменить никнейм   [3]Ничего не изменять");
                int flag1 = in.nextInt();
                if (flag1 == 1){
                    System.out.print("Введите свой нынешний пароль: ");
                    password = in.next();
                    if ((engine.getBuyersList().get(i).getPassword()).equals(password)){
                        System.out.println("Верный пароль.");
                        System.out.print("Введите новый пароль: ");
                        newPassword = in.next();
                        engine.getBuyersList().get(i).setPassword(newPassword);
                        System.out.println("Готово! Ваш пароль успешно изменен.");
                        userChoice();
                    }
                    else{
                        System.out.println("Неверный пароль.");
                        System.out.println("[1]Повторить попытку   [2]Отмена");
                        int flag2 = in.nextInt();
                        if (flag2 == 1){
                            setNewInfoOfAccount();
                        }
                        if (flag2 == 2){
                            userChoice();
                        }
                    }
                }
                if (flag1 == 2){
                    System.out.print("Введите новый никнейм: ");
                    newNickname = in.next();
                    engine.getBuyersList().get(i).setNickName(newNickname);
                    System.out.println("Готово! Ваш никнейм успешно изменен.");
                    System.out.println("Теперь Ваш аккаунт выглядит так: ");
                    engine.getBuyersList().get(i).showInfoAboutUser();
                    userChoice();
                }
                if (flag1 == 3){
                    userChoice();
                }
            }
        }
        if (!flag){
            System.out.println("Аккаунт с таким никнеймом не найден.");
            userChoice();
        }
    }
}
