package gameofcraps;

import static org.junit.Assert.*;

import org.junit.Rule;

import static org.hamcrest.number.IsCloseTo.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GameStatisticsTest {
	private static final double TOLERANCE = 1e-6;
	private static final int GAMES_PLAYED = 100;
	private static final int GAMES_WON = 50;
	private static final int MAXIMAL_GAME_LENGTH = 10;
	private static final int TOTAL_ROLLS = 500;
	private static final int WINS_ON_COMING_OUT_ROLL = 10;
	private static final int LOSSES_ON_COMING_OUT_ROLL = 10;

	private GameStatistics statistics = new GameStatistics(GAMES_PLAYED, GAMES_WON, MAXIMAL_GAME_LENGTH, TOTAL_ROLLS,
			WINS_ON_COMING_OUT_ROLL, LOSSES_ON_COMING_OUT_ROLL);

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

	@Test
	public void exceptionOccursWhenGamesWonIsGreaterThanGamesPlayed() {
		thrown.expect(InvalidGameMetricsException.class);
		thrown.expectMessage(equalTo("Number of games won must be less than or equal to games played"));

		GameStatistics statistics = new GameStatistics(5, 10, 0, 0, 0, 0);
	}

	@Test
	public void exceptionOccursWhenGamesWonIsLessThanZero() {
		thrown.expect(InvalidGameMetricsException.class);
		thrown.expectMessage(equalTo("Number of games won must be greater than or equal to zero"));

		GameStatistics statistics = new GameStatistics(5, -1, 0, 0, 0, 0);
	}

	@Test
	public void exceptionOccursWhenMaximalGameLengthIsLessThanOne() {
		thrown.expect(InvalidGameMetricsException.class);
		thrown.expectMessage("The maximal game length must be greater than or equal to one");

		GameStatistics statistics = new GameStatistics(1, 0, 0, 0, 0, 0);
	}

	@Test
	public void exceptionOccursWhenTotalRollsIsLessThanGamesPlayed() {
		thrown.expect(InvalidGameMetricsException.class);
		thrown.expectMessage("The total rolls must be greater than or equal to games played");

		GameStatistics statistics = new GameStatistics(1, 0, 1, 0, 0, 0);
	}

	@Test
	public void exceptionOccursWhenWinsOnComingOutRollIsLessThanZero() {
		thrown.expect(InvalidGameMetricsException.class);
		thrown.expectMessage("Number of wins on coming out roll must be greater than or equal to zero");

		GameStatistics statistics = new GameStatistics(1, 0, 1, 1, -1, 0);
	}

	@Test
	public void exceptionOccursWhenWinsOnComingOutRollIsGreaterThanGamesWon() {
		thrown.expect(InvalidGameMetricsException.class);
		thrown.expectMessage("Number of wins on coming out roll must be less than or equal to games won");

		GameStatistics statistics = new GameStatistics(2, 1, 1, 2, 2, 0);
	}

	@Test
	public void exceptionOccursWhenLossesOnComingOutRollIsLessThanZero() {
		thrown.expect(InvalidGameMetricsException.class);
		thrown.expectMessage("Number of losses on coming out roll must be greater than or equal to zero");

		GameStatistics statistics = new GameStatistics(1, 0, 1, 1, 0, -1);
	}

	@Test
	public void exceptionOccursWhenLossesOnComingOutRollIsGreaterThanGamesLost() {
		thrown.expect(InvalidGameMetricsException.class);
		thrown.expectMessage("Number of losses on coming out roll must be less than or equal to games lost");

		GameStatistics statistics = new GameStatistics(2, 1, 1, 2, 0, 2);
	}
}
