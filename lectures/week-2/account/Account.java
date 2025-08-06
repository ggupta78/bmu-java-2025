public class Account {
  private String name;
  private double balance;

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setBalance(double balance) {
    if (balance >= 0.0) {
      this.balance = balance;
    }
  }

  public double getBalance() {
    return this.balance;
  }
}
