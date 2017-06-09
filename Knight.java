
// Knight: The knight piece
public class Knight extends ChessPiece {

  String[] chars = {"WN","BN"};
  // String[] chars = {"♞","♘"}; ONLY USE IF UNICODE IS SUPPORTED
  boolean hasMoved = false;

  Knight(int color) {
    super.color = color;
    super.symbol = chars[color];
  }

  boolean validMove(ChessSquare a, ChessSquare b, ChessBoard board) {
    return super.validKnightMove(a, b, board) ? true : false;
  }

}
