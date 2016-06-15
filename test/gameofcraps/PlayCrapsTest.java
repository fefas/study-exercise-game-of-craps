package gameofcraps;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;

public class PlayCrapsTest {

	@Test
	@Ignore("Depends on GameStatistics implementation")
	public void playingCrapsGeneratesGameStatistics() {
		final int numGames = 1;
		PlayCraps playing = new PlayCraps();

		GameStatistics statistics = playing.play(numGames);

		assertEquals(numGames, statistics.gamesPlayed);
		assertTrue(statistics.gamesWon <= numGames);
	}

}
