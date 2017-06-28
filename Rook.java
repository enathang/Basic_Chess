
// Rook: The rook piece
public class Rook extends ChessPiece {

  String[] chars = {"WR","BR"};
  // String[] chars = {"♜","♖"}; ONLY USE IF UNICODE IS SUPPORTED
  boolean hasMoved = false;

  Rook(int color) {
    super.color = color;
    super.symbol = chars[color];
  }

  boolean canCastle(ChessSquare a, ChessSquare b, ChessBoard board) {
    if (hasMoved) return false;
    if (!validAdjacentMove(a, b, board, 8)) return false;
    
    return true;
  }

  boolean validMove(ChessSquare a, ChessSquare b, ChessBoard board) {
    if (!super.validMove(a, b, board)) return false;
    return super.validAdjacentMove(a, b, board, 8) ? true : false;
  }

}
