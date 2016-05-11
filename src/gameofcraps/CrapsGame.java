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
		this.pairOfDice = dice;
		this.reset();
	}

	public void reset() {
		this.win = false;
		this.numRolls = 0;
		finished = false;
	}

	public void play() {
		this.pairOfDice.roll();
		this.numRolls++;
		int sumOfFaces = this.pairOfDice.getSumOfFaces();

		if (7 == sumOfFaces || 11 == sumOfFaces) {
			this.win = true;
			finished = true;
		}
	}

	public boolean getWin() {
		return this.win;
	}

	public int getNumRolls() {
		return this.numRolls;
	}

	public boolean hasFinished() {
		return finished;
	}
}
