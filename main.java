
import java.util.Scanner;

public class main {

  // indexOfCharInArray: Returns the index of char in array, -1 if not in array
  public static int indexOfCharInArray( char[] array, char a) {

    for ( int i=0 ; i<array.length ; i++ ) {

      if( a == array[i] ) return i;

    }

    return -1;

  }

  // arrayContainsChar: returns true if the array contains the char
  static boolean arrayContainsChar( char[] array, char a ) {

    if ( indexOfCharInArray ( array, a ) == -1 ) return false;

    return true;

  }


  // isValidInput: returns true if the string is formatted correctly
  static boolean isCorrectlyFormatted( String s ) {
    char[] input = s.toCharArray();
    char[] validColumns = {'A','B','C','D','E','F','G','H'};
    char[] validRows    = {'1','2','3','4','5','6','7','8'};

    if ( s.length() < 6 ) {
      System.out.println( "Input is too short" );
      return false;
    }

    if( s.length() > 6 ) {
      System.out.println( "Input is too long" );
      return false;
    }

    if( !arrayContainsChar( validColumns, input[0] ) ) {
      System.out.println( "Input column 1 not recognized" );
      return false;
    }

    if( !arrayContainsChar( validRows, input[1] ) ) {
      System.out.println( "Input row 1 not recognized" );
      return false;
    }

    if( !arrayContainsChar( validColumns, input[4] ) ) {
      System.out.println( "Input column 2 not recognized" );
      return false;
    }

    if( !arrayContainsChar( validRows, input[5] ) ) {
      System.out.println( "Input row 2 not recognized" );
      return false;
    }

    return true;
  }


  // validChessMove: returns true if the move is legal in chess
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


  // getValidUserInput: keeps prompting the user for an input until they enter
  //                    a valid chess move, then returns it
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


    // main: Start the game and loop through the game loop
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
        gameOver = board.isCheckMate();
        player = (player+1)%2;

      }

      // Game is over

    }
  }
