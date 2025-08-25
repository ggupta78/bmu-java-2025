import java.util.Arrays;

public class ChessBoardPrinterWithArray {

  public void printBoard() {
    int boardSize = 8;
    char block = '\u2588';
    String[][] board = new String[boardSize][boardSize]; // Declare a 2D array of Strings.

    // Initialize the board with alternating spaces and dots, representing empty
    // squares.
    for (int row = 0; row < boardSize; row++) {
      for (int col = 0; col < boardSize; col++) {
        if ((row + col) % 2 == 0) {
          board[row][col] = "  "; // Represents a light square.
        } else {
          board[row][col] = " " + block; // Represents a dark square.
        }
      }
    }

    System.out.println(Arrays.deepToString(board) + "\n");
    // System.out.println(Arrays.toString(board) + "\n");

    // Print the board, including column and row labels.
    System.out.println("  a b c d e f g h");
    System.out.println(" +-----------------+");

    for (int row = 0; row < boardSize; row++) {
      System.out.print((8 - row) + "|");
      for (int col = 0; col < boardSize; col++) {
        System.out.print(board[row][col]);
      }
      System.out.println(" |" + (8 - row));
    }
    System.out.println(" +-----------------+");
    System.out.println("  a b c d e f g h");
  }
}
