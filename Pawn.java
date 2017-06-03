
// Pawn: The pawn piece
public class Pawn extends ChessPiece {

  String[] chars = {"WP","BP"};
  // String[] chars = {"♟","♙"}; ONLY USE IF UNICODE IS SUPPORTED
  boolean hasMoved = false;

  Pawn( int color ) {
    super.color = color;
    super.symbol = chars[color];
  }


  boolean validMove( ChessSquare a, ChessSquare b ) {

    if ( !super.validMove ( a, b ) ) return false;
    if ( a.col != b.col ) return false;
    //check that pawn doesnt move more than 1/2 spaces but differentfor black and white

    return true;
  }

}
