package delivery;

public class OrderInvalidException extends RuntimeException{
    public OrderInvalidException(String message) {
        super(message);
    }
}