
// ChessPiece: The generic chess piece object, that holds generic variables (color, symbol) and checks for generic invalid moces
public class ChessPiece {

  int color;     // 0 for white, 1 for black
  String symbol; // Ascii character for that piece

  boolean validMove( ChessSquare a, ChessSquare b ) {

    if ( a.col == b.col && a.row == b.row ) return false; // Origin and destination are the same

    return true;
  }

}
