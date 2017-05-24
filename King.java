
// King: The king piece
public class King extends ChessPiece {

  King( int c ) {
    super.color  = c;
    super.symbol = "\u2654";
  }

  @Override
  boolean validMove( Square a, Square b ) {

    int[2] orig = a.pos;
    int[2] dest = b.pos;
    if( orig.x == dest.x && orig.y == dest.y )         return false;
    if( dest.x - orig.x > 1 || dest.y - origin.y > 1 ) return false; // TODO Makee Math.abs
    if( !super.validMove )                             return false;

    return true;
  }

}
