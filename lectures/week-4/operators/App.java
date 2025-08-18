public class App {
  public static void main(String[] args) {
    Operators operators = new Operators();

    System.out.println("\nInt Arithmetic");
    operators.intArithmetic();

    System.out.println("\nDouble Arithmetic");
    operators.doubleArithmetic();

    System.out.println("\nModulus");
    operators.modulusDemo();

    System.out.println("\nCompound Assignment");
    operators.compoundAssignment();

    System.out.println("\nIncrement and Decrement");
    operators.incDecDemo();

    System.out.println("\nBitwise Operators");
    operators.bitwiseOperators();

    System.out.println("\nLeft and Right Shift");
    operators.leftRightShift();

    System.out.println("\nUnsigned Right Shift");
    operators.unsignedRightShift();

    System.out.println("\nOperator Precedence");
    operators.operatorPrecedence();
  }
}
