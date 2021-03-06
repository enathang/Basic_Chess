public class ChessBoard {

  int boardSize = 8;
  ChessSquare[][] board = new ChessSquare[boardSize][boardSize];
  ChessSquare whiteKing; // Keeps track of where the kings are for convenience
  ChessSquare blackKing;

  ChessBoard() {
    for (int i=0; i<boardSize; i++) {
      for (int j=0; j<boardSize; j++) {
        board[i][j] = new ChessSquare(i, j);
      }
    }
  }

  boolean castle(ChessSquare a, ChessSquare b) {
    int dir = (b.col<a.col) ? -1 : 1;
    int rookRow = a.row;
    int rookOrigCol = (dir==-1) ? 0 : boardSize-1;
    int rookNewCol = (dir==-1) ? 2 : 4; // get rid of magic numbers

    ChessSquare moveRookFrom = board[rookOrigCol][rookRow];
    ChessSquare moveRookTo = board[rookNewCol][rookRow];

    if (a.piece instanceof King && a.piece.canCastle(a, b, this)) {
      if (moveRookFrom.piece instanceof Rook && moveRookFrom.piece.canCastle(moveRookFrom, moveRookTo, this)) {
        ChessSquare[] rookMove = {moveRookFrom, moveRookTo};
        movePiece(rookMove);
        return true;
      }
    }

    return false;
  }

  // TODO
  boolean isCheckMate(int player, ChessBoard board) {

    // for each square adjacent to king,
    //   if valid move and not check return false;
    // else return true;

    return false;
  }

  /**
   * Moves the piece from the first ChessSquare to the second
   *
   * @param move an array of ChessSquares where the first is the Origin
   *             and the second is the destination
   * @return none
   */
  void movePiece(ChessSquare[] move) {
    ChessSquare orig = move[0];
    ChessSquare dest = move[1];

    dest.setPiece(orig.piece);
    orig.piece = null;

    // promote pawn if needed
    if (dest.piece instanceof Pawn) {
      if (dest.row==0 && dest.piece.color==1)           dest.setPiece(new Queen(1));
      if (dest.row==boardSize-1 && dest.piece.color==0) dest.setPiece(new Queen(0));
    }

  }

  /**
   * returns the ChessSquare of a string location (ex "C3")
   *
   * @param  s the ChessSquare location as a string
   * @return   the ChessSquare of the string
   */
  ChessSquare getSquareByLocation(String s) {

    char[] location = s.toCharArray();
    char[] validColumns = {'H','G','F','E','D','C','B','A'};
    char[] validRows    = {'1','2','3','4','5','6','7','8'};

    int x = ChessGame.indexOfCharInArray(location[0], validColumns);
    int y = ChessGame.indexOfCharInArray(location[1], validRows);

    ChessSquare square = board[x][y];

    return square;
  }

  /**
   * Prints out the current game board to the console
   *
   * @param none
   * @return none
   */
  void displayBoard() {

    for (int i=7; i>-1; i--) {
      System.out.print( "["+(i+1)+"]" ); // Print out the row number

      for (int j=7; j>-1; j--) {
        ChessPiece p = board[j][i].piece;
        String symbol = (p == null ? "  " : p.symbol);
        System.out.print( "["+symbol+"]" );
      }

      System.out.print("\n");
    }

    System.out.println( "[ ][A ][B ][C ][D ][E ][F ][G ][H ]" ); // Print out the column letters

  }

  // newGame(): Sets all the chess pieces in the correct locations
  /**
   * Sets all of the chess pieces to their starting locations
   *
   * @param none
   * @return none
   */
  void newGame() {

    board[0][0].setPiece(new Rook  (0));                                // First row
    board[1][0].setPiece(new Knight(0));
    board[2][0].setPiece(new Bishop(0));
    board[3][0].setPiece(new King  (0));
    board[4][0].setPiece(new Queen (0));
    board[5][0].setPiece(new Bishop(0));
    board[6][0].setPiece(new Knight(0));
    board[7][0].setPiece(new Rook  (0));

    for (int i=0; i<8; i++) { board[i][1].setPiece( new Pawn(0)); } // Second row

    for (int i=0; i<8; i++) { board[i][6].setPiece(new Pawn(1)); } // Seventh row

    board[0][7].setPiece(new Rook  (1));                                // Eighth row
    board[1][7].setPiece(new Knight(1));
    board[2][7].setPiece(new Bishop(1));
    board[3][7].setPiece(new King  (1));
    board[4][7].setPiece(new Queen (1));
    board[5][7].setPiece(new Bishop(1));
    board[6][7].setPiece(new Knight(1));
    board[7][7].setPiece(new Rook  (1));

    whiteKing = board[3][0];
    blackKing = board[3][7];
  }

}
