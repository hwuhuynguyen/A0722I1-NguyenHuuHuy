package _06_Inheritance_in_Java.Exercise.Circle_Cylinder;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(2.0, "blue");
        System.out.println(circle);
    }
}
