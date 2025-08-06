public class ScopeTest {
  public static void main(String[] args) {
    //Test printing the static variable in Scope class


    //Test calling the getInstanceVariable() method and print its result


    //Test method scope

  }

  private static void methodScope(int anyNumber) {
    System.out.println("Anynumber: " + anyNumber);

    double PI = 3.14;
    System.out.println("PI: " + PI);
  }
}
