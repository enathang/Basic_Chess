
// ChessSquare: The ChessBoard has 8x8 of these, which can hold a piece
public class ChessSquare {

  boolean open = true;
  ChessPiece piece = null;
  int[] pos = {1,1};

  void setPiece(ChessPiece p) {
    piece = p;
  }

}
