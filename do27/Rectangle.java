package do27;
import java.util.Scanner;
public class Rectangle extends Shape {
    public int getArea(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите ширину прямоугольника: ");
        int width = in.nextInt();
        System.out.print("Введите длину прямоугольника: ");
        int length = in.nextInt();
        System.out.print("Площадь прямоугольника равна: ");
        return width*length;
    }

}
