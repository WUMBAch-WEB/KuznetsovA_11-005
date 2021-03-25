//import com.google.gson.Gson;
//
//import java.io.*;
//import java.util.LinkedList;
//import java.util.Scanner;
//
//public class AnyShit {
//
//    public static void add() throws IOException, ClassNotFoundException {
//        FileOutputStream fos = new FileOutputStream("file.bin");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        FileInputStream fis = new FileInputStream("file.bin");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        Scanner in = new Scanner(System.in);
//
//        System.out.print("Введите название товара: ");
//        String name = in.next();
//        System.out.print("Введите кол-во добавляемого товара: ");
//        int count = in.nextInt();
//        Product product = new Product(name, count);
//        LinkedList<Product> list = (LinkedList<Product>) ois.readObject();
//        list.add(product);
//        oos.writeObject(list);
//
//        oos.close();
//        ois.close();
//
//    }
//
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//
//
//        Scanner in = new Scanner(System.in);
//        boolean flag = true;
//
//        System.out.println("Добро пожаловать в систему 'Склад'");
//
//
//        while (flag){
//            System.out.println("Доступные действия: ");
//            System.out.println("[1]Добавить новый товар   [2]Удалить некоторый товар");
//            System.out.println("[3]Вывести все товары     [4]Изменить количество некоторого товара");
//            System.out.println("[5]Обнулить склад         [6]Выйти из системы");
//            System.out.print("Введите Ваш выбор: ");
//            String choice = in.next();
//            switch (choice){
//                case "1":
//                    add();
//                    break;
//                case "2":
//
//                    break;
//                case "3":
//
//
//                    break;
//                case "4":
//
//                    break;
//                case "5":
//
//                    break;
//                case "6":
//
//                    flag = false;
//                    break;
//                default:
//                    System.out.println("Такой функции не существует.");
//            }
//        }
//
//    }
//
//}
