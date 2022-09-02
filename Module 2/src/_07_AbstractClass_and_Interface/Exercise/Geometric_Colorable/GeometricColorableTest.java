package _07_AbstractClass_and_Interface.Exercise.Geometric_Colorable;

import _07_AbstractClass_and_Interface.Exercise.Geometric_Resizeable.Circle;

import java.util.concurrent.ThreadLocalRandom;

public class GeometricColorableTest {
    public static void main(String[] args) {
        Square[] squares = new Square[3];
        squares[0] = new Square();
        squares[1] = new Square();
        squares[2] = new Square();
        for (int i = 0; i < squares.length; i++) {
            System.out.println("Square " + i + ": " + squares[i]);
            if (squares[i] instanceof Square)
                squares[i].howToColor();
        }
    }
}
