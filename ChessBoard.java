/*
 * All the chess logic
 */

public class ChessBoard {

  ChessSquare[][] board = new ChessSquare[8][8];

  ChessBoard() {
    for( int i=0 ; i<8; i++ ) { // Column
      for( int j=0 ; j<8 ; j++ ) { // Row
        board[i][j] = new ChessSquare( i, j );
      }
    }


  }

  // TODO
  boolean isCheckMate() {
    return false;
  }

  // movePiece: Takes in two ChessSquares and moves the piece from the first to the second
  void movePiece( ChessSquare[] move ) {
    ChessSquare orig = move[0];
    ChessSquare dest = move[1];

    dest.piece = orig.piece;
    orig.piece = null;

  }

  // getPieceByLocation: returns the ChessSquare at the location
  //                     (might need to change main.indexOfCharInArray)
  ChessSquare getPieceByLocation( String s ) {

    char[] location = s.toCharArray();
    char[] validColumns = {'A','B','C','D','E','F','G','H'};
    char[] validRows    = {'1','2','3','4','5','6','7','8'};

    int x = main.indexOfCharInArray(validColumns, location[0]);
    int y = main.indexOfCharInArray(validRows, location[1]);

    ChessSquare square = board[x][y];

    return square;
  }

  // displayBoard(): prints out the current game board to the console
  void displayBoard() {


    for( int i=7 ; i>-1 ; i-- ) {

      System.out.print( "["+(i+1)+"]" );

      for( int j=7 ; j>-1 ; j-- ) {

        String symbol = "  ";
        if( board[j][i].piece != null ) {symbol = board[j][i].piece.symbol;} // i and j are reversed
        System.out.print( "["+symbol+"]" );

      }
      System.out.print("\n");
    }

    System.out.println( "[ ][A ][B ][C ][D ][E ][F ][G ][H ]" );

  }

  // newGame(): Sets all the chess pieces in the correct locations
  void newGame() {

    board[0][0].setPiece( new Rook  ( 0 ) );                                // First row
    board[1][0].setPiece( new Knight( 0 ) );
    board[2][0].setPiece( new Bishop( 0 ) );
    board[3][0].setPiece( new Queen ( 0 ) );
    board[4][0].setPiece( new King  ( 0 ) );
    board[5][0].setPiece( new Bishop( 0 ) );
    board[6][0].setPiece( new Knight( 0 ) );
    board[7][0].setPiece( new Rook  ( 0 ) );

    for ( int i=0 ; i<8 ; i++ ) { board[i][1].setPiece( new Pawn ( 0 ) ); } // Second row

    for ( int i=0 ; i<8 ; i++ ) { board[i][6].setPiece( new Pawn ( 1 ) ); } // Seventh row

    board[0][7].setPiece( new Rook  ( 1 ) );                                // Eighth row
    board[1][7].setPiece( new Knight( 1 ) );
    board[2][7].setPiece( new Bishop( 1 ) );
    board[3][7].setPiece( new Queen ( 1 ) );
    board[4][7].setPiece( new King  ( 1 ) );
    board[5][7].setPiece( new Bishop( 1 ) );
    board[6][7].setPiece( new Knight( 1 ) );
    board[7][7].setPiece( new Rook  ( 1 ) );

  }

}
