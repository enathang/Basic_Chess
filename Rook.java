
// Rook: The rook piece
public class Rook extends ChessPiece {

  String[] chars = {"WR","BR"};
  // String[] chars = {"♜","♖"}; ONLY USE IF UNICODE IS SUPPORTED
  boolean hasMoved = false;

  Rook(int color) {
    super.color = color;
    super.symbol = chars[color];
  }

  boolean validMove(ChessSquare a, ChessSquare b, ChessBoard board) {
    return super.validAdjacentMove(a, b, board, 8) ? true : false;
  }

}
