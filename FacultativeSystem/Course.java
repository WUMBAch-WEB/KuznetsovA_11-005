package FacultativeSystem;

import java.util.ArrayList;

public class Course {
    private String themeOfCourse;
    private String costOfCourse;
    private Integer countOfWebs;
    private Integer countOfHomeWorks;
    private String descriptionOfCourse;
    private Integer durationOfCourse;
    ArrayList<Student>  subscribersList;
    public Course(String themeOfCourse, String costOfCourse, Integer countOfHomeWorks, Integer countOfWebs, String descriptionOfCourse, Integer durationOfCourse){
        this.themeOfCourse = themeOfCourse;
        this.costOfCourse = costOfCourse;
        this.countOfHomeWorks = countOfHomeWorks;
        this.countOfWebs = countOfWebs;
        this.descriptionOfCourse = descriptionOfCourse;
        this.durationOfCourse = durationOfCourse;
        this.subscribersList = new ArrayList<>();
    }
    public void showInfoAboutCourse(){
        System.out.println("Тема курса: " + this.themeOfCourse);
        System.out.println("Стоимость курса: " + this.costOfCourse);
        System.out.println("Продолжительность курса: " + this.durationOfCourse);
        System.out.println("Количество онлайн занятий: " + this.countOfWebs);
        System.out.println("Количество домашних заданий: " + this.countOfHomeWorks);
        System.out.println("Подробное описание курса: " + this.descriptionOfCourse);
    }
    public String getThemeOfCourse(){
        return this.themeOfCourse;
    }
    public ArrayList<Student> getSubscribersList(){
        return this.subscribersList;
    }
    public Integer getDurationOfCourse(){
        return this.durationOfCourse;
    }
}
