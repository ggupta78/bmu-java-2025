import java.io.IOException;
import java.util.Scanner;

public class CalcApp {
  public static void main(String[] args) {
    // Initialising Scanner outside the loop, so that we can close it after the loop
    Scanner scanner = new Scanner(System.in);

    while (true) { // Run infinite loop, until user selects 3. Exit and we break out of the loop

      clearScreen();
      System.out.println("""
            1. Add two numbers
            2. Subtract two numbers
            3. Exit
            Enter choice:
          """);

      int choice = scanner.nextInt();
      scanner.nextLine(); // Reading and disposing the \n newline character after users enters a number

      if (choice == 3) {
        // Exit branch
        System.out.println("Exiting...");
        break;

      } else if (choice < 1 || choice > 3) {
        // Incorrect Menu selection branch
        System.out.println("Incorrect choice, please try again..");
        System.out.println("Press any Enter to continue...");
        scanner.nextLine(); // Reading and disposing the \n newline character after users enters a number

      } else {
        // On Add or Subtract selection
        System.out.println("Enter first number:");
        int firstNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter second number:");
        int secondNumber = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
          case 1:
            System.out.println("Addition is: " + (firstNumber + secondNumber));
            break;
          case 2:
            System.out.println("Subtraction is: " + (firstNumber - secondNumber));
            break;
        }

        System.out.println("Press any Enter to continue...");
        scanner.nextLine();

      }

    }

    // Closing scanner once loop has finished
    scanner.close();
  }

  public static void clearScreen() {
    // Only for terminals which support control characters
    // System.out.print("\033[H\033[2J");
    // System.out.flush(); // Ensure the output is immediately written

    // More generic code for Windows and Mac/Linux
    try {
      final String os = System.getProperty("os.name");

      if (os.contains("Windows")) {
        // Command for Windows
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        // Command for macOS and Linux
        new ProcessBuilder("clear").inheritIO().start().waitFor();
      }

      // System.out.println("Console cleared using a system command.");

    } catch (final IOException | InterruptedException e) {
      // Handle exceptions if the command fails
      e.printStackTrace();
    }
  }

}
