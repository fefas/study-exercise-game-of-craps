package gameofcraps;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class GameStatisticsPreconditionsTest {
	// These valid values are consistent among themselves
	private static final int VALID_GAMES_PLAYED = 5;
	private static final int VALID_GAMES_WON = 3;
	private static final int VALID_MAXIMAL_GAME_LENGTH = 1;
	private static final int VALID_TOTAL_ROLLS = 5;
	private static final int VALID_WINS_ON_COMING_OUT_ROLL = 2;
	private static final int VALID_LOSSES_ON_COMING_OUT_ROLL = 1;

	private static final int INVALID_GAMES_PLAYED = -1;
	private static final int INVALID_GAMES_WON = -1;
	private static final int INVALID_MAXIMAL_GAME_LENGTH = 0;
	private static final int INVALID_WINS_ON_COMING_OUT_ROLL = -1;
	private static final int INVALID_LOSSES_ON_COMING_OUT_ROLL = -1;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void exceptionOccursWhenGamesPlayedIsLessThanOne() {
		thrown.expect(InvalidGameMetricsException.class);
		thrown.expectMessage(equalTo("Number of games played must be greater than zero"));

		new GameStatistics(INVALID_GAMES_PLAYED, VALID_GAMES_WON, VALID_MAXIMAL_GAME_LENGTH, VALID_TOTAL_ROLLS,
				VALID_WINS_ON_COMING_OUT_ROLL, VALID_LOSSES_ON_COMING_OUT_ROLL);
	}

	@Test
	public void exceptionOccursWhenGamesWonIsGreaterThanGamesPlayed() {
		thrown.expect(InvalidGameMetricsException.class);
		thrown.expectMessage(equalTo("Number of games won must be less than or equal to games played"));

		int inconsistentGamesWon = VALID_GAMES_PLAYED + 5;

		new GameStatistics(VALID_GAMES_PLAYED, inconsistentGamesWon, VALID_MAXIMAL_GAME_LENGTH, VALID_TOTAL_ROLLS,
				VALID_WINS_ON_COMING_OUT_ROLL, VALID_LOSSES_ON_COMING_OUT_ROLL);
	}

	@Test
	public void exceptionOccursWhenGamesWonIsLessThanZero() {
		thrown.expect(InvalidGameMetricsException.class);
		thrown.expectMessage(equalTo("Number of games won must be greater than or equal to zero"));

		new GameStatistics(VALID_GAMES_PLAYED, INVALID_GAMES_WON, VALID_MAXIMAL_GAME_LENGTH, VALID_TOTAL_ROLLS,
				VALID_WINS_ON_COMING_OUT_ROLL, VALID_LOSSES_ON_COMING_OUT_ROLL);
	}

	@Test
	public void exceptionOccursWhenMaximalGameLengthIsLessThanOne() {
		thrown.expect(InvalidGameMetricsException.class);
		thrown.expectMessage("The maximal game length must be greater than or equal to one");

		new GameStatistics(VALID_GAMES_PLAYED, VALID_GAMES_WON, INVALID_MAXIMAL_GAME_LENGTH, VALID_TOTAL_ROLLS,
				VALID_WINS_ON_COMING_OUT_ROLL, VALID_LOSSES_ON_COMING_OUT_ROLL);
	}

	@Test
	public void exceptionOccursWhenTotalRollsIsLessThanGamesPlayed() {
		thrown.expect(InvalidGameMetricsException.class);
		thrown.expectMessage("The total rolls must be greater than or equal to games played");

		int inconsistentTotalRolls = VALID_GAMES_PLAYED - 1;

		new GameStatistics(VALID_GAMES_PLAYED, VALID_GAMES_WON, VALID_MAXIMAL_GAME_LENGTH, inconsistentTotalRolls,
				VALID_WINS_ON_COMING_OUT_ROLL, VALID_LOSSES_ON_COMING_OUT_ROLL);
	}

	@Test
	public void exceptionOccursWhenWinsOnComingOutRollIsLessThanZero() {
		thrown.expect(InvalidGameMetricsException.class);
		thrown.expectMessage("Number of wins on coming out roll must be greater than or equal to zero");

		new GameStatistics(VALID_GAMES_PLAYED, VALID_GAMES_WON, VALID_MAXIMAL_GAME_LENGTH, VALID_TOTAL_ROLLS,
				INVALID_WINS_ON_COMING_OUT_ROLL, VALID_LOSSES_ON_COMING_OUT_ROLL);
	}

	@Test
	public void exceptionOccursWhenWinsOnComingOutRollIsGreaterThanGamesWon() {
		thrown.expect(InvalidGameMetricsException.class);
		thrown.expectMessage("Number of wins on coming out roll must be less than or equal to games won");

		int inconsistentWinsOnComingOutRoll = VALID_GAMES_WON + 1;

		new GameStatistics(VALID_GAMES_PLAYED, VALID_GAMES_WON, VALID_MAXIMAL_GAME_LENGTH, VALID_TOTAL_ROLLS,
				inconsistentWinsOnComingOutRoll, VALID_LOSSES_ON_COMING_OUT_ROLL);
	}

	@Test
	public void exceptionOccursWhenLossesOnComingOutRollIsLessThanZero() {
		thrown.expect(InvalidGameMetricsException.class);
		thrown.expectMessage("Number of losses on coming out roll must be greater than or equal to zero");

		new GameStatistics(VALID_GAMES_PLAYED, VALID_GAMES_WON, VALID_MAXIMAL_GAME_LENGTH, VALID_TOTAL_ROLLS,
				VALID_WINS_ON_COMING_OUT_ROLL, INVALID_LOSSES_ON_COMING_OUT_ROLL);
	}

	@Test
	public void exceptionOccursWhenLossesOnComingOutRollIsGreaterThanGamesLost() {
		thrown.expect(InvalidGameMetricsException.class);
		thrown.expectMessage("Number of losses on coming out roll must be less than or equal to games lost");

		int inconsistentLossesOnComingOutRoll = (VALID_GAMES_PLAYED - VALID_GAMES_WON) + 1;

		new GameStatistics(VALID_GAMES_PLAYED, VALID_GAMES_WON, VALID_MAXIMAL_GAME_LENGTH, VALID_TOTAL_ROLLS,
				VALID_WINS_ON_COMING_OUT_ROLL, inconsistentLossesOnComingOutRoll);
	}
}
