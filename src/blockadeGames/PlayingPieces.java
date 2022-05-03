package blockadeGames;

public class PlayingPieces {
	public static int[] boardPosition = {0, 0, -1, 1, 1}; //which piece is black which piece are white

	/**
	 * It checks whether a piece belongs to the current player or not.
	 * @param position the position of the piece
	 * @return returns true if the piece returns to the current player, else returns false.
	 */
	private static boolean isBelongTo(int position) {
		return (boardPosition[position] == PlayerTurn.getCurrentPlayer());
	}
	
	private static String boardToString() {
		String board = "";
		board += boardPosition[0] + "   " + boardPosition[1] + "\n";
		board += "|\\ /|\n";
		board += "| " + boardPosition[2] + "|\n";
		board += "|/ \\|\n";
		board += boardPosition[3] + "==" + boardPosition[4] + "\n";
		return board;
	}

	public static void main(String [] args) {
		System.out.print(boardToString());
	}
}
