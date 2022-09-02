package _06_Inheritance_in_Java.Exercise.Triangle;

public class Shape {
    private String color;
    private boolean filled;

    public Shape() {
        this.color = "green";
        this.filled = true;
    }
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    public String getColor() {
        return this.color;
    }
    public boolean isFilled() {
        return this.filled;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public String toString() {
        if (isFilled()) {
            return "A Shape with color of " + this.getColor() + " and filled.";
        } else {
            return "A Shape with color of " + this.getColor() + " and not filled.";
        }
    }
}