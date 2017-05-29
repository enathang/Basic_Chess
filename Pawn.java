
// Pawn: The pawn piece
public class Pawn extends ChessPiece {

  String[] chars = {"♟","♙"};
  boolean hasMoved = false;

  Pawn( int color ) {
    super.color = color;
    super.symbol = chars[color];
  }

  
  boolean validMove( ChessSquare a, ChessSquare b ) {

  }

}
