package FacultativeSystem;

import java.util.Scanner;

public class ProfileOfStudent {
    Scanner in = new Scanner(System.in);
    Platform platform = new Platform();
    public void showAvailableCourses(){
        if (Platform.getDataBase().coursesList.size() == 0){
            System.out.println("К сожалению, доступных курсов нет.");
        }
        else {
            System.out.println("Ниже будут выведены все доступные курсы: ");
            for (int i = 0; i <= Platform.getDataBase().coursesList.size() - 1; i++){
                System.out.println("Курс №" + (i + 1));
                Platform.getDataBase().coursesList.get(i).showInfoAboutCourse();
            }
            System.out.println("Все курс успешно выведены.");
            System.out.println("[1]Записать на какой-либо курс   [2]Вернуться в меню");
            String choice = in.next();
            switch (choice){
                case "1" :
                    System.out.println("В разработке.");
                    break;
                case "2" :
                    break;
                default:
                    System.out.println("Неверные входные данные.");
                    break;
            }
        }
    }
    public void exitFromAccount(){
        platform.welcome();
    }
}
