import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class CheckedExceptionExample {

  public static void readFile(String filePath) {

    // The compiler *requires* us to handle or declare the exception here.
    try {
      // This line can throw FileNotFoundException, a checked exception.
      FileReader reader = new FileReader(filePath);

      // If successful, continue with file reading logic...
      System.out.println("File was successfully opened.");
      // (In a real app, you'd process the file content here.)

    } catch (FileNotFoundException e) {
      // Handling the checked exception gracefully
      System.err.println("Error: The file '" + filePath + "' was not found.");
      // Optional: Print the stack trace for debugging
      e.printStackTrace();
    } catch (Exception e) {

    } finally {
      System.out.println("finally will always run...");
    }
  }

  public static void main(String[] args) {
    readFile("non_existent_file.txt");
  }
}
