package FacultativeSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class DataBase {
    ArrayList<Student> studentsList = new ArrayList<>();
    ArrayList<Teacher> teachersList = new ArrayList<>();
    ArrayList<Course> coursesList = new ArrayList<>();
    ProfileOfTeacher profileOfTeacher =  new ProfileOfTeacher();
    Scanner in = new Scanner(System.in);
    //Переменные для Student
    private String nameOfStudent;
    private String ageOfStudent;
    private String emailOfStudent;
    private String nickname; //Универсальная переменная
    private String passwordOfStudent;
    //Переменные для Teacher
    private String specificationOfTeacher;
    private String nameOfTeacher;
    private String ageOfTeacher;
    private String emailOfTeacher;
    private String descriptionOfTeacher;
    private String experienceOfTeacher;
    private String passwordOfTeacher;
    //Переменные для Course
    private String themeOfCourse;
    private String costOfCourse;
    private String countOfWebs;
    private String countOfHomeWorks;
    private String descriptionOfCourse;
    private String durationOfCourse;

    public void registration(){
        int flag;
        System.out.println("Для продолжения нам необходимо узнать кем вы являетесь?");
        System.out.println("[1]Я студент   [2]Я преподователь");
        flag = in.nextInt();
        if (flag == 1){
            setInfoAboutStudent();
            Student student = new Student(nameOfStudent, ageOfStudent, emailOfStudent,  nickname, passwordOfStudent);
            studentsList.add(student);
        }
        if (flag == 2){
            setInfoAboutTeacher();
            Teacher teacher = new Teacher(nameOfTeacher, ageOfTeacher, emailOfTeacher, passwordOfTeacher,
                    descriptionOfTeacher, specificationOfTeacher, experienceOfTeacher, nickname);

            teachersList.add(teacher);
        }
    }
    public void checkForReplayInStudentsList(){
        if (studentsList.size() == 0){
            System.out.print("");
        }
        else {
        for (int i =0; i <= studentsList.size() - 1; i++){
            if ((studentsList.get(i).getNickname()).equals(nickname)){
                System.out.println("Аккаунт с таким никнеймом уже существует, повторите попытку.");
                setInfoAboutStudent();
            }
        }
        }
    }
    public void checkForReplayInTeachersList(){
        if (teachersList.size() == 0){
            System.out.println("");
        }
        else{
            for (int i = 0; i <= teachersList.size() - 1; i++){
                System.out.println("Аккаунт с таким никнеймом уже существует, повторите попытку.");
                setInfoAboutTeacher();
            }
        }
    }
//    public void addNewCourse(){
//        setInfoAboutCourse();
//        Course course =  new Course(themeOfCourse, costOfCourse, countOfHomeWorks, countOfWebs, descriptionOfCourse, durationOfCourse);
//        coursesList.add(course);
//
//    }
    public void deleteCourse(){
        System.out.println("Введите название курса, который необходимо удалить");
    }
    public void setInfoAboutStudent(){

        System.out.print("Введите Ваше имя: ");
        nameOfStudent = in.next();
        System.out.print("Введите Ваш возраст: ");
        ageOfStudent = in.next();
        System.out.print("Укажите адрес Вашей электронной почты: ");
        emailOfStudent = in.next();
        System.out.print("Укажите Ваш никнейм: ");
        nickname = in.next();
        checkForReplayInStudentsList();
        System.out.print("Укажите Ваш пароль: ");
        passwordOfStudent = in.next();
    }
    public void setInfoAboutTeacher(){
        System.out.print("Введите Ваше имя: ");
        nameOfTeacher = in.next();
        System.out.print("Введите Ваш возраст: ");
        ageOfTeacher = in.next();
        System.out.print("Введите Ваш стаж преподавания: ");
        experienceOfTeacher = in.next();
        System.out.print("Введите адрес Вашей электронной почты: ");
        emailOfTeacher = in.next();
        System.out.print("Укажите Вашу специализацию: ");
        specificationOfTeacher = in.next();
        System.out.print("Расскажите о себе: ");
        descriptionOfTeacher = in.next();
        System.out.print("Введите Ваш никнейм: ");
        nickname = in.next();
        checkForReplayInTeachersList();
        System.out.print("Введите Ваш пароль: ");
        passwordOfTeacher = in.next();
    }
//    public void setInfoAboutCourse(){
//        System.out.print("Введите тему курса: ");
//        themeOfCourse = in.next();
//        System.out.print("Введите стоимость курса: ");
//        costOfCourse = in.next();
//        System.out.print("Введите количество онлайн-занятий:");
//        countOfWebs = in.next();
//        System.out.print("Введите количество домашних заданий: ");
//        countOfHomeWorks = in.next();
//        System.out.print("Введите описание курса: ");
//        descriptionOfCourse = in.next();
//        System.out.print("Введите продолжительность курса в днях: ");
//        durationOfCourse = in.next();
//    }
    public ArrayList<Course> getCoursesList(){
        return coursesList;
    }
}
