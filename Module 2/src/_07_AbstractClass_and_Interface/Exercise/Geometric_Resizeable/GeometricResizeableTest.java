package _07_AbstractClass_and_Interface.Exercise.Geometric_Resizeable;

import java.util.concurrent.ThreadLocalRandom;

public class GeometricResizeableTest {
    public static void main(String[] args) {
        Circle[] circle = new Circle[3];
        circle[0] = new Circle();
        circle[1] = new Circle();
        circle[2] = new Circle();
        for (int i = 0; i < circle.length; i++) {
            System.out.println("Circle " + i + ": " + circle[i]);
            int ranNum = ThreadLocalRandom.current().nextInt(1,101);
            System.out.println(ranNum + " " + circle[i].resize(ranNum));
        }
    }
}
