package application;

public class PlayingPieces {
	public static int[] boardPosition = {0, 1}; //which piece is black which piece are white

	/**
	 * It checks whether a piece belongs to the current player or not.
	 * @param position the position of the piece
	 * @return returns true if the piece returns to the current player, else returns false.
	 */
	private static boolean isBelongTo(int position) {
		return (boardPosition[position] == PlayerTurn.getCurrentPlayer());
	}
}
