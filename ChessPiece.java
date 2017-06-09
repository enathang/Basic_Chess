import java.lang.Math;

// ChessPiece: The generic chess piece object, that holds generic variables (color, symbol) and checks for generic invalid moces
public class ChessPiece {
  int color;     // 0 for white, 1 for black
  String symbol; // Ascii character for that piece

  // returns if a is +, -, or 0
  int getSign ( int a ) {
    if (a == 0) return 0; // to avoid a division by 0 error
    return a/Math.abs(a);
  }

  /**
   * Checks that a and b are diagonal, close enough, and there is no piece in the way
   *
   * @param a         the origin of the move
   * @param b         the destination of the move
   * @param board     the chessboard currently in play
   * @param numSpaces the number of spaces the piece is allowed to move diagonally (either 1 or 8)
   * @return          whether the move is valid or not
   */
  boolean validDiagonalMove(ChessSquare a, ChessSquare b, ChessBoard board, int numSpaces) {
    int numRowsAbs = Math.abs(b.row - a.row);
    int numColsAbs = Math.abs(b.col - a.col);

    int rowSign = getSign(b.row - a.row); // Indicates whether to loop + or - in while loop
    int colSign = getSign(b.col - a.col);

    if (numColsAbs != numRowsAbs) return false;
    if (numColsAbs > numSpaces) return false;

    for (int i=1; i<numColsAbs; i++) {

      int x = a.col + (i*colSign);
      int y = a.row + (i*rowSign);
      if (board.board[x][y].piece != null) return false;

    }

    return true;
  }

  /**
   * Checks that a and b are adjacent, close enough, and there is no piece in the way
   *
   * @param a         the origin of the move
   * @param b         the destination of the move
   * @param board     the chessboard currently in play
   * @param numSpaces the number of spaces the piece is allowed to move adjacently (either 1 or 8)
   * @return          whether the move is valid or not
   */
  boolean validAdjacentMove (ChessSquare a, ChessSquare b, ChessBoard board, int numSpaces) {
    int numRowsAbs = Math.abs(b.row - a.row);
    int numColsAbs = Math.abs(b.col - a.col);

    int rowSign = getSign(b.row - a.row); // Indicates whether to loop + or - in while loop
    int colSign = getSign(b.col - a.col);

    if ((numColsAbs!=0) && (numRowsAbs!=0) ) return false;
    if (numColsAbs > numSpaces) return false;
    if (numRowsAbs > numSpaces) return false;

    for (int i=1; i<(numColsAbs+numRowsAbs); i++) {

      int x = a.col + (i*colSign);
      int y = a.row + (i*rowSign);

      if (board.board[x][y].piece != null) return false;

    }

    return true;
  }

  /**
   * Checks that b is within the range of a for a knight
   *
   * @param a         the origin of the move
   * @param b         the destination of the move
   * @param board     the chessboard currently in play
   * @return          whether the move is valid or not
   */
  boolean validKnightMove(ChessSquare a, ChessSquare b, ChessBoard board) {
    int numRowsAbs = Math.abs(b.row - a.row);
    int numColsAbs = Math.abs(b.col - a.col);

    if (numRowsAbs == 2 && numColsAbs == 1) return true;
    if (numRowsAbs == 1 && numColsAbs == 2) return true;

    return false;
  }

  /**
   * Checks that a to b is a valid move generically
   *
   * @param a         the origin of the move
   * @param b         the destination of the move
   * @param board     the chessboard currently in play
   * @return          whether the move is valid or not
   */
  boolean validMove(ChessSquare a, ChessSquare b, ChessBoard board) {
    if (a.col == b.col && a.row == b.row) return false; // Origin and destination are the same

    if (b.piece != null) {
      if (color == b.piece.color) return false; // Cannot land on piece of same color
    }

    return true;
  }

}
