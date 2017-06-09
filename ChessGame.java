import java.util.Scanner;

public class ChessGame {
  static ChessBoard board;
  static int currPlayer;
  static boolean gameOver;

  ChessGame() {
    board = new ChessBoard();
    currPlayer = 0;
    gameOver = false;
  }

  static boolean printUserErrorAndReturnFalse(String s) {
    System.out.println(s);
    return false;
  }

  /**
   * Creates a new board and runs through the game loop
   */
  public void play() {
    board.newGame();

    while (!gameOver) {
      board.displayBoard();
      ChessSquare[] playerMove = getValidUserInput();
      board.movePiece(playerMove);
      gameOver = board.isCheckMate(currPlayer, board);
      currPlayer = (currPlayer + 1) % 2;
    }

  }

  /**
   * Returns the index of the char in a given array, or -1 if not in array.
   *
   * @param  a     the char to search for
   * @param  array the array of chars to search through
   * @return       the index of the char, or -1 if not found
   */
   public static int indexOfCharInArray(char a, char[] array) {
     for (int i=0; i<array.length; i++) {
       if (a == array[i]) return i;
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
     return (indexOfCharInArray(a, array) != -1) ? true : false;
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

    if (input.length < expectedInputSize)           return printUserErrorAndReturnFalse("Your input is too short");
    if (input.length > expectedInputSize)           return printUserErrorAndReturnFalse("Your input is too long");
    if (!arrayContainsChar(input[0], validColumns)) return printUserErrorAndReturnFalse("Could not recognize your first column");
    if (!arrayContainsChar(input[1], validRows))    return printUserErrorAndReturnFalse("Could not recognize your first row");
    if (!arrayContainsChar(input[4], validColumns)) return printUserErrorAndReturnFalse("Could not recognize your second column");
    if (!arrayContainsChar(input[5], validRows))    return printUserErrorAndReturnFalse("Could not recognize your second row");
    return true;
  }

  /**
   * Returns whether the move passed is allowed
   *
   * @param  orig   the ChessSquare the piece is moved from
   * @param  dest   the ChessSquare the piece is moved to
   * @return        Whether the move is permissible or not
   */
  static boolean allowableChessMove(ChessSquare orig, ChessSquare dest) {
    if (orig.isOpen())                            return printUserErrorAndReturnFalse("There is no chess piece at that square to move");
    if (orig.piece.color != currPlayer)           return printUserErrorAndReturnFalse("You cannot move the other player's piece");
    if (!orig.piece.validMove(orig, dest, board)) return printUserErrorAndReturnFalse("That piece cannot move in that way");
    //!exposesCheck();

    return true;
  }

  /**
   * Keeps prompting the user for a valid input until they enter a valid
   * chess move, then returns it
   *
   * @return       the valid chess move, composed in an array where the first
   *               ChessSquare is the origin and the second is the destination
   */
  static ChessSquare[] getValidUserInput() {
    Scanner s = new Scanner(System.in);
    ChessSquare orig = null;
    ChessSquare dest = null;
    boolean inputCorrectlyFormatted = false;
    boolean allowableChessMove = false;
    String input = "";

    while (!inputCorrectlyFormatted || !allowableChessMove) {
      System.out.println( "Enter a move player " + (currPlayer+1) + " (ex \"C2, C3\")" );
      input = s.nextLine();
      inputCorrectlyFormatted = isCorrectlyFormatted(input);

      if (inputCorrectlyFormatted) {
        String origLocation = input.substring(0,2); // Based on input "C2, C4"
        String destLocation = input.substring(4,6);
        orig = board.getSquareByLocation(origLocation);
        dest = board.getSquareByLocation(destLocation);
        allowableChessMove = allowableChessMove(orig, dest);
      }
    }

    s.close();
    ChessSquare[] move = {orig, dest};
    return move;
  }

}
