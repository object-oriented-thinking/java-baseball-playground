package baseball.error;

public class CalculationFailureException extends RuntimeException {
    public CalculationFailureException(String message) {
        super(message);
    }
}
