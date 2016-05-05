package gameofcraps;

public class CrapsGame {
	private Dice pairOfDice;
	private boolean win;
	private int numRolls;

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
	}

	public void play() {
		this.pairOfDice.roll();
		this.numRolls++;
		int sumOfFaces = this.pairOfDice.getSumOfFaces();

		if (7 == sumOfFaces || 11 == sumOfFaces) {
			this.win = true;
		}
	}

	public boolean getWin() {
		return this.win;
	}

	public int getNumRolls() {
		return this.numRolls;
	}
}
