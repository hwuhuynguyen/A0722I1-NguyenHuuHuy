package _15_Exception_Debug.Exercise.IllegalTriangleException;

public class IllegalTriangleException extends Exception {
    public IllegalTriangleException(double side) {
        super(side + " is larger than other two sides combined");
    }
    public IllegalTriangleException(String message) {
        super(message);
    }
}
