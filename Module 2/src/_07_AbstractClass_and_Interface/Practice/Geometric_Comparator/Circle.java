package _07_AbstractClass_and_Interface.Practice.Geometric_Comparator;

public class Circle {
    private double radius;
    private String color;
    private boolean filled;
    public Circle() {
        this.radius = 1.0;
        this.color = "red";
        this.filled = true;
    }
    public Circle(double radius) {
        this.radius  = radius;
        this.color = "red";
        this.filled = true;
    }

    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public String toString() {
        if (isFilled()) {
            return "A Circle with radius = " + getRadius() + ", color of " + getColor() + ", and filled";
        } else {
            return "A Circle with radius = " + getRadius() + ", color of " + getColor() + ", and no filled";
        }
    }
}
