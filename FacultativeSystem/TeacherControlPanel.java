package FacultativeSystem;

import java.util.Scanner;

public class TeacherControlPanel {
    Scanner in  = new Scanner(System.in);
    DataBase dataBase;
    ProfileOfTeacher profile =  new ProfileOfTeacher();
    public void setProfile(){
        profile.setDataBase(dataBase);
    }
    public void teacherChoice(){
        System.out.println("Для продолжения необходимо сделать выбор: ");
        System.out.println("[1]Добавить курс            [2]Удалить Курс      [3]Изменить курс  [4]Информация о моих курсах");
        System.out.println("[5]Изменить личные данные   [6]Проверить почту   [7]Написать письмо");
        System.out.println("                            [8]Выйти из аккаунта");
        String choice = in.next();
        switch (choice){
            case "1" :
                profile.addNewCourse();
                break;
            case "2" :
                System.out.println("В разработке.");
                break;
            case "3" :
                System.out.println("В разработке.");
                break;
            case "4" :
                System.out.println("В разработке.");
                break;
            case "5" :
                System.out.println("В разработке.");
                break;
            case "6" :
                System.out.println("В разработке.");
                break;
            case "7" :
                System.out.println("В разработке.");
                break;
            case "8" :
                System.out.println("В разработке.");
                break;
            default:
                System.out.println("Неверные входные данные.");
                break;
        }

    }
    public void setDataBase(DataBase dataBase){
        this.dataBase = dataBase;
    }
}

