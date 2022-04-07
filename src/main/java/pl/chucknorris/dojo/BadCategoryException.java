package pl.chucknorris.dojo;

public class BadCategoryException extends Exception {

    public BadCategoryException() {
    }

    public BadCategoryException(String message) {
        super(message);
    }

    public BadCategoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
