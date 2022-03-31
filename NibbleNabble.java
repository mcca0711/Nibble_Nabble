package connect4;

import java.util.Scanner;
import java.util.Random;

/**
 * This class implements a simple version of Connect Four, called NibbleNabble.
 * 
 * @author Matt
 * @version 1.0
 * @since 1.8
 */
public class NibbleNabble {

	private Player currentPlayer;
	private Player computer;
	private Player user;
	private Board board;
	private Scanner input;

	/**
	 * Outputs a welcome message. Prompts the user for their name, and
	 * instantiates a new Player with the name. Initializes the Scanner, Board,
	 * user and computer variables.
	 */
	public NibbleNabble() {
		input = new Scanner(System.in);
		System.out.println("Welcome to NibbleNabble");
		System.out.print("Please enter your name: ");
		user = new Player(input.next());
		computer = new Player();
		board = new Board();
	}

	public boolean playGame() {

		while (true) {
			board.display();
			int column = 0;
			currentPlayer = togglePlayer();

			System.out.print(currentPlayer.getName() + " > ");

			while (column == 0) {
				if (currentPlayer == computer) {
					column = new Random().nextInt(7) + 1;
					System.out.println(column);
				} else {
					String move = input.next();
					if (move.toUpperCase().charAt(0) == 'Q')
						return false;

					column = Integer.parseInt(move);
				}

				board.makeMove(column, currentPlayer.getToken());
			}

			if (currentPlayer == user
					&& (board.checkNibbleXVictory() || board.isFull())) {
				System.out.println(user.getName() + " wins!!!");
				board.display();
				break;
			} else if (currentPlayer == computer && board.checkVictory()) {
				System.out.println("Computer wins!");
				board.display();
				break;
			}
		}

		return true;
	}

	/**
	 * Re-initializes the board variable with a new Board object. Outputs prompt
	 * to user: Enter Q to quit, or any key to keep playing: If the user enters
	 * any variation of Q, q, Quit, quit, quits the game.
	 * 
	 * @return True if the user wants to quit, false otherwise.
	 */
	public boolean quit() {
		System.out.println("Enter Q to quit, or any key to keep playing:");
		String value = input.next();
		if (value.equalsIgnoreCase("q") || value.equalsIgnoreCase("Quit")
				|| value.equalsIgnoreCase("quit")
				|| value.equalsIgnoreCase("quits")) {
			return true;
		} else {
			board = new Board();
			return false;
		}
	}

	/**
	 * If the currentPlayer is the user, returns computer. Otherwise, returns
	 * the user.
	 * 
	 * @return computer if currentPlayer is user, otherwise user.
	 */
	private Player togglePlayer() {
		if (currentPlayer == user)
			return computer;
		else
			return user;
	}
}
