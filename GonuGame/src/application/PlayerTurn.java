package application;

/**
 * Keep track of the current player turn and store players' name
 * @author jerry
 *
 */

public class PlayerTurn {
	public static String player1_name = "Player 1";
	public static String player2_name = "Player 2";
	public static int currentPlayer = 0;
	
	/**
	 * It returns the integral form of current player name.
	 * @return returns the integral form of current player name.
	 */
	public static int getCurrentPlayer() {
		return currentPlayer;
	}
	
	/**
	 * It returns a string of the current player name.
	 * @return returns a string of the current player name.
	 */
	public static String getCurrentPlayerName() {
		return (currentPlayer == 0) ? player1_name : player2_name;
	}
	
	/**
	 * Update the current player.
	 */
	public static void updatePlayer() {
		currentPlayer ^= 1;
	}
	
	/**
	 * Set the player1's name.
	 * @param name the player1's name
	 */
	public static void setPlayer1(String name) {
		player1_name = name;
	}
	
	/**
	 * Set the player2's name.
	 * @param name the player2's name
	 */
	public static void setPlayer2(String name) {
		player2_name = name;
	}
}
