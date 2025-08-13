public class ScopeTest {
  public static void main(String[] args) {
    // Test printing the static variable in Scope class
    System.out.println(Scope.staticVariable);

    // Test calling the getInstanceVariable() method and print its result
    Scope scope = new Scope();
    System.out.println(scope.getInstanceVariable());

    // Test method scope
    int anyNumber = 3;
    String str = "Hello";
    methodScope(str);
    // System.out.println(anyNumber);
    // System.out.println(scope.instanceVariable);
    System.out.println(str);
  }

  private static void methodScope(String str1) {
    // System.out.println("Anynumber: " + anyNumber);
    // anyNumber = 7;

    System.out.println(str1);
    str1 = "Hello World!";

    // System.out.println(scope.instanceVariable);
    // scope.instanceVariable = 7;

    double PI = 3.14;
    System.out.println("PI: " + PI);
  }
}
