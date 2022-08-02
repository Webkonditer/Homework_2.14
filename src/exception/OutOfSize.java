package exception;

public class OutOfSize extends RuntimeException {
    public OutOfSize() {
    }

    public OutOfSize(String message) {
        super(message);
    }

}
