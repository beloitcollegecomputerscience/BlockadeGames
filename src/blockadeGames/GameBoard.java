package blockadeGames;

/**
 * The GameBoard class understands the board layout
 * and show whether two positions are connected by an edge/line. 
 * @author YuJiang Pu and Jerry Ngo
 */

public class GameBoard {
	public static boolean areThesePositionsConnected( int vertex1 , int vertex2 ) {
		if((vertex1 == 0) && (vertex2 == 2 || vertex2 == 4)) {
			return true;
		}
		else if ((vertex1 == 1) && (vertex2 == 2 || vertex2 == 3)) {
			return true;
		}
		else if ((vertex1 == 2) && (vertex2 == 0 || vertex2 == 1 || vertex2 == 3 || vertex2 == 4)) {
			return true;
		}
		else if ((vertex1 == 3) && (vertex2 == 1 || vertex2 == 2 || vertex2 == 4)) {
			return true;
		}
		else if ((vertex1 == 4) && (vertex2 == 0 || vertex2 == 2 || vertex2 == 3)) {
			return true;
		}
		else return false;
	}
}