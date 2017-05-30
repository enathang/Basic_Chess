/*
 * All the chess logic
 */

public class ChessBoard {

  ChessSquare[][] board = new ChessSquare[8][8];

  ChessBoard() {
    for( int i=0 ; i<8; i++ ) { // Column
      for( int j=0 ; j<8 ; j++ ) { // Row
        board[i][j] = new ChessSquare();
      }
    }


  }

  // TODO
  boolean isGameOver() {
    return false;
  }

  // TODO
  void movePiece( String move ) {

  }

  // TODO
  ChessSquare getPieceByLocation( String s ) {
    ChessSquare a = new ChessSquare();
    return a;
  }

  // displayBoard(): prints out the current game board to the console
  void displayBoard() {

    for( int i=0 ; i<8 ; i++ ) {
      for( int j=0 ; j<8 ; j++ ) {

        String symbol = " ";
        if( board[i][j].piece != null ) {symbol = board[i][j].piece.symbol;}
        System.out.print( "["+symbol+"]" );

      }
      System.out.print("\n");
    }

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
