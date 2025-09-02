// File: package1/BaseClass.java
package package1;

public class BaseClass {
  public int publicVar = 1;
  protected int protectedVar = 2;
  int defaultVar = 3; // default (package-private)
  private int privateVar = 4;

  public void displayPrivateVar() {
    System.out.println("Inside BaseClass: privateVar = " + privateVar);
  }
}
