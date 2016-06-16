package gameofcraps;

import static org.junit.Assert.*;

import static org.hamcrest.number.IsCloseTo.*;

import org.junit.Test;

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
}
