package FacultativeSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class ProfileOfTeacher {
    Scanner in  = new Scanner(System.in);
    ArrayList<Course> myCoursesList =  new ArrayList<>();
    Platform platform = new Platform();
    private String themeOfCourse;
    private String costOfCourse;
    private String countOfWebs;
    private String countOfHomeWorks;
    private String descriptionOfCourse;
    private String durationOfCourse;

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
        countOfWebs = in.next();
        System.out.print("Введите количество домашних заданий: ");
        countOfHomeWorks = in.next();
        System.out.print("Введите описание курса: ");
        descriptionOfCourse = in.next();
        System.out.print("Введите продолжительность курса в днях: ");
        durationOfCourse = in.next();
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
            }
            System.out.println("Все курсы успешно выведены ");
        }
    }
}
