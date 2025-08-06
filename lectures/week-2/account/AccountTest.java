import java.util.Scanner;

public class AccountTest {
  public static void main(String[] args) {
    Account account = new Account();
    // Account account2 = new Account();

    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter Account Name:");
    String name = scanner.nextLine();

    System.out.println("Enter Account Balance:");
    double balance = scanner.nextDouble();

    account.setName(name);
    account.setBalance(balance);

    System.out.println("Account Name: " + account.getName());
    System.out.println("Account Balance: " + account.getBalance());
  }

}
