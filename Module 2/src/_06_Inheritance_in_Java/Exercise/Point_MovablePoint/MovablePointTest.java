package _06_Inheritance_in_Java.Exercise.Point_MovablePoint;

public class MovablePointTest {
    public static void main(String[] args) {
        MovablePoint mp = new MovablePoint(5, 6, 7, 8);

        mp.move();
        System.out.println(mp);

        mp.move();
        System.out.println(mp);
    }
}
