package connect4;

/**
 * This class simulates a NibbleNabble game board.
 * 
 * @author Matt
 * @version 1.0
 * @since 1.8
 * 
 */
public class Board {

	/** Number of rows on the board */
	private final static int NUM_ROWS = 6;

	/** Number of columns on the board */
	private final static int NUM_COLS = 7;

	/** Array of Column objects, which contain token values */
	private Column[] board = new Column[NUM_COLS];

	/**
	 * Loop through the board array, to instantiate and initialize each element
	 * as a new Column.
	 */
	public Board() {
		for (int i = 0; i < NUM_COLS; i++) {
			board[i] = new Column();
		}
	}

	/**
	 * Validate the column number, output an error message and return false if
	 * its invalid. Try to put the token in the specified column of the board.
	 * Output an error message and return false if it does not work.
	 * 
	 * @param column
	 *            The column in which to place the token, valid values are 1 -
	 *            7.
	 * @param token
	 *            Token character to place on the board, an X or an O.
	 * @return True if putting the token on the column is successful, else
	 *         false.
	 */
	public boolean makeMove(int column, char token) {
		if (column < 1 || column > NUM_COLS) {
			System.out.println("Invalid Input");
			return false;
		}
		board[column - 1].put(token);
		return true;
	}

	/**
	 * Checks for Computer's victory by looking for complete vertical and
	 * horizontal nibbles.
	 * 
	 * @return True if any nibbles of O's are found on the board, otherwise
	 *         false.
	 */
	public boolean checkVictory() {

		// Loop through each column to check for victory.
		for (int i = 0; i < NUM_COLS; i++) {
			if (board[i].checkVictory())
				return true;
		}
		// Loop through each row to look for horizontal nibbles
		for (int row = 0; row < NUM_ROWS; row++) {
			int result = 0;
			for (int i = 0; i < NUM_COLS; i++) {
				if (board[i].get(row) == 'O')
					result++;
				else
					result = 0;

				if (result == 4)
					return true;
			}
		}
		return false;
	}

	/**
	 * Checks for User's victory by looking for complete vertical and horizontal
	 * nibbles.
	 * 
	 * @return True if any nibbles of X's are found on the board, otherwise
	 *         false.
	 */
	public boolean checkNibbleXVictory() {

		// Loop through each column to check for victory.
		for (int i = 0; i < NUM_COLS; i++) {
			if (board[i].checkColumnXVictory())
				return true;
		}
		// Loop through each row to look for horizontal nibbles
		for (int row = 0; row < NUM_ROWS; row++) {
			int result = 0;
			for (int i = 0; i < NUM_COLS; i++) {
				if (board[i].get(row) == 'X')
					result++;
				else
					result = 0;

				if (result == 4)
					return true;
			}
		}
		return false;
	}

	/**
	 * Checks each column to see if there is room enough for at least 4 more O
	 * values. Checks final row to see if there is room enough for at least 4 O
	 * (non-X) values.
	 * 
	 * @return True if the computer has no more safe moves, else false.
	 */
	public boolean isFull() {

		for (int i = 0; i < NUM_COLS; i++) {
			if (board[i].get(NUM_ROWS) == ' ') {
				return false;
			}
		}
		return true;
	}

	/**
	 * Displays each column number, divided by spaces. Displays, in a grid, the
	 * contained in each column of each row. Displays the column numbers again
	 * at the bottom. Example:
	 * 
	 * 1 2 3 4 5 6 7 --------------- | | | | | | | | | | | | | | | | | | | | | |
	 * | | | | | | | | | | | |X| | | |O| | |O|O|X| |X|O| | --------------- 1 2 3
	 * 4 5 6 7
	 * 
	 * 
	 */
	public void display() {

		System.out.println(" 1 2 3 4 5 6 7");
		System.out.println("---------------");

		for (int i = NUM_ROWS; i > 0; i--) {
			for (int y = 0; y < NUM_COLS; y++) {
				if (board[y].get(i) == ' ') {
					if (y == NUM_COLS - 1)
						System.out.print("| |");
					else
						System.out.print("| ");
				} else {
					if (y == NUM_COLS - 1)
						System.out.print("|" + board[y].get(i) + "|");
					else
						System.out.print("|" + board[y].get(i));
				}
			}
			System.out.println();
		}

		System.out.println("---------------");
		System.out.println(" 1 2 3 4 5 6 7");
	}

}
