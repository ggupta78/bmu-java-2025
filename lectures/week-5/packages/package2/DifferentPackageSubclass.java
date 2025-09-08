// File: package2/DifferentPackageSubclass.java
package package2;

import package1.BaseClass;

public class DifferentPackageSubclass extends BaseClass {
  public void testAccess() {
    System.out.println("From DifferentPackageSubclass:");
    System.out.println("Public var: " + publicVar);
    System.out.println("Protected var: " + protectedVar);
    // System.out.println("Default var: " + defaultVar); // ERROR: default access
    // System.out.println("Private var: " + privateVar); // ERROR: private access
  }

  public static void main(String[] args) {
    DifferentPackageSubclass differentPackageSubclass = new DifferentPackageSubclass();

    differentPackageSubclass.testAccess();
  }
}
