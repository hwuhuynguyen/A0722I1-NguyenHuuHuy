package exception;

public class NotFoundBankAccountException extends Exception {
    public NotFoundBankAccountException(String message) {
        super(message);
    }
}
