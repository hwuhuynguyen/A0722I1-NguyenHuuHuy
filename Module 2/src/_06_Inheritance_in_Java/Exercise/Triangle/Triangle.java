package _06_Inheritance_in_Java.Exercise.Triangle;

public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
    }
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public double getSide1() {
        return this.side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
    public double getPerimeter() {
        return (side1 + side2 + side3);
    }
    public double getArea() {
        double halfOfPerimeter = (side1 + side2 + side3)/2;
        double area = Math.sqrt(halfOfPerimeter*(halfOfPerimeter - side1)*(halfOfPerimeter - side2) * (halfOfPerimeter - side3));
        return area;
    }
    public String toString() {
        return "A Triangle with three sides are: " + getSide1() + ", " + getSide2() + ", " + getSide3()
                + ", and perimeter is: " + getPerimeter() + ", and area is: " + getArea();
    }
}
