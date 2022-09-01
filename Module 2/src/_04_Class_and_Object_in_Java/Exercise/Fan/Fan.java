package _04_Class_and_Object_in_Java.Exercise.Fan;

public class Fan {
    private static final int SLOW = 1;
    private static final int MEDIUM = 2;
    private static final int FAST = 3;
    private int speed;
    private boolean isON = false;
    private double radius = 5;
    private String color = "blue";

    public int getSpeed() {
        return this.speed;
    }

    public double getRadius() {
        return this.radius;
    }

    public boolean getOn(){
        return this.isON;
    }

    public String getColor() {
        return this.color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setOn(boolean status) {
        this.isON = status;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        if (isON) {
            return "Fan is ON, speed = " + this.getSpeed() +  ", radius = " + this.getRadius() + ", color: " + this.getColor();
        } else {
            return "Fan is OFF, radius = " + this.getRadius() + ", color: " +this.getColor();
        }
    }
}
