package FacultativeSystem;

public class Course {
    private String themeOfCourse;
    private String costOfCourse;
    private String countOfWebs;
    private String countOfHomeWorks;
    private String descriptionOfCourse;
    private String durationOfCourse;
    public Course(String themeOfCourse, String costOfCourse, String countOfHomeWorks, String countOfWebs, String descriptionOfCourse, String durationOfCourse){
        this.themeOfCourse = themeOfCourse;
        this.costOfCourse = costOfCourse;
        this.countOfHomeWorks = countOfHomeWorks;
        this.countOfWebs = countOfWebs;
        this.descriptionOfCourse = descriptionOfCourse;
        this.durationOfCourse = durationOfCourse;
    }
}
