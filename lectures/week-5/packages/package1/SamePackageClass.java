// File: package1/SamePackageClass.java
package package1;

public class SamePackageClass {
  public void testAccess() {
    BaseClass base = new BaseClass();

    System.out.println("From SamePackageClass:");
    System.out.println("Public var: " + base.publicVar);
    System.out.println("Protected var: " + base.protectedVar);
    System.out.println("Default var: " + base.defaultVar);
    // System.out.println("Private var: " + base.privateVar); // ERROR: private
    // access

    base.displayPrivateVar();
  }

  public static void main(String[] args) {
    SamePackageClass samePackageClass = new SamePackageClass();

    samePackageClass.testAccess();

  }
}
