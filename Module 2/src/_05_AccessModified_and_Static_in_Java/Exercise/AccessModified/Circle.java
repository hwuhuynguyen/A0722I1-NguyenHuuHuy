package _05_AccessModified_and_Static_in_Java.Exercise.AccessModified;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {}
    public Circle(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return this.radius;
    }
    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }
}
