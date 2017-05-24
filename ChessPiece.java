
// ChessPiece: The generic chess piece object, that holds generic variables (color, symbol) and checks for generic invalid moces
public class ChessPiece {

  int color;     // 0 for white, 1 for black
  String symbol; // Ascii character for that piece

  boolean validMove( Square a, Square b ) {
    if ( a.pos.x == b.pos.x && a.pos.y == b.pos.y ) return false; // Origin and destination are the same
    
  }

}
