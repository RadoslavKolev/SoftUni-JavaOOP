package lection.shapes;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5.2, 6.8);
        System.out.println(rectangle.calculatePerimeter());
        System.out.println(rectangle.calculateArea());

        Circle circle = new Circle(4.0);
        System.out.println(circle.calculatePerimeter());
        System.out.println(circle.calculateArea());

        // No access to Rectangle methods
        Shape rectangle2 = new Rectangle(5.2, 6.8);
        System.out.println(rectangle2.calculatePerimeter());
        System.out.println(rectangle2.calculateArea());
    }
}
