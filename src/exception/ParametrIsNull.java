package exception;

public class ParametrIsNull extends RuntimeException {
    public ParametrIsNull() {
    }
    public ParametrIsNull(String message) {
        super(message);
    }
}
