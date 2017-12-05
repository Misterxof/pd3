package exception;

/**
 * Class for incorrect number of arguments
 */
public class IncorrectNumberOfArgumentsException extends Exception {

    public IncorrectNumberOfArgumentsException() {
        super();
    }

    public IncorrectNumberOfArgumentsException(String message) {
        super(message);
    }

    public IncorrectNumberOfArgumentsException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectNumberOfArgumentsException(Throwable cause) {
        super(cause);
    }
}

