package _19_String_and_Regex.Exercise.ValidatePhoneNumber;

public class ValidatePhoneNumberTest {
    private static ValidatePhoneNumber validatePhoneNumber;

    public static final String[] validPhoneNumber = new String[] { "84-0123456789", "84-0239123921", "09-0987345678","76-0967654561" };
    public static final String[] invalidPhoneNumber = new String[] { "ii-0987654345", "0-0987654321", "99-9876543212", "90-098765432" };

    public static void main(String args[]) {
        validatePhoneNumber = new ValidatePhoneNumber();
        for (String phone : validPhoneNumber) {
            boolean isValid = validatePhoneNumber.validate(phone);
            System.out.println("Account is " + phone + " is valid: " + isValid);
        }
        for (String phone : invalidPhoneNumber) {
            boolean isValid = validatePhoneNumber.validate(phone);
            System.out.println("Account is " + phone + " is valid: " + isValid);
        }
    }
}
