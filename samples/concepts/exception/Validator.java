public class Validator {

  // Since InvalidInputException is a CHECKED exception, we must declare it
  // using the 'throws' keyword.
  public void validateAge(int age) throws InvalidInputException {
    if (age < 0) {
      // Throwing the custom exception
      throw new InvalidInputException("Age cannot be negative: " + age);
    }
    System.out.println("Age is valid.");
  }
}
