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
		int numGamesToPlay;

		System.out.println("Welcome to Craps!");
		System.out.println("Enter number of games: ");
		numGamesToPlay = Integer.parseInt(args[0]);

		PlayCraps playCraps = new PlayCraps();
		GameStatistics statistics = playCraps.play(numGamesToPlay);

		System.out.println("Number of games played: " + statistics.gamesPlayed);
		System.out.println("Number of wins: " + statistics.gamesWon);
		System.out.println("Length of the longest game played: " + statistics.maximalGameLength);
		System.out.format("Estimated probability of winning: %.4f\n", statistics.probabilityOfWinning());
		System.out.println("Total number of rolls: " + statistics.totalRolls);
		System.out.format("Average number of rolls per game: %.4f\n", statistics.averageOfRollsPerGame());
		System.out.println("Number of wins on coming out roll: " + statistics.winsOnComingOutRoll);
		System.out.format("Estimated probability of winning on coming out roll: %.4f\n",
				statistics.probabilityOfWinningOnComingOutRoll());
		System.out.println("Number of losses on coming out roll: " + statistics.lossesOnComingOutRoll);
		System.out.format("Estimated probability of losing on coming out roll: %.4f\n",
				statistics.probabilityOfLosingOnComingOutRoll());
	}

	public GameStatistics play(int numGamesToPlay) {
		CrapsGame game = new CrapsGame(dice);
		int gamesWon = 0;
		int maximalGameLength = 0;
		int totalRolls = 0;
		int winsOnComingOutRoll = 0;
		int lossesOnComingOutRoll = 0;

		for (int numGamesPlayed = 0; numGamesPlayed < numGamesToPlay; numGamesPlayed++) {
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

			game.reset();
		}

		return new GameStatistics(numGamesToPlay, gamesWon, maximalGameLength, totalRolls, winsOnComingOutRoll,
				lossesOnComingOutRoll);
	}
}
