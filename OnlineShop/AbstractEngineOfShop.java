package OnlineShop;
import java.util.ArrayList;
import java.util.Scanner;

public class AbstractEngineOfShop extends Souts{
    private String nickName;
    private String password;
    private String ADMINnick = "ADMINnick";
    private String ADMINpass = "ADMINpass";
    ArrayList<Buyer> buyersList =  new ArrayList<>();
    AdminPanel adminPanel = new AdminPanel(this);
    UserPanel userPanel = new UserPanel(this);
    Buyer admin = new Buyer(ADMINnick, ADMINpass);
    public void addAdmin(){
        buyersList.add(admin);
    }
    public void addNewBuyer(){
        Buyer buyer = new Buyer();
        buyersList.add(buyer);
        System.out.println("Вы успешно зарегестрированы.");
        System.out.println("[1]Зарегестрироваться   [2]Авторизоваться");
        choiceSignUpOrSignIn();
    }
    public void showAllBuyers(){
        for (int i = 1; i <= buyersList.size() - 1; i++){
            buyersList.get(i).showInfoAboutUser();
        }
        System.out.println("Все пользователи выведены.");
        adminPanel.adminChoice();
    }



    public void choiceSignUpOrSignIn(){
        Scanner in = new Scanner(System.in);
        int flag = in.nextInt();
        if (flag == 1){
            addNewBuyer();
        }
        if (flag == 2){
            signIn();
        }
        if (flag == 3){
            System.exit(0);
        }
    }
    public void signIn(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите Ваш никнейм: ");
        nickName = in.nextLine();
        System.out.print("Введите пароль: ");
        password = in.nextLine();
        if ((nickName.equals(ADMINnick)) && (password.equals(ADMINpass))){
            System.out.println("Вы успешно авторизованы как администратор.");
            adminPanel.adminChoice();
        }
        int flag = 0;
        for (int i = 1; i <= buyersList.size() - 1; i++){
            if ((buyersList.get(i).getNickName()).equals(nickName)){
                if ((buyersList.get(i).getPassword()).equals(password)){
                    System.out.println("Вы успешно авторизованы.");
                    flag = 1;
                    userPanel.userChoice();
                }
                if (!((buyersList.get(i).getPassword()).equals(password))){
                    System.out.println("Неверный пароль, повторите попытку.");
                    signIn();
                }
            }
        }
        if (flag == 0){
            System.out.println("Аккаунт не найден");
        }

    }
    public ArrayList<Buyer> getBuyersList(){
        return buyersList;
    }
//    public void signIn(){
//        Scanner in = new Scanner(System.in);
//        System.out.print("Введите Ваш никнейм: ");
//        this.nickName = in.nextLine();
//        for (int i = 0; i <= buyersList.size()-1; i++){
//            if ((buyersList.get(i).getNickName()).equals(this.nickName)){
//                if ((buyersList.get(i).getNickName()).equals(this.ADMINnick)){
//                    System.out.print("Введите пароль: ");
//                    password = in.nextLine();
//                    if ((buyersList.get(i).getPassword()).equals(this.ADMINpass)){
//                        System.out.println("Вы успешно авторизованы как администратор.");
//                        adminPanel.adminChoice();
//                    }
//                }
//                System.out.print("Введите пароль: ");
//                password = in.nextLine();
//                if ((buyersList.get(i).getPassword()).equals(password)){
//                    System.out.println("Вы успешно авторизованы.");
//                }
//                if (!((buyersList.get(i).getPassword()).equals(password))){
//                    System.out.println("Неверный пароль.");
//                }
//                else{
//                    System.out.println("Аккаунт с таким никнеймом не найден.");
//                    System.out.println("Хотите зарегестрироваться или авторизоваться в другой аккаунт?");
//                    System.out.println("[1]Зарегестрироваться   [2]Авторизоваться");
//                    choiceSignUpOrSignIn();
//                }
//            }
//        }
//    }
}
