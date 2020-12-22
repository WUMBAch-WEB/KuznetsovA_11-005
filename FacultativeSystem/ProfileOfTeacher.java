package FacultativeSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class ProfileOfTeacher {
    Scanner in  = new Scanner(System.in);
    ArrayList<Course> myCoursesList =  new ArrayList<>();
    Platform platform = new Platform();
    private String themeOfCourse;
    private String costOfCourse;
    private Integer countOfWebs;
    private Integer countOfHomeWorks;
    private String descriptionOfCourse;
    private Integer durationOfCourse;

    public void addNewCourse(){
        setInfoAboutCourse();
        Course course =  new Course(themeOfCourse, costOfCourse, countOfHomeWorks, countOfWebs, descriptionOfCourse, durationOfCourse);
        myCoursesList.add(course);
        Platform.getDataBase().coursesList.add(course);
    }
    public void deleteCourse(){

    }
    public void exitFromAccount(){
        platform.welcome();
    }
    public void setInfoAboutCourse(){
        System.out.print("Введите тему курса: ");
        themeOfCourse = in.next();
        System.out.print("Введите стоимость курса: ");
        costOfCourse = in.next();
        System.out.print("Введите количество онлайн-занятий:");
        countOfWebs = in.nextInt();
        System.out.print("Введите количество домашних заданий: ");
        countOfHomeWorks = in.nextInt();
        System.out.print("Введите описание курса: ");
        descriptionOfCourse = in.next();
        System.out.print("Введите продолжительность курса в днях: ");
        durationOfCourse = in.nextInt();
    }
    public void setMarkOfCourse(){
        System.out.print("Введите тему курса, по которому нужно выставить оценку: ");
        String themeOfCourse = in.next();
        for (int i = 0; i <= myCoursesList.size() - 1; i++){
            if ((myCoursesList.get(i).getThemeOfCourse()).equals(themeOfCourse)){
                System.out.print("Введите никнейм ученика, которому нужно выставить оценку: ");
                String nicknameOfStudent = in.next();
                for (int j = 0; j <= myCoursesList.get(i).getSubscribersList().size() - 1; j++){
                    if ((myCoursesList.get(i).getSubscribersList().get(j).getNickname()).equals(nicknameOfStudent)){
                        myCoursesList.get(i).getSubscribersList().get(j).showInfoAboutStudent();
                        System.out.println("Введите оценку: ");
                        String mark = in.next();
                        myCoursesList.get(i).getSubscribersList().get(j).getControlPanel().profile.setMarkOfCourse(mark);
                    }
                }
            }
        }
    }
    public void showInfoAboutMyCourses(){
        if (myCoursesList.size() == 0){
            System.out.println("Вы не являетесь автором ни одного из доступных курсов.");
        }
        else {
            System.out.println("Ниже будут выведены все курсы, автором которых Вы являетесь: ");
            for (int i = 0; i <= myCoursesList.size() - 1; i++){
                System.out.println("Курс №" + (i+1));
                myCoursesList.get(i).showInfoAboutCourse();
                for (int j = 0; j <= Platform.getDataBase().coursesList.size() - 1; j++){
                    if ((Platform.getDataBase().coursesList.get(j).getThemeOfCourse()).
                            equals(myCoursesList.get(i).getThemeOfCourse())){
                        if (Platform.getDataBase().coursesList.get(j).getSubscribersList().size() == 0){
                            System.out.println("На этот курс пока что никто не подписан.");
                        }
                        else{
                            System.out.println("На этот курс подписаны: ");
                            for (int k = 0; k <= Platform.getDataBase().coursesList.get(j).getSubscribersList().size() - 1 ; k++){
                                System.out.println("Студент №" + (k+1));
                                Platform.getDataBase().coursesList.get(j).getSubscribersList().get(k).showInfoAboutStudent();
                                System.out.println("Количество выполненых домашних заданий: " + Platform.getDataBase().
                                        coursesList.get(j).getSubscribersList().get(k).getControlPanel().profile.
                                        getCompletedHomeWorks());
                                System.out.println("Количество просмотренных вебинаров: " + Platform.getDataBase().
                                        coursesList.get(j).getSubscribersList().get(k).getControlPanel().profile.
                                        getViewedWebs());
                                System.out.println("Количество проебанных дней: " + Platform.getDataBase().
                                        coursesList.get(j).getSubscribersList().get(k).getControlPanel().profile.
                                        getUselessDays());
                                System.out.println(Platform.getDataBase().
                                        coursesList.get(j).getSubscribersList().get(k).getControlPanel().profile.
                                        getCourseStatus());
                            }
                            System.out.println("Хотите оценить работу какого-либо ученика?");
                            System.out.println("[1]Да   [2]Нет, вернуться к меню");
                            String choice = in.next();
                            switch (choice){
                                case "1":
                                    setMarkOfCourse();
                                case "2":
                                    break;
                                default:
                                    System.out.println("Неверные входные данные.");
                                    break;
                            }
                        }
                    }
                }
            }
            System.out.println("Все курсы успешно выведены ");
        }
    }
}
