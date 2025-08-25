import java.util.Arrays;

public class App {

  public static void main(String[] args) {
    ArrayExample arrayExample = new ArrayExample();

    // arrayExample.setNumbers(4, 5, 6);
    // System.out.println(Arrays.toString(arrayExample.getNumbers()));
    // System.out.println();

    // arrayExample.generatePrimes(10);
    // System.out.println(Arrays.toString(arrayExample.getPrimes()));
    // System.out.println();

    // System.out.println("GoldenRatio:" + arrayExample.getConstant("GoldenRatio"));
    // // System.out.println("PI:");
    // // System.out.println("SpeedOfLight:");
    // // System.out.println("Gravitational:");
    // System.out.println("Plancks:" + arrayExample.getConstant("Plancks"));
    // System.out.println();

    // arrayExample.printCities();
    // System.out.println();

    // ChessBoardPrinter chessBoardPrinter = new ChessBoardPrinter();
    // chessBoardPrinter.printBoard();
    // System.out.println();

    ChessBoardPrinterWithArray chessBoardPrinterWithArray = new ChessBoardPrinterWithArray();
    chessBoardPrinterWithArray.printBoard();
    System.out.println();
  }
}
