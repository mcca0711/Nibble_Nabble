package connect4;

/**
 * This class kicks off the game NibbleNabble, and continues playing until the
 * user quits.
 * 
 * @author Matt
 * @version 1.0
 * @since 1.8
 * 
 */
public class Main {

	/**
	 * The main method declares a new instance of the game NibbleNabble. Execute
	 * the playGame method while the quit method continues to return false. If
	 * the playGame method returns false, exit the loop.
	 * 
	 * @param args
	 *            UNUSED
	 */
	public static void main(String[] args) {
		NibbleNabble instance = new NibbleNabble();
		do {
			instance.playGame();
		} while (!instance.quit());
	}

}