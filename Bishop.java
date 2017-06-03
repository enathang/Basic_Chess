
// Bishop: The bishop piece
public class Bishop extends ChessPiece {

  String[] chars = {"WB","BB"};
  // String[] chars = {"♗","♗"}; ONLY USE IF UNICODE IS SUPPORTED
  boolean hasMoved = false;

  Bishop( int color ) {
    super.color = color;
    super.symbol = chars[color];
  }


  boolean validMove( ChessSquare a, ChessSquare b ) {
    return true;
  }
}
