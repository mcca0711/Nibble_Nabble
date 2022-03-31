package connect4;

/**
 * 
 * This class is a single Column on the board, containing vertically stacked X
 * and O tokens.
 * 
 * @author Matt
 * @version 1.0
 * @since 1.8
 * 
 */
public class Column {

	private static final int MAX_HEIGHT = 6;
	private int height = 0;
	private char[] column;

	/**
	 * Default constructor - initialize the column array and each element of the
	 * column array to contain a blank space.
	 */
	public Column() {
		column = new char[MAX_HEIGHT];
		for (int i = 0; i < MAX_HEIGHT; i++)
			column[i] = ' ';
	}

	/**
	 * Return the value in the specified row.
	 * 
	 * @param row
	 *            The specified row. Valid values are 1 - 6.
	 * @return The character in the specified row, or blank if an invalid row
	 *         was requested.
	 */
	public char get(int row) {
		if (row >= 1 && row <= 6)
			return column[row - 1];
		else
			return ' ';
	}

	/**
	 * Put the specified token character at the top of the column, increments
	 * the height, and returns true.
	 * 
	 * @param token
	 *            Token character to place on the board, an X or an O.
	 * @return True if there is room in the column for the token, else false.
	 */
	public boolean put(char token) {
		if (getHeight() != MAX_HEIGHT) {
			column[getHeight()] = token;
			height++;
			return true;
		} else
			return false;
	}

	/**
	 * Check if the column contains a Nibble.
	 * 
	 * @return True if the column contains 4 or more consecutive 'O' tokens,
	 *         else false.
	 */
	public boolean checkVictory() {
		int result = 0;
		for (int i = 0; i < MAX_HEIGHT; i++) {
			if (column[i] == 'O')
				result++;
			else
				result = 0;

			if (result == 4)
				return true;
		}
		return false;
	}

	/**
	 * Check if the column contains a Nabble.
	 * 
	 * @return True if the column contains 4 or more consecutive 'X' tokens,
	 *         else false.
	 */
	public boolean checkColumnXVictory() {
		int result = 0;
		for (int i = 0; i < MAX_HEIGHT; i++) {
			if (column[i] == 'X')
				result++;
			else
				result = 0;

			if (result == 4)
				return true;
		}
		return false;
	}

	/**
	 * Returns the current height of the Column.
	 * 
	 * @return the height of the column
	 */
	public int getHeight() {
		return height;
	}
}
