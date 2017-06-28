
// King: The king piece
public class King extends ChessPiece {

  String[] chars = {"WK","BK"};
  // String[] chars = {"♚","♔"}; ONLY USE IF UNICODE IS SUPPORTED
  boolean hasMoved = false;

  King(int color) {
    super.color = color;
    super.symbol = chars[color];
  }

  boolean canCastle(ChessSquare a, ChessSquare b, ChessBoard board) {
    if (hasMoved) return false;
    if (!validAdjacentMove(a, b, board, 2)) return false;

    int dir = b.col-a.col;
    if (dir==0) return false;
    // later check to make sure it doesn't castle through check
    return true;
  }

  /**
   * Returns if the player's king is in check
   *
   * @param player The player of the king
   * @param board The current playing board
   * @return true if the king is currently in check, false otherwise
   */
  boolean isCheck(ChessSquare king, ChessBoard board) {

    for (int i=0; i<8; i++) {
      for (int j=0; j<8; j++) {

        ChessSquare sq = board.board[i][j];
        ChessPiece p = sq.piece;
        if (p != null && !(p instanceof King) && color!=p.color) { // update to include kings
          if (p.validMove(sq, king, board)) return true;
        }

      }
    }

    return false;
  }

  boolean validMove(ChessSquare a, ChessSquare b, ChessBoard board) {
    if (!super.validMove(a, b, board)) return false;
    //if (isCheck(b, board)) return false;

    if (validAdjacentMove(a, b, board, 1)) return true;
    if (validDiagonalMove(a, b, board, 1)) return true;
    if (board.castle(a, b)) return true;

    return false;
  }

}
