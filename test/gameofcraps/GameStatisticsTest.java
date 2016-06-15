package gameofcraps;

import static org.junit.Assert.*;

import org.junit.Rule;

import static org.hamcrest.number.IsCloseTo.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GameStatisticsTest {

	private final double TOLERANCE = 1e-6;
	private int gamesPlayed = 100;
	private int gamesWon = 50;
	private int totalRolls = 500;
	private int winsOnComingOutRoll = 10;
	private int lossesOnComingOutRoll = 10;

	private GameStatistics statistics = new GameStatistics(gamesPlayed, gamesWon, 0, totalRolls, winsOnComingOutRoll,
			lossesOnComingOutRoll);

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void probabilityOfWinning() {
		double probabilityOfWinning = statistics.probabilityOfWinning();

		assertThat(probabilityOfWinning, closeTo(0.5, TOLERANCE));
	}

	@Test
	public void averageOfRollsPerGame() {
		double averageOfRollsPerGame = statistics.averageOfRollsPerGame();

		assertThat(averageOfRollsPerGame, closeTo(5.0, TOLERANCE));
	}

	@Test
	public void probabilityOfWinningOnComingOutRoll() {
		double probabilityOfWinningOnComingOutRoll = statistics.probabilityOfWinningOnComingOutRoll();

		assertThat(probabilityOfWinningOnComingOutRoll, closeTo(0.1, TOLERANCE));
	}

	@Test
	public void probabilityOfLosingOnComingOutRoll() {
		double probabilityOfLosingOnComingOutRoll = statistics.probabilityOfLosingOnComingOutRoll();

		assertThat(probabilityOfLosingOnComingOutRoll, closeTo(0.1, TOLERANCE));
	}

	@Test
	public void exceptionOccursWhenGamesPlayedIsLessThanOne() {
		thrown.expect(InvalidGameMetricsException.class);
		thrown.expectMessage(equalTo("Number of games played must be greater than zero"));

		GameStatistics statistics = new GameStatistics(0, 0, 0, 0, 0, 0);
	}
}
