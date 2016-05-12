package gameofcraps;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CrapsGameTest {

	private class DeterministicDice extends Dice {
		private final int sumOfFaces;

		public DeterministicDice(int sumOfFaces) {
			this.sumOfFaces = sumOfFaces;
		}

		public int getSumOfFaces() {
			return sumOfFaces;
		}
	}

	private class SequencedDice extends Dice {
		private final List<Integer> sequencedResults;
		private int position;

		public SequencedDice(Integer... results) {
			sequencedResults = Arrays.asList(results);
			position = 0;
		}

		public int getSumOfFaces() {
			return sequencedResults.get(position++);
		}
	}

	@Test
	public void winsIfComingOutRollIsSeven() {
		CrapsGame game = new CrapsGame(new DeterministicDice(7));

		game.play();

		assertTrue(game.hasFinished());
		assertTrue(game.getWin());
		assertEquals(1, game.getNumRolls());
	}

	@Test
	public void winsIfComingOutRollIsEleven() {
		CrapsGame game = new CrapsGame(new DeterministicDice(11));

		game.play();

		assertTrue(game.hasFinished());
		assertTrue(game.getWin());
		assertEquals(1, game.getNumRolls());
	}

	@Test
	public void losesIfComingOutRollIsSnakeEyes() {
		CrapsGame game = new CrapsGame(new DeterministicDice(2));

		game.play();

		assertTrue(game.hasFinished());
		assertFalse(game.getWin());
		assertEquals(1, game.getNumRolls());
	}

	@Test
	public void losesIfComingOutRollIsThree() {
		CrapsGame game = new CrapsGame(new DeterministicDice(3));

		game.play();

		assertTrue(game.hasFinished());
		assertFalse(game.getWin());
		assertEquals(1, game.getNumRolls());
	}

	@Test
	public void losesIfComingOutRollIsBoxCars() {
		CrapsGame game = new CrapsGame(new DeterministicDice(12));

		game.play();

		assertTrue(game.hasFinished());
		assertFalse(game.getWin());
		assertEquals(1, game.getNumRolls());
	}

	@Test
	public void winsIfNthRollIsEqualToComingOutRoll() {
		CrapsGame game = new CrapsGame(new SequencedDice(4, 5, 4));

		game.play();

		assertTrue(game.hasFinished());
		assertTrue(game.getWin());
		assertEquals(3, game.getNumRolls());
	}
}
