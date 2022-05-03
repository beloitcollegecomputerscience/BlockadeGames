package blockadeGames;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Jerry Ngo
 *
 */

class PlayerTurnTest {

	@Test
	void updatePlayer() {
		assertEquals(PlayerTurn.getCurrentPlayer(), 0);
		PlayerTurn.updatePlayer();
		assertEquals(PlayerTurn.getCurrentPlayer(), 1);
		PlayerTurn.updatePlayer();
		assertEquals(PlayerTurn.getCurrentPlayer(), 0);
	}

}
