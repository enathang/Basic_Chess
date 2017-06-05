
// King: The king piece
public class King extends ChessPiece {

  String[] chars = {"WK","BK"};
  // String[] chars = {"♚","♔"}; ONLY USE IF UNICODE IS SUPPORTED
  boolean hasMoved = false;

  King( int color ) {
    super.color = color;
    super.symbol = chars[color];
  }


  boolean validMove( ChessSquare a, ChessSquare b, ChessBoard board ) {

    if ( validAdjacentMove ( a, b, board, 1 ) ) return true;
    if ( validDiagonalMove ( a, b, board, 1 ) ) return true;

    return false;
  }

}
