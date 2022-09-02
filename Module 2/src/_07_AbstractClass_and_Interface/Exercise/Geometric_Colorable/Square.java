package _07_AbstractClass_and_Interface.Exercise.Geometric_Colorable;

public class Square extends Shape implements IColorable {
    private double side;
    public Square() {
        this.side = 1.0;
    }
    public Square(double side) {
        this.side = side;
    }
    public Square(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getPerimeter() {
        return 4*side;
    }
    public double getArea() {
        return Math.pow(side, 2);
    }
    @Override
    public String toString() {
        return super.toString() + " and perimeter is: " + getPerimeter() + ", area is: " + getArea();
    }
    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }
}
