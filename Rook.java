
// Rook: The rook piece
public class Rook extends ChessPiece {

  String[] chars = {"♜","♖"};
  boolean hasMoved = false;

  Rook( int color ) {
    super.color = color;
    super.symbol = chars[color];
  }


  boolean validMove( ChessSquare a, ChessSquare b ) {
    return true;
  }

}
