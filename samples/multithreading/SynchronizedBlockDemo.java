public class SynchronizedBlockDemo {

  static class BankAccount {
    private int balance = 1000;
    private final Object lock = new Object(); // Explicit lock object

    public void withdraw(int amount, String customerName) {
      // Non-critical code - can run concurrently
      System.out.println(customerName + " attempting to withdraw $" + amount);

      // Critical section - only one thread at a time
      synchronized (lock) {
        if (balance >= amount) {
          System.out.println(customerName + " checking balance: $" + balance);

          // Simulate some processing time
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }

          balance -= amount;
          System.out.println(customerName + " withdrew $" + amount +
              ". New balance: $" + balance);
        } else {
          System.out.println(customerName + " - Insufficient funds! Balance: $" + balance);
        }
      }

      // Non-critical code
      System.out.println(customerName + " transaction complete.\n");
    }

    public synchronized int getBalance() {
      return balance;
    }
  }

  public static void main(String[] args) throws InterruptedException {
    BankAccount account = new BankAccount();

    // Create multiple threads trying to withdraw simultaneously
    Thread customer1 = new Thread(() -> account.withdraw(600, "Sumit"));
    Thread customer2 = new Thread(() -> account.withdraw(700, "Ruchi"));
    Thread customer3 = new Thread(() -> account.withdraw(500, "Nitin"));

    customer1.start();
    customer2.start();
    customer3.start();

    customer1.join();
    customer2.join();
    customer3.join();

    System.out.println("==============================");
    System.out.println("Final balance: $" + account.getBalance());
    System.out.println("Synchronization ensured only valid withdrawals occurred!");
  }
}
