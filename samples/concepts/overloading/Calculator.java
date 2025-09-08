public class Calculator {

  // Overloaded method 1: Adds two integers
  public int add(int a, int b) {
    System.out.println("Adding two integers: " + (a + b));
    return a + b;
  }

  // Overloaded method 2: Adds two doubles
  public double add(double a, double b) {
    System.out.println("Adding two doubles: " + (a + b));
    return a + b;
  }

  // Methods cannot be overloaded just on return type
  // public float add(double x, double y) {
  // System.err.println("Adding two doubles: " + (x + y));
  // return (float) (x + y);
  // }

  // Overloaded method 3: Adds three integers
  public int add(int a, int b, int c) {
    System.out.println("Adding three integers: " + (a + b + c));
    return a + b + c;
  }

  public static void main(String[] args) {
    Calculator calc = new Calculator();

    calc.add(10, 20); // Calls method 1, the int version
    calc.add(10.5, 20.5); // Calls method 2, the double version
    calc.add(10, 20, 30); // Calls method 3, the three-integer version

    // Object oCalc = new Calculator();
    // double result = ((Calculator) oCalc).add(100.5, 200.5);
    // System.out.println("Object based result: " + result);
  }
}
