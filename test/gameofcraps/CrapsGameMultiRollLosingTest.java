package gameofcraps;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CrapsGameMultiRollLosingTest {

	@Parameters
	public static Collection<SequencedDice> losingDiceSequences() {
		return Arrays.asList(
				new SequencedDice(4, 7),
				new SequencedDice(4, 5, 7),
				new SequencedDice(4, 5, 6, 7),
				new SequencedDice(4, 5, 6, 8, 7),
				new SequencedDice(4, 5, 6, 8, 9, 7),
				new SequencedDice(4, 5, 6, 8, 9, 10, 7),
				new SequencedDice(10, 7),
				new SequencedDice(10, 9, 7),
				new SequencedDice(10, 9, 5, 7),
				new SequencedDice(10, 9, 5, 9, 7),

				// Snake eyes, 3 and box cars are special dice in the coming out roll
				new SequencedDice(5, 2, 7),
				new SequencedDice(5, 3, 7),
				new SequencedDice(5, 12, 7),

				// Exhaustive, but almost lucky boy!
				new SequencedDice(4, 5, 6, 8, 9, 10, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 7)
		);
	}

	private SequencedDice dice;

	public CrapsGameMultiRollLosingTest(SequencedDice dice) {
		this.dice = dice;
	}

	@Test
	public void losesIfNthRollIsSeven() {
		CrapsGame game = new CrapsGame(dice);

		game.play();

		assertTrue(game.hasFinished());
		assertFalse(game.getWin());
		assertEquals(dice.size(), game.getNumRolls());
	}
}
