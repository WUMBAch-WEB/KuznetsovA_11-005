package FacultativeSystem;

import java.util.Scanner;

public class TeacherControlPanel {
    Scanner in  = new Scanner(System.in);
    ProfileOfTeacher profile =  new ProfileOfTeacher();
    public void teacherChoice(){
        System.out.println("Для продолжения необходимо сделать выбор: ");
        System.out.println("[1]Добавить курс            [2]Удалить Курс      [3]Изменить курс  [4]Информация о моих курсах");
        System.out.println("[5]Изменить личные данные   [6]Проверить почту   [7]Написать письмо");
        System.out.println("                            [8]Выйти из аккаунта");
        String choice = in.next();
        switch (choice){
            case "1" :
                profile.addNewCourse();
                System.out.println("Курс успешно добавлен");
                teacherChoice();
                break;
            case "2" :
                System.out.println("В разработке.");
                break;
            case "3" :
                System.out.println("В разработке.");
                break;
            case "4" :
                profile.showInfoAboutMyCourses();
                teacherChoice();
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
                profile.exitFromAccount();
                break;
            default:
                System.out.println("Неверные входные данные.");
                break;
        }

    }

}

