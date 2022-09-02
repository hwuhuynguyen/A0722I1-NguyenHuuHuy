package _06_Inheritance_in_Java.Exercise.Point_MovablePoint;

public class Point {
    protected float x;
    protected float y;

    public Point() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public Point(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return this.x;
    }
    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }
    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y)
    {
        this.x = x;
        this.y = y;
    }
    public float[] getXY()
    {
        float [] array2D = {x,y};
        return array2D;
    }

    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
}
