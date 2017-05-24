/*
 * All the chess logic
 */

public class ChessBoard {

  ChessSquare[8][8] board;

  ChessBoard() {

    for( int i=0 ; i<8; i++ ) { // Column
      for( int j=0 ; j<8 ; j++ ) { // Row
        board[i][j] = new ChessSquare();
      }
    }

  }

  // displayBoard(): prints out the current game board to the console
  void displayBoard() {

    for( int i=0 ; i<8 ; i++ ) {
      for( int j=0 ; j<8 ; j++ ) {

        String symbol = " ";
        if( board[i][j].piece != null ) symbol = board[i][j].piece.symbol;
        System.out.print( "["+symbol+"]" );

      }
      System.out.print("\n");
    }

  }

  // newGame(): Sets all the chess pieces in the correct locations
  void newGame() {

    board[0][0].setPiece( new Rook  ( white ) );                                // First row
    board[1][0].setPiece( new Knight( white ) );
    board[2][0].setPiece( new Bishop( white ) );
    board[3][0].setPiece( new Queen ( white ) );
    board[4][0].setPiece( new King  ( white ) );
    board[5][0].setPiece( new Bishop( white ) );
    board[6][0].setPiece( new Knight( white ) );
    board[7][0].setPiece( new Rook  ( white ) );

    for ( int i=0 ; i<8 ; i++ ) { board[i][1].setPiece( new Pawn ( white ) ); } // Second row

    for ( int i=0 ; i<8 ; i++ ) { board[i][1].setPiece( new Pawn ( black ) ); } // Seventh row

    board[0][7].setPiece( new Rook  ( black ) );                                // Eighth row
    board[1][7].setPiece( new Knight( black ) );
    board[2][7].setPiece( new Bishop( black ) );
    board[3][7].setPiece( new Queen ( black ) );
    board[4][7].setPiece( new King  ( black ) );
    board[5][7].setPiece( new Bishop( black ) );
    board[6][7].setPiece( new Knight( black ) );
    board[7][7].setPiece( new Rook  ( black ) );

  }

}
