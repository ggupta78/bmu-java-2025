// Example of a custom CHECKED exception
public class InvalidInputException extends Exception {

  // 1. Constructor that accepts a custom message
  public InvalidInputException(String message) {
    super(message);
  }

  // 2. Constructor that accepts a message and a cause (for chaining)
  public InvalidInputException(String message, Throwable cause) {
    super(message, cause);
  }
}
