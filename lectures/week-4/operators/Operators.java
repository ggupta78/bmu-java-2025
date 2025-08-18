public class Operators {
  public void intArithmetic() {
    int a = 1 + 1;
    int b = a * 3;
    int c = b / 4;
    int d = c - a;
    int e = -d;
    System.out.println("a = " + a);
    System.out.println("b = " + b);
    System.out.println("c = " + c);
    System.out.println("d = " + d);
    System.out.println("e = " + e);
  }

  public void doubleArithmetic() {
    double a = 1 + 1;
    double b = a * 3;
    double c = b / 4;
    double d = c - a;
    double e = -d;
    System.out.println("a = " + a);
    System.out.println("b = " + b);
    System.out.println("c = " + c);
    System.out.println("d = " + d);
    System.out.println("e = " + e);
  }

  public void modulusDemo() {
    int x = 42;
    double y = 42.25;

    System.out.println("42 mod 10 = " + x % 10);
    System.out.println("42.25 mod 10 = " + y % 10);
  }

  public void compoundAssignment() {
    int a = 1, b = 2, c = 3;

    a += 5;
    b *= 4;
    c += a * b;
    c %= 6;

    System.out.println("a = " + a);
    System.out.println("b = " + b);
    System.out.println("c = " + c);
  }

  public void incDecDemo() {
    int a = 1, b = 3, c, d;

    c = ++b;
    d = a++;
    c++;

    System.out.println("a = " + a);
    System.out.println("b = " + b);
    System.out.println("c = " + c);
    System.out.println("d = " + d);
  }

  public void bitwiseOperators() {
    int i = 42, j = 15;

    System.out.println("\nAnd");
    System.out.println(this.toBinaryStringPadded(i) + " 42");
    System.out.println(this.toBinaryStringPadded(j) + " 15");
    System.out.println(this.toBinaryStringPadded(i & j) + " " + (42 & 15));

    System.out.println("\nOr");
    System.out.println(this.toBinaryStringPadded(i) + " 42");
    System.out.println(this.toBinaryStringPadded(j) + " 15");
    System.out.println(this.toBinaryStringPadded(i | j) + " " + (42 | 15));

    System.out.println("\nXOR");
    System.out.println(this.toBinaryStringPadded(i) + " 42");
    System.out.println(this.toBinaryStringPadded(j) + " 15");
    System.out.println(this.toBinaryStringPadded(i ^ j) + " " + (42 ^ 15));
  }

  public void leftRightShift() {
    int i = 256;

    System.out.println("\nLeft Shift");
    System.out.println(this.toBinaryStringPadded(i << 1) + " " + (i << 1));

    System.out.println("\nRight Shift");
    System.out.println(this.toBinaryStringPadded(i >> 2) + " " + (i >> 2));
  }

  public void unsignedRightShift() {
    int positiveNum = 10; // Binary: 0000...1010
    int shiftedPositive = positiveNum >>> 2; // Result: 2 (Binary: 0000...0010)

    int negativeNum = -10; // Binary: 1111...0110
    int shiftedNegative = negativeNum >>> 2; // Result: a large positive number (Binary: 0011...1101)

    System.out.println(this.toBinaryStringPadded(shiftedPositive) + " " + shiftedPositive);
    System.out.println(this.toBinaryStringPadded(shiftedNegative) + " " + shiftedNegative);

  }

  // Private Method

  private String toBinaryStringPadded(int number) {
    String binaryString = Integer.toBinaryString(number);
    String paddedBinaryString = String.format("%8s", binaryString).replace(' ', '0');
    return paddedBinaryString;
  }
}
