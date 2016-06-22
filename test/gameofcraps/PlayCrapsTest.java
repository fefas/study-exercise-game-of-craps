package gameofcraps;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PlayCrapsTest {

	@Parameters
	public static Collection<Object[]> diceAndExpectedStatistics() {
		return Arrays.asList(new Object[][] {
			{
				new SequencedDice(4, 5, 7),
				new GameStatistics(1, 0, 3, 3, 0, 0)
			},
			{
				new SequencedDice(4, 5, 4),
				new GameStatistics(1, 1, 3, 3, 0, 0)
			},
			{
				new SequencedDice(11),
				new GameStatistics(1, 1, 1, 1, 1, 0)
			},
			{
				new SequencedDice(2),
				new GameStatistics(1, 0, 1, 1, 0, 1)
			}
		});
	}

	private Dice dice;
	private GameStatistics expectedStatistics;

	public PlayCrapsTest(Dice dice, GameStatistics expectedStatistics) {
		this.dice = dice;
		this.expectedStatistics = expectedStatistics;
	}

	@Test
	public void statisticsAreCorrectWhenSingleGameLost() {
		final int numGamesToPlay = expectedStatistics.gamesPlayed;
		PlayCraps playing = new PlayCraps(dice);

		GameStatistics statistics = playing.play(numGamesToPlay);

		assertEquals(expectedStatistics.gamesPlayed, statistics.gamesPlayed);
		assertEquals(expectedStatistics.gamesWon, statistics.gamesWon);
		assertEquals(expectedStatistics.maximalGameLength, statistics.maximalGameLength);
		assertEquals(expectedStatistics.totalRolls, statistics.totalRolls);
		assertEquals(expectedStatistics.winsOnComingOutRoll, statistics.winsOnComingOutRoll);
		assertEquals(expectedStatistics.lossesOnComingOutRoll, statistics.lossesOnComingOutRoll);
	}
}
