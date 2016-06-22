package gameofcraps;

import java.util.Arrays;

public class PlayCraps {
	private Dice dice;

	public PlayCraps() {
		this(new Dice());
	}

	public PlayCraps(Dice dice) {
		this.dice = dice;
	}

	public static void main(String[] args) {
		CrapsGame game = new CrapsGame();
		int numGames;

		System.out.println("Welcome to Craps!");
		System.out.println("Enter number of games: ");
		numGames = Integer.parseInt(args[0]);
	}

	public GameStatistics play(int numGames) {
		CrapsGame game = new CrapsGame(dice);
		int gamesWon = 0;
		int maximalGameLength = 0;
		int totalRolls = 0;
		int winsOnComingOutRoll = 0;
		int lossesOnComingOutRoll = 0;

		game.play();

		if (game.getWin()) {
			gamesWon++;
			if (game.getNumRolls() == 1) {
				winsOnComingOutRoll++;
			}
		} else {
			if (game.getNumRolls() == 1) {
				lossesOnComingOutRoll++;
			}
		}

		totalRolls += game.getNumRolls();
		if (game.getNumRolls() > maximalGameLength) {
			maximalGameLength = game.getNumRolls();
		}

		return new GameStatistics(numGames, gamesWon, maximalGameLength, totalRolls, winsOnComingOutRoll,
				lossesOnComingOutRoll);
	}
}
