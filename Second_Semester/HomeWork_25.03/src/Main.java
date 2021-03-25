import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File(".\\file.txt");
        ProductList list = new ProductList(file);
        Scanner in = new Scanner(System.in);
        boolean flag = true;

        System.out.println("Добро пожаловать в систему 'Склад'");
        while (flag){
            System.out.println("Доступные действия: ");
            System.out.println("[1]Добавить новый товар   [2]Удалить некоторый товар");
            System.out.println("[3]Вывести все товары     [4]Изменить количество некоторого товара");
            System.out.println("[5]Обнулить склад         [6]Выйти из системы");
            System.out.print("Введите Ваш выбор: ");
            String choice = in.next();
            switch (choice){
                case "1":

                    System.out.print("Введите имя товара: ");
                    String name = in.next();
                    System.out.print("Введите добавляемое кол-во: ");
                    int count = in.nextInt();
                    list.add(new Product(name, count));
                    break;

                case "2":

                    System.out.print("Введите имя товара, который необходимо удалить: ");
                    name = in.next();
                    list.remove(name);
                    break;

                case "3":

                    System.out.println(list);

                    break;
                case "4":

                    System.out.print("Введите имя товара: ");
                    name = in.next();
                    System.out.print("Введите добавляемое кол-во: ");
                    count = in.nextInt();
                    list.changeCount(name, count);
                    break;

                case "5":

                    new FileWriter(file, false).close();
                    list = new ProductList(file);

                    break;
                case "6":

                    flag = false;
                    break;
                default:
                    System.out.println("Такой функции не существует.");
            }
        }
    }
}
