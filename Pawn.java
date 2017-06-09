
// Pawn: The pawn piece
public class Pawn extends ChessPiece {

  String[] chars = {"WP","BP"};
  // String[] chars = {"♟","♙"}; ONLY USE IF UNICODE IS SUPPORTED
  boolean hasMoved = false;

  Pawn(int color) {
    super.color = color;
    super.symbol = chars[color];
  }

  boolean validMove(ChessSquare a, ChessSquare b, ChessBoard board) {

    if (color == 0) {
      if (b.row - a.row < 1) return false;
    }

    if (color == 1) {
      if (b.row - a.row > -1) return false;
    }

    if (!super.validMove (a, b, board)) return false;

    if (b.col != a.col && b.piece == null) return false;

    if (super.validDiagonalMove(a, b, board, 1))                                 { hasMoved = true; return true; }
    if (super.validAdjacentMove(a, b, board, 1) && b.piece == null )             { hasMoved = true; return true; }
    if (super.validAdjacentMove(a, b, board, 2) && b.piece == null && !hasMoved) { hasMoved = true; return true; }

    return false;
  }

}
