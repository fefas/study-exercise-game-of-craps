package gameofcraps;

public class GameStatistics {

	public final int gamesPlayed;
	public final int gamesWon;
	public final int maximalGameLength;
	public final int totalRolls;
	public final int winsOnComingOutRoll;
	public final int lossesOnComingOutRoll;

	public GameStatistics(int gamesPlayed, int gamesWon, int maximalGameLength, int totalRolls, int winsOnComingOutRoll,
			int lossesOnComingOutRoll) {
		this.gamesPlayed = gamesPlayed;
		this.gamesWon = gamesWon;
		this.maximalGameLength = maximalGameLength;
		this.totalRolls = totalRolls;
		this.winsOnComingOutRoll = winsOnComingOutRoll;
		this.lossesOnComingOutRoll = lossesOnComingOutRoll;
	}

	public double probabilityOfWinning() {
		return gamesWon / (double) gamesPlayed;
	}

	public double avarageOfRollsPerGame() {
		return totalRolls / (double) gamesPlayed;
	}

	public double probabilityOfWinningOnComingOutRoll() {
		return winsOnComingOutRoll / (double) gamesPlayed;
	}

	public double probabilityOfLosingOnComingOutRoll() {
		return lossesOnComingOutRoll / (double) gamesPlayed;
	}
}
