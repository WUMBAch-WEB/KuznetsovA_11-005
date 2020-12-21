package FacultativeSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class ProfileOfStudent {
    Scanner in = new Scanner(System.in);
    Platform platform = new Platform();
    ArrayList<Course> myCoursesList =  new ArrayList<>();
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
                    subscribeToCourse();
                    break;
                case "2" :
                    break;
                default:
                    System.out.println("Неверные входные данные.");
                    break;
            }
        }
    }
    public void  showMyCourses(){
        if (myCoursesList.size() == 0){
            System.out.println("Вы не подписаны ни на один из курсов.");
        }
        else {
            for (int i = 0; i <= myCoursesList.size() - 1; i++){
                System.out.println("Курс №" + (i + 1));
                myCoursesList.get(i).showInfoAboutCourse();
            }
            System.out.println("Это все курсы, на которые Вы подписаны.");
        }
    }
    public void subscribeToCourse(){
        System.out.print("Введите тему курса, на который хотите записаться: ");
        String themeOfCourse = in.next();
        for (int i = 0; i <= Platform.getDataBase().coursesList.size() - 1; i++){
            if ((Platform.getDataBase().coursesList.get(i).getThemeOfCourse()).equals(themeOfCourse)){
                System.out.println("Вы уверены, что хотите записаться на курс №" + (i+1) + "?");
                Platform.getDataBase().coursesList.get(i).showInfoAboutCourse();
                System.out.println("[1]Да   [2]Нет, вернуться к меню");
                String choice1 = in.next();
                switch (choice1){
                    case "1":
                        System.out.print("Пожалуйста, введите свой никнейм повторно: ");
                        String nickname = in.next();
                        for (int j = 0; j <= Platform.getDataBase().studentsList.size() - 1; j++ ){
                            if ((Platform.getDataBase().studentsList.get(i).getNickname()).equals(nickname)){
                                Platform.getDataBase().coursesList.get(i).getSubscribersList().add(Platform.getDataBase().
                                        studentsList.get(i));
                            }
                        }
                        myCoursesList.add(Platform.getDataBase().coursesList.get(i));
                        Platform.getDataBase().coursesList.get(i).getSubscribersList().add(Platform.getDataBase().
                                studentsList.get(i));
                        System.out.println("Вы успешно подписались на этот курс");
                        break;
                    case "2":
                        break;
                    default:
                        System.out.println("Неверные входные данные, повторите попытку:");
                        subscribeToCourse();
                        break;
                }
            }
            else{
                System.out.println("Курса с таким названием не найдено.");
                System.out.println("[1]Повторите попытку   [2]Вернуться в меню");
                String choice2 = in.next();
                switch (choice2){
                    case "1":
                        subscribeToCourse();
                        break;
                    case "2":
                        break;
                    default:
                        System.out.println("Неверные входные данные.");
                        break;
                }
            }
        }
    }
    public void exitFromAccount(){
        platform.welcome();
    }
}
