package springboottransactionproject.exceptions;

public class PaymentException extends RuntimeException{
    public PaymentException(String message) {
        super(message);
    }
}
