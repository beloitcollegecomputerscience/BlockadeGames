package blockadeGames;

public class PlayingPieces {
	public static final int GAME_SIZE = 5;
	private static int step = 0;
	public static int[] boardPosition = {0, 0, -1, 1, 1}; //which piece is black which piece are white
	
	private static String boardToString() {
		String board = "";
		board += boardPosition[0] + "   " + boardPosition[1] + "\n";
		board += "|\\ /|\n";
		board += "| " + boardPosition[2] + "|\n";
		board += "|/ \\|\n";
		board += boardPosition[3] + "==" + boardPosition[4] + "\n";
		return board;
	}
	
	/**
	 * It checks whether a piece belongs to the current player or not.
	 * @param position the position of the piece
	 * @return returns true if the piece returns to the current player, else returns false.
	 */
	private static boolean isBelongTo(int position) {
		return (boardPosition[position] == PlayerTurn.getCurrentPlayer());
	}
	
	/**
	 * It finds the position of the blank space
	 * @return returns the position of the blank space
	 */
	private static int blankPosition() {
		for(int i = 0; i < GAME_SIZE; ++i) {
			if(boardPosition[i] == -1) return i;
		}
		return -1;
	}
	
	/**
	 * It checks whether a piece is adjacent to the blank space or not.
	 * @param position the position of the piece
	 * @return returns true if the piece returns to the current player, else returns false.
	 */
	private static boolean adjacentToBlank(int position) {
		boolean flag = false;
		int blankPosition = blankPosition();
		for(int i = 0; i < GAME_SIZE; ++i) {
			if(i == blankPosition) continue;
			flag |= (GameBoard.areThesePositionsConnected(blankPosition, i) && (i == position));
		}
		return flag;
	}
	
	public static void main(String [] args) {
		System.out.print(boardToString());
	}
}
