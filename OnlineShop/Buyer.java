package OnlineShop;
import java.util.ArrayList;
import java.util.Scanner;
public class Buyer {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    ArrayList<Buyer> buyersList =  new ArrayList<>();
    private  String userName;
    private  String nickName;
    private  String sex;
    private String password;
    Scanner in = new Scanner(System.in);
 public Buyer(){
     System.out.print("Введите Ваше ФИО: ");
     this.userName = in.nextLine();
     System.out.print("Введите Ваш Nickname: ");
     this.nickName = in.nextLine();
     System.out.print("Укажите ваш пол: ");
     this.sex = in.nextLine();
     System.out.print("Придумайте пароль: ");
     this.password = in.nextLine();
 }
 public Buyer(String nickName, String password){
     this.nickName = nickName;
     this.password = password;
 }
 public void showInfoAboutUser(){
     System.out.println(ANSI_RED + this.nickName + ANSI_RESET);
     System.out.println("ФИО: " + this.userName);
     System.out.println("Пол: " + this.sex);
 }
 public String getNickName(){
     return this.nickName;
 }
 public String getPassword(){
     return this.password;
 }

}
