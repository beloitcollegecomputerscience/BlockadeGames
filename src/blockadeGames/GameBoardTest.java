package blockadeGames;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Jerry Ngo
 *
 */

class GameBoardTest {

	@Test
	public void testConnection(){
		GameBoard gb = new GameBoard();
		assertEquals(gb.areThesePositionsConnected(0, 1), false);
		assertEquals(gb.areThesePositionsConnected(1, 2), true);
		assertEquals(gb.areThesePositionsConnected(3, 4), true);
		assertEquals(gb.areThesePositionsConnected(2, 4), true);
		assertEquals(gb.areThesePositionsConnected(0, 3), false);
		assertEquals(gb.areThesePositionsConnected(2, 1), true);
	}
}
