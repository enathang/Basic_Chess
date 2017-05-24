

void getMove() {

  boolean validMove = false;

  while ( !validMove ) {
    System.out.println("Enter a move: ");
  }

}

public static void main( String[] args ) {

  ChessBoard board = new ChessBoard();

  boolean gameOver = false;

  while ( !gameOver ) {
    getMove( board );
  }

}
