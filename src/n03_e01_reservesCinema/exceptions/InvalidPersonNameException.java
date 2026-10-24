package n03_e01_reservesCinema.exceptions;

public class InvalidPersonNameException extends RuntimeException {
    public InvalidPersonNameException(String message) {
        super(message);
    }
}
