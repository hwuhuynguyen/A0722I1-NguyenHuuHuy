package _06_Inheritance_in_Java.Exercise.Point2D_Point3D;

public class Point3D extends Point2D{
    private float z;

    public Point3D() {
        super();
        this.z = 0.0f;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float[] getXYZ()
    {
        float []array3D = {x,y,z};
        return array3D;
    }

    public String toString()
    {
        return "{" + x + ", " + y + ", " + z + "}";
    }


}