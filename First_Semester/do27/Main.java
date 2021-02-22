package do27;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle =  new Rectangle();
        Triangle triangle = new Triangle();
        Shape[] shapes = new Shape[6];
        shapes[0] = rectangle;
        shapes[1] = circle;
        shapes[2] = rectangle;
        shapes[3] = triangle;
        shapes[4] = triangle;
        shapes[5] = circle;
        for (int i = 0; i< shapes.length-1; i++){
            System.out.println(shapes[i].getArea());
        }
    }
}
