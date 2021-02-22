package Exam2;

import java.util.Scanner;

public class Telegram implements AnyTextMessage, LogIn{
    Scanner in =  new Scanner(System.in);
    private static DataBase dataBase = new DataBase();
    private String nickname;
    private String password;
    @Override
    public void helloMessage() {
        System.out.println("Мы рады, что вы воспользовались Telegram");
        System.out.println("[1]Авторизация   [2]Регистрация");
        choiceSignInOrLogIn();
    }
    public void choiceSignInOrLogIn(){
        int flag = in.nextInt();
        if (flag == 0){
            dataBase.registration();
        }
        if (flag == 1){
            authorise();
        }

    }

    @Override
    public void authorise() {
        System.out.print("Введите Ваш никнейм: ");
        nickname = in.next();
        System.out.println("Введите Ваш пароль: ");
        password =  in.next();
        int flag = 0;
        if (dataBase.userArrayList.size() != 0){
            for (int i = 0; i < dataBase.userArrayList.size(); i++){
                if ((dataBase.userArrayList.get(i).getNickname()).equals(nickname)){
                    if (dataBase.userArrayList.get(i).getPassword().equals(password)){
                        System.out.println("Вы успешно авторизованы.");
                        flag = 1;
                        helloMessage();
                    }
                    if (!dataBase.userArrayList.get(i).getPassword().equals(password)){
                        System.out.println("Неверный пароль, повторите попытку.");
                        authorise();
                    }
                }
            }
        }
        else {
            System.out.println("Технические неполадки");
        }
        if (flag == 0){
            System.out.println("Аккаунт не найден.");
            helloMessage();
        }
    }
}
