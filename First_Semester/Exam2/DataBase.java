package Exam2;

import java.util.ArrayList;
import java.util.Scanner;

public class DataBase implements SignIn {
    Scanner in = new Scanner(System.in);
    private String name;
    private String nickname;
    private String password;
    ArrayList<User> userArrayList = new ArrayList<>();

    public void setInfoAboutUser(){
        System.out.print("Введите Ваше имя: ");
        name = in.next();
        System.out.print("Введите Ваш ник: ");
        nickname = in.next();
        System.out.println("Введите пароль: ");
        password = in.next();
    }

    @Override
    public void registration() {
        setInfoAboutUser();
        User user = new User(name, nickname, password);
        userArrayList.add(user);
    }

}
