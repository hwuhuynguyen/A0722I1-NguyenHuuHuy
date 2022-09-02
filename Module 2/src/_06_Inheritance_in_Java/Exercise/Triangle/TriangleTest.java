package _06_Inheritance_in_Java.Exercise.Triangle;

public class TriangleTest {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println(triangle);

        triangle = new Triangle(10, 10, 10);
        System.out.println(triangle);
    }
}
