public class ChessSquare {
  ChessPiece piece = null;
  int row;
  int col;

  ChessSquare (int x, int y) {
    col = x;
    row = y;
  }

  boolean isOpen() {
    return (piece == null) ? true : false;
  }

  void setPiece(ChessPiece p) {
    piece = p;
  }

}
