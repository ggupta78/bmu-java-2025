public class CustomExceptionDemo {
  public static void main(String[] args) {
    Validator validator = new Validator();

    try {
      validator.validateAge(-5); // This will throw InvalidInputException

    } catch (InvalidInputException e) {
      // Catching and handling the specific custom exception
      System.err.println("Validation Error Caught: " + e.getMessage());
      // Log the error, prompt the user, etc.

      // e.printStackTrace();

    } catch (Exception generalException) {
      // Catch other possible exceptions
      System.err.println("An unexpected error occurred.");
    } finally {
      System.out.println("finally will always run...");
    }
  }
}
