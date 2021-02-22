package OnlineShop;
import java.util.ArrayList;
import java.util.Scanner;
public class Buyer {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private  String userName;
    private  String nickName;
    private  String sex;
    private String password;
    ArrayList<Order> historyOfOrdersList;
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
     historyOfOrdersList = new ArrayList<>();
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
 public String getUserName() { return  this.userName; }
 public ArrayList<Order> getHistoryOfOrdersList(){
     return historyOfOrdersList;
 }

 public void setPassword(String password) {
     this.password = password;
 }

 public void setNickName(String nickName) {
     this.nickName = nickName;
 }

}
