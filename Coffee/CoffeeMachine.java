package Coffee;

public class CoffeeMachine {
 public static void plug(){
     System.out.println("Добро пожаловать.");
     System.out.println("Какой кофе вы хотите?");
    }
 public static void make(){
     System.out.println("Подогреваем и добавляем воду");
     System.out.println("Подгреваем и добавляем молоко");
     System.out.println("Добавляем кофе и сахар");
 }
 public static void espresso(){
     System.out.println("Добавляем мелко смолотого кофе");
     System.out.println("Добавляем воду");
 }
 public static void cappuccino(){
     System.out.println("Подогреваем молоко");
     System.out.println("Добавляем немного горячего молока поверх эспрессо");
     System.out.println("Взбиваем молоко и добавляем пышную пену верхним слоем");
 }
 public static void hotChocolate(){
     System.out.println("EROR");
 }
 public static void americano(){
     System.out.println("Добавляем еще больше воды");
 }
 public static void latte(){

 }
}
