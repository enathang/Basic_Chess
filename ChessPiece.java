
// ChessPiece: The generic chess piece object, that holds generic variables (color, symbol) and checks for generic invalid moces
public class ChessPiece {

  int color;     // 0 for white, 1 for black
  String symbol; // Ascii character for that piece

  boolean validMove( ChessSquare a, ChessSquare b ) {
    int[] orig = a.pos;
    int[] dest = b.pos;

    if ( orig[0] == dest[0] && orig[1] == dest[1] ) return false; // Origin and destination are the same

    return true;
  }

}
