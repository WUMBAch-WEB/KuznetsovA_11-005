package FacultativeSystem;

import java.util.Scanner;

public class StudentControlPanel {
    Scanner in = new Scanner(System.in);
    ProfileOfStudent profile = new ProfileOfStudent();
    public void studentChoice(){
        System.out.println("Для продолжения необходимо сделать выбор: ");
        System.out.println("[1]Узнать доступные курсы   [2]Мои курсы         [3]Мои оценки  ");
        System.out.println("[4]Изменить личные данные   [5]Проверить почту   [6]Написать письмо");
        System.out.println("                            [7]Выйти из аккаунта");
        String choice = in.next();
        switch (choice){
            case "1" :
                profile.showAvailableCourses();
                studentChoice();
                break;
            case "2" :
                profile.showMyCourses();
                studentChoice();
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
                profile.exitFromAccount();
                break;
            default:
                System.out.println("Неверные входные данные.");
                break;
        }
    }
}
