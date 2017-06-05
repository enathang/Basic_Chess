
// Queen: The queen piece
public class Queen extends ChessPiece {

  String[] chars = {"WQ","BQ"};
  // String[] chars = {"♛","♕"}; ONLY USE IF UNICODE IS SUPPORTED
  boolean hasMoved = false;

  Queen( int color ) {
    super.color = color;
    super.symbol = chars[color];
  }


  boolean validMove( ChessSquare a, ChessSquare b, ChessBoard board ) {

    if ( validDiagonalMove ( a, b, board, 8 ) ) return true;
    if ( validAdjacentMove ( a, b, board, 8 ) ) return true;

    return false;
  }

}
