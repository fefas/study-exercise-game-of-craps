package gameofcraps;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CrapsGameMultiRollWinningTest {

	@Parameters
	public static Collection<SequencedDice> winningDiceSequences() {
		return Arrays.asList(
				new SequencedDice(4, 4),
				new SequencedDice(4, 5, 4),
				new SequencedDice(4, 5, 6, 4),
				new SequencedDice(4, 5, 6, 8, 4),
				new SequencedDice(10, 10),
				new SequencedDice(10, 9, 10),
				new SequencedDice(10, 9, 5, 10),
				new SequencedDice(10, 9, 5, 9, 10),

				// Snake eyes, 3 and box cars are special dice in the coming out roll
				new SequencedDice(4, 2, 4),
				new SequencedDice(4, 3, 4),
				new SequencedDice(4, 12, 4),

				// Exhaustive, but lucky boy!
				new SequencedDice(4, 5, 6, 8, 9, 10, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 4)
		);
	}

	private SequencedDice dice;

	public CrapsGameMultiRollWinningTest(SequencedDice dice) {
		this.dice = dice;
	}

	@Test
	public void winsIfNthRollIsEqualToComingOutRoll() {
		CrapsGame game = new CrapsGame(dice);

		game.play();

		assertTrue(game.hasFinished());
		assertTrue(game.getWin());
		assertEquals(dice.size(), game.getNumRolls());
	}
}
