package FacultativeSystem;

import java.util.Scanner;

public class Platform {
    Scanner in = new Scanner(System.in);
    DataBase dataBase;
    private String nickname;
    private String password;
    public void welcome(){
        System.out.println("Добро пожаловать на нашу платформу обучения");
        System.out.println("Спасибо за Ваш выбор");
        signUpOrSignIn();
    }
    public void signUpOrSignIn(){
        System.out.println("Для прохождения необходимо сделать выбор: ");
        System.out.println("[1]Регистрация  [2]Авторизация");
        int flag = in.nextInt();
        if (flag == 1){
            dataBase.registration();
            signUpOrSignIn();
        }
        if (flag == 2){
            System.out.println("Вы хотите авторизоваться, как ученик или преподаватель?");
            System.out.println("[1]Я ученик   [2]Я преподователь");
            int choice = in.nextInt();
            if (choice == 1){
                signInLikeStudent();
            }
            if (choice == 2){
                signInLikeTeacher();
            }
        }
    }
    public void signInLikeTeacher(){
        System.out.print("Введите Ваш никнейм: ");
        nickname = in.next();
        System.out.print("Введите Ваш пароль: ");
        password = in.next();
        int flag = 0;
        for (int i = 0; i <= dataBase.teachersList.size() ; i++){
            if ((dataBase.teachersList.get(i).getNickname()).equals(nickname)){
                if ((dataBase.teachersList.get(i).getPassword()).equals(password)){
                    System.out.println("Вы успешно авторизованы, как преподователь");
                    flag = 1;
                    dataBase.teachersList.get(i).getContolPanel().teacherChoice();
                }
                if (!((dataBase.teachersList.get(i).getPassword()).equals(password))){
                    System.out.println("Неверный пароль, повторите попытку");
                    signInLikeTeacher();
                }
            }
        }
        if (flag == 0){
            System.out.println("Аккаунт не найден");
            signUpOrSignIn();
        }
    }
    public void signInLikeStudent(){
        System.out.print("Введите Ваш никнейм: ");
        nickname = in.next();
        System.out.print("Введите Ваш пароль: ");
        password = in.next();
        int flag = 0;
        for (int i = 0; i <= dataBase.studentsList.size() ; i++){
            if ((dataBase.studentsList.get(i).getNickname()).equals(nickname)){
                if ((dataBase.studentsList.get(i).getPassword()).equals(password)){
                    System.out.println("Вы успешно авторизованы, как ученик");
                    flag = 1;
                    System.out.println("Дальше ничего нет, поэтому начнем сначала");
                    welcome();
                }
                if (!((dataBase.studentsList.get(i).getPassword()).equals(password))){
                    System.out.println("Неверный пароль, повторите попытку");
                    signInLikeTeacher();
                }
            }
        }
        if (flag == 0){
            System.out.println("Аккаунт не найден");
            signUpOrSignIn();
        }
    }

    public void setDataBase(DataBase dataBase){
        this.dataBase = dataBase;
    }
}
