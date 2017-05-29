
// Queen: The queen piece
public class Queen extends ChessPiece {

  String[] chars = {"♛","♕"};
  boolean hasMoved = false;

  Queen( int color ) {
    super.color = color;
    super.symbol = chars[color];
  }


  boolean validMove( ChessSquare a, ChessSquare b ) {
    return true;
  }

}
