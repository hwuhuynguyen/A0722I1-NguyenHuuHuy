package _06_Inheritance_in_Java.Exercise.Circle_Cylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        super();
        this.height = 1.0;
    }
    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return super.getArea() * this.height;
    }
    public String toString() {
        return "A Cylinder with height = " + getHeight() + ", and radius = " + super.getRadius()
                + ", and color of " + super.getColor();
    }
}
