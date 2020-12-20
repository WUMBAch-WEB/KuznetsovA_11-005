package FacultativeSystem;

import java.util.ArrayList;
import java.util.Scanner;


public class Student {
    Scanner in = new Scanner(System.in);
    ArrayList<Student> studentsList = new ArrayList<>();
    private String nameOfStudent;
    private String ageOfStudent;
    private String emailOfStudent;
    private String nickname;
    private String passwordOfTStudent;
    public Student(String nameOfStudent, String ageOfStudent, String emailOfStudent, String nickname, String passwordOfTStudent){
        this.nameOfStudent = nameOfStudent;
        this.ageOfStudent = ageOfStudent;
        this.emailOfStudent = emailOfStudent;
        this.nickname = nickname;
        this.passwordOfTStudent = passwordOfTStudent;
    }
    public void showInfoAboutStudent(){
        System.out.println("Имя: " + this.nameOfStudent);
        System.out.println("Возраст: " + this.ageOfStudent);
        System.out.println("E-mail: " + this.emailOfStudent);
        System.out.println("Никнейм: " + this.nickname );
        System.out.println("saf " + passwordOfTStudent);
    }
    public String getNickname(){
        return this.nickname;
    }
    public String getPassword(){
        return this.passwordOfTStudent;
    }
}
