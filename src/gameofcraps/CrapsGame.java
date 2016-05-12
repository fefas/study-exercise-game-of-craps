package gameofcraps;

public class CrapsGame {
	private Dice pairOfDice;
	private boolean win;
	private int numRolls;
	private boolean finished;

	public CrapsGame() {
		this(new Dice());
	}

	public CrapsGame(Dice dice) {
		pairOfDice = dice;
		reset();
	}

	public void reset() {
		finished = false;
		win = false;
		numRolls = 0;
	}

	public void play() {
		pairOfDice.roll();
		numRolls++;
		int sumOfFaces = pairOfDice.getSumOfFaces();

		if (7 == sumOfFaces || 11 == sumOfFaces) {
			finished = true;
			win = true;
			return;
		}

		if (2 == sumOfFaces || 3 == sumOfFaces || 12 == sumOfFaces) {
			finished = true;
			win = false;
		}
	}

	public boolean getWin() {
		return win;
	}

	public int getNumRolls() {
		return numRolls;
	}

	public boolean hasFinished() {
		return finished;
	}
}
