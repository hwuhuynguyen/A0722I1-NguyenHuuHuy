package _05_AccessModified_and_Static_in_Java.Exercise.AccessModified;

public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(5);

        System.out.println(c1.getRadius());
        System.out.println(c1.getArea());

        System.out.println(c2.getRadius());
        System.out.println(c2.getArea());
    }
}
