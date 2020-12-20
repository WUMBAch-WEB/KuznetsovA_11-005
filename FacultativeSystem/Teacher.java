package FacultativeSystem;

import java.util.ArrayList;

public class Teacher {
    private String specificationOfTeacher;
    private String nameOfTeacher;
    private String ageOfTeacher;
    private String emailOfTeacher;
    private String passwordOfTeacher;
    private String descriptionOfTeacher;
    private String experienceOfTeacher;
    private String nickname;
    TeacherControlPanel controlPanel;
    DataBase dataBase;
    public Teacher(String nameOfTeacher, String ageOfTeacher, String emailOfTeacher, String passwordOfTeacher, String descriptionOfTeacher, String specificationOfTeacher, String experienceOfTeacher, String nickname){
        this.nameOfTeacher = nameOfTeacher;
        this.nickname =  nickname;
        this.ageOfTeacher = ageOfTeacher;
        this.emailOfTeacher = emailOfTeacher;
        this.passwordOfTeacher = passwordOfTeacher;
        this.descriptionOfTeacher = descriptionOfTeacher;
        this.specificationOfTeacher = specificationOfTeacher;
        this.experienceOfTeacher = experienceOfTeacher;
        controlPanel =  new TeacherControlPanel();
        controlPanel.setDataBase(dataBase);
        controlPanel.setProfile();
    }
    public void showInfoAboutTeacher(){
        System.out.println("Имя: " + this.nameOfTeacher);
        System.out.println("Возраст: " + this.ageOfTeacher);
        System.out.println("Стаж преподавания: " + this.experienceOfTeacher);
        System.out.println("Специализация: " + this.specificationOfTeacher);
        System.out.println("О себе: " + this.descriptionOfTeacher);
        System.out.println("E-mail: " + this.emailOfTeacher);
        System.out.println("nick suka " + this.nickname);
        System.out.println("пас " + this.passwordOfTeacher);
    }
    public void setDataBase(DataBase dataBase){
        this.dataBase = dataBase;
    }
    public String getNickname(){
        return this.nickname;
    }
    public String getPassword(){
        return this.passwordOfTeacher;
    }
    public TeacherControlPanel getContolPanel(){
        return this.controlPanel;
    }
}
