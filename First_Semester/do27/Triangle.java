package do27;

import java.util.Scanner;

public class Triangle extends Shape {
    public int getArea(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите высоту треугольника: ");
        int height = in.nextInt();
        System.out.print("Введите длину стороны, на которую опирается высота, треугольника: ");
        int length = in.nextInt();
        System.out.print("Площадь треугольника равна:  ");
        return (height*length)/2;
    }
}
