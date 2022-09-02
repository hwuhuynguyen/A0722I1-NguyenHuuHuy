package _06_Inheritance_in_Java.Exercise.Circle_Cylinder;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
        System.out.println(cylinder.getVolume());

        cylinder = new Cylinder(5.0, 5.0, "black");
        System.out.println(cylinder);
        System.out.println(cylinder.getVolume());
    }
}
