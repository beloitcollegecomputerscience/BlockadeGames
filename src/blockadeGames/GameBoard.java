package blockadeGames;

/**
 * This is Darrah's future graph class
 * @author jerry
 *
 */

public class GameBoard {
	public static boolean areThesePositionsConnected( int vertex1 , int vertex2 ) {
		if((vertex1 == 1) && (vertex2 == 3 || vertex2 == 5)) {
			return true;
		}
		else if ((vertex1 == 2) && (vertex2 == 3 || vertex2 == 4 )) {
			return true;
		}
		else if ((vertex1 == 3) && (vertex2 == 1 || vertex2 == 2 || vertex2 == 4 || vertex2 == 5)) {
			return true;
		}
		else if ((vertex1 == 4) && (vertex2 == 2 || vertex2 == 3 || vertex2 == 5)) {
			return true;
		}
		else if ((vertex1 == 5) && (vertex2 == 1 || vertex2 == 3 || vertex2 == 4 )) {
			return true;
		}
		else {
			return false;
		}
	}
}