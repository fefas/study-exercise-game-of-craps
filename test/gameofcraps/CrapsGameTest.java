package gameofcraps;

import static org.junit.Assert.*;

import org.junit.Test;

public class CrapsGameTest {

	private class DeterministicDice extends Dice {
		private final int sumOfFaces;

		public DeterministicDice(int sumOfFaces) {
			this.sumOfFaces = sumOfFaces;
		}

		public int getSumOfFaces() {
			return this.sumOfFaces;
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
	public void losesIfComingOutRollIsDifferentFromSevenOrEleven() {
		CrapsGame game = new CrapsGame(new DeterministicDice(2));

		game.play();

		assertFalse(game.getWin());
	}
}
