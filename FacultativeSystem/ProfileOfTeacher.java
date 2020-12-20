package FacultativeSystem;

import java.util.ArrayList;

public class ProfileOfTeacher {
    ArrayList<Course> myCoursesList =  new ArrayList<>();
    DataBase dataBase;
    private String themeOfCourse;
    private String costOfCourse;
    private String countOfWebs;
    private String countOfHomeWorks;
    private String descriptionOfCourse;
    private String durationOfCourse;
    public void setDataBase(DataBase dataBase){
        this.dataBase = dataBase;
    }
    public void addNewCourse(){
        dataBase.setInfoAboutCourse();
        Course course =  new Course(themeOfCourse, costOfCourse, countOfHomeWorks, countOfWebs, descriptionOfCourse, durationOfCourse);
        myCoursesList.add(course);
        dataBase.coursesList.add(course);
    }
}
