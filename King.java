
// King: The king piece
public class King extends ChessPiece {

  String[] chars = {"♚","♔"};
  boolean hasMoved = false;

  King( int color ) {
    super.color = color;
    super.symbol = chars[color];
  }


  boolean validMove( ChessSquare a, ChessSquare b ) {
    return true;
  }

}
