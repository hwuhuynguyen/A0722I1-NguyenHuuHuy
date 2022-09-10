package _19_String_and_Regex.Exercise.ValidateClassName;

public class ValidateClassNameTest {
    private static ValidateClassName classNameExample;

    public static final String[] validClassName = new String[] { "C0318G", "A0722I", "C0192H", "P1100K","P1111G" };
    public static final String[] invalidClassName = new String[] { "M0318G", "P032A", "AB123A", "C123A" };

    public static void main(String args[]) {
        classNameExample = new ValidateClassName();
        for (String account : validClassName) {
            boolean isValid = classNameExample.validate(account);
            System.out.println("Class name is " + account + " is valid: " + isValid);
        }
        for (String account : invalidClassName) {
            boolean isValid = classNameExample.validate(account);
            System.out.println("Class name is " + account + " is valid: " + isValid);
        }
    }
}
