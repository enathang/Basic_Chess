
// ChessSquare: The ChessBoard has 8x8 of these, which can hold a piece
public class ChessSquare {

  boolean open = true;
  ChessPiece piece = null;
  int row;
  int col;

  ChessSquare (int x, int y) {
    row = x;
    col = y;
  }

  void setPiece(ChessPiece p) {
    piece = p;
  }

}
