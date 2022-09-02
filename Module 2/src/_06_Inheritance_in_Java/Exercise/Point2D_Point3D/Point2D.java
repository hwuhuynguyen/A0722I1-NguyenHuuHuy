package _06_Inheritance_in_Java.Exercise.Point2D_Point3D;

public class Point2D {
    protected float x;
    protected float y;

    public Point2D() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public Point2D(float x, float y)
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
        return "{" + x + ", " + y + "}";
    }
}