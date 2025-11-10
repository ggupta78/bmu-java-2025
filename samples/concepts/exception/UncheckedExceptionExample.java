public class UncheckedExceptionExample {

  public static void main(String[] args) {

    String text = null; // The reference 'text' points to nothing (null).

    try {
      // Attempting to call a method (like toUpperCase()) on a null reference
      int length = text.length(); // <-- This line throws the NullPointerException

      System.out.println("Length of string: " + length);

    } catch (NullPointerException e) {
      // Although not required, we can catch it to prevent the program from
      // crashing
      System.err.println("Error: Cannot perform an operation on a null object reference.");
      System.out.println("Detail: " + e.getMessage());
    } finally {
      System.out.println("finally will always run...");
    }

    System.out.println("\nProgram continues running after handling the exception.");
  }
}
