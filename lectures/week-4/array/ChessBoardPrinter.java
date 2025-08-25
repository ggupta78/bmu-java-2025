public class ChessBoardPrinter {

  public void printBoard() {
    int boardSize = 8; // Standard chessboard size
    char block = '\u2588'; // '\u20DE';

    // Print column labels
    System.out.print("  "); // Offset for row numbers
    for (char col = 'a'; col <= 'h'; col++) {
      System.out.print(" " + col);
    }
    System.out.println();

    for (int row = 0; row < boardSize; row++) {
      // Row Loop
      System.out.print((row + 1) + " "); // Print row number

      for (int col = 0; col < boardSize; col++) {
        // Determine if the square is "white" or "black"
        if ((row + col) % 2 == 0) {
          System.out.print("  "); // Represent a "white" square
        } else {
          System.out.print(" " + block); // Represent a "black" square
        }
      }
      System.out.println(" " + (8 - row)); // Print row number again
    }

    // Print column labels again for bottom
    System.out.print("  ");
    for (char col = 'a'; col <= 'h'; col++) {
      System.out.print(" " + col);
    }
    System.out.println();
  }
}
