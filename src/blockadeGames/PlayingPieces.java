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
	
	
	/**
	 * It checks if it is legal to play a piece at the first move.
	 * @param position the position of the piece
	 * @return returns true if it is legal to play the piece at the first move, else returns false.
	 */
	private static boolean isLegalWithSpecialCase(int position) {
		if(step != 0) return true;
		int adjacentNode = 0;
		for(int i = 0; i < GAME_SIZE; ++i) {
			if(i == position) continue;
			if(GameBoard.areThesePositionsConnected(position, i)) {
				adjacentNode += 1;
			}
		}
		return (adjacentNode > 2);
	}
	
	/**
	 * It checks if the current player won the game.
	 * @return returns true if the current player won the game, else returns false.
	 */
	public static boolean isWon() {
		int blankPosition = blankPosition();
		int playerBinary = PlayerTurn.getCurrentPlayer();
		boolean flag = false;
		for(int i = 0; i < GAME_SIZE; ++i) {
			if(playerBinary == boardPosition[i]) continue;
			flag |= (GameBoard.areThesePositionsConnected(i, blankPosition));
		}
		return (!flag);
	}
	
	public static void main(String [] args) {
		System.out.print(boardToString());
	}
}
