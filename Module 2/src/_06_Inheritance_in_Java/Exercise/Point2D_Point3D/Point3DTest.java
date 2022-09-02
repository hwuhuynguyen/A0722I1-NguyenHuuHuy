package _06_Inheritance_in_Java.Exercise.Point2D_Point3D;

public class Point3DTest {
    public static void main(String[] args) {
        Point3D point3D = new Point3D(5,6,7);
        System.out.println(point3D);

        point3D.setXYZ(3.3f, 3.3f, 3.3f );
        System.out.println(point3D);
    }
}
