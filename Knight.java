
// Knight: The knight piece
public class Knight extends ChessPiece {
  String[] chars = {"♞","♘"};
  boolean hasMoved = false;

  Knight( int color ) {
    super.color = color;
    super.symbol = chars[color];
  }


  boolean validMove( ChessSquare a, ChessSquare b ) {
    return true;
  }
  
}
