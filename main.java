import java.util.Scanner;

public class main {



  /**
   * Returns the index of the char in a given array, or -1 if not in array.
   *
   * @param  a     the char to search for
   * @param  array the array of chars to search through
   * @return       the index of the char, or -1 if not found
   */
   public static int indexOfCharInArray(char a, char[] array) {
     for ( int i=0 ; i<array.length ; i++ ) {
       if( a == array[i] ) return i;
     }

     return -1;
   }

   /**
    * Returns whether the array constains the char.
    *
    * @param  a     the char to search for
    * @param  array the array of chars to search through
    * @return       whether the char is in the array
    */
   static boolean arrayContainsChar(char a, char[] array) {
     if (indexOfCharInArray (a, array) == -1) return false;

     return true;
     }

  /**
   * Returns whether the string is correctly formatted according to
   * "Row1Col1, Row2Col2" (ex. "C2, C4");
   *
   * @param  s the input string to test if correctly formatted
   * @return   whether the string is correctly formatted or not
   */
  static boolean isCorrectlyFormatted(String s) {
    char[] input = s.toCharArray();
    char[] validColumns = {'A','B','C','D','E','F','G','H'};
    char[] validRows    = {'1','2','3','4','5','6','7','8'};
    int expectedInputSize = 6; // Based on formatting "A1, B2"

    if (input.length < expectedInputSize) {
      System.out.println( "Input is too short" );
      return false;
    }

    if (input.length > expectedInputSize) {
      System.out.println( "Input is too long" );
      return false;
    }

    if (!arrayContainsChar(input[0], validColumns)) {
      System.out.println( "Input column 1 not recognized" );
      return false;
    }

    if (!arrayContainsChar(input[1], validRows)) {
      System.out.println( "Input row 1 not recognized" );
      return false;
    }

    if (!arrayContainsChar(input[4], validColumns)) {
      System.out.println( "Input column 2 not recognized" );
      return false;
    }

    if (!arrayContainsChar(input[5], validRows)) {
      System.out.println( "Input row 2 not recognized" );
      return false;
    }

    return true;
  }


  /**
   * Returns whether the move passed is allowed
   *
   * @param  orig   the ChessSquare the piece is moved from
   * @param  dest   the ChessSquare the piece is moved to
   * @param  player the player whose turn it is
   * @param  board  the chessBoard that is currently in play
   * @return        Whether the move is permissible or not
   */
  static boolean allowableChessMove( ChessSquare orig, ChessSquare dest, int player, ChessBoard board ) {

    if ( orig.piece == null ) {
      System.out.println("Could not find a piece at the square");
      return false;
    }

    if ( orig.piece.color != player ) {
      System.out.println("Cannot move other player's piece");
      return false;
    }

    ChessPiece piece = orig.piece;
    if ( !piece.validMove( orig, dest, board ) ) {
      System.out.println("Piece cannot move in that way");
      return false;
    }

    //!exposesCheck();

    return true;

  }

  /**
   * Keeps prompting the user for a valid input until they enter a valid
   * chess move, then returns it
   *
   * @param player the player whose turn it is
   * @param board  the ChessBoard currently in play
   * @return       the valid chess move, composed in an array where the first
   *               ChessSquare is the origin and the second is the destination
   */
  static ChessSquare[] getValidUserInput( int player, ChessBoard board ) {

    Scanner s = new Scanner(System.in);

    ChessSquare orig = null;
    ChessSquare dest = null;

    boolean inputCorrectlyFormatted = false;
    boolean allowableChessMove = false;
    String input = "";

    while ( !inputCorrectlyFormatted || !allowableChessMove ) {

      System.out.println( "Enter a move player " + (player+1) + " (ex \"C2, C3\")" );
      input = s.nextLine();
      inputCorrectlyFormatted = isCorrectlyFormatted( input );

      if( inputCorrectlyFormatted ) {

        orig = board.getSquareByLocation(input.substring(0,2));
        dest = board.getSquareByLocation(input.substring(4,6));

        allowableChessMove = allowableChessMove( orig, dest, player, board );
      }

    }

    s.close();
    ChessSquare[] move = {orig, dest};
    return move;

  }

    /**
     * Starts the game and runs through the game loop
     *
     * @param  args Any command line arguments
     * @return      Ends when the progam is exited
     */
    public static void main( String[] args ) {

      // Create the game
      ChessBoard board = new ChessBoard();
      board.newGame();
      boolean gameOver = false;
      int player = 0;

      // Run game loop
      while( !gameOver ) {

        board.displayBoard();
        ChessSquare[] playerMove = getValidUserInput( player, board );
        board.movePiece (playerMove);
        gameOver = board.isCheckMate(player, board);
        player = (player+1)%2;

      }

      // Game is over

    }
  }
