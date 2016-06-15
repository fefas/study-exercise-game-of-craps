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
		if (gamesPlayed < 1) {
			throw new InvalidGameMetricsException("Number of games played must be greater than zero");
		}
		if (gamesWon > gamesPlayed) {
			throw new InvalidGameMetricsException("Number of games won must be less than or equal to games played");
		}
		if (gamesWon < 0) {
			throw new InvalidGameMetricsException("Number of games won must be greater than or equal to zero");
		}
		if (maximalGameLength < 1) {
			throw new InvalidGameMetricsException("The maximal game length must be greater than or equal to one");
		}
		if (totalRolls < gamesPlayed) {
			throw new InvalidGameMetricsException("The total rolls must be greater than or equal to games played");
		}
		if (winsOnComingOutRoll < 0) {
			throw new InvalidGameMetricsException(
					"Number of wins on coming out roll must be greater than or equal to zero");
		}
		if (winsOnComingOutRoll > gamesWon) {
			throw new InvalidGameMetricsException(
					"Number of wins on coming out roll must be less than or equal to games won");
		}
		if (lossesOnComingOutRoll < 0) {
			throw new InvalidGameMetricsException(
					"Number of losses on coming out roll must be greater than or equal to zero");
		}
		if (lossesOnComingOutRoll > (gamesPlayed - gamesWon)) {
			throw new InvalidGameMetricsException(
					"Number of losses on coming out roll must be less than or equal to games lost");
		}

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

	public double averageOfRollsPerGame() {
		return totalRolls / (double) gamesPlayed;
	}

	public double probabilityOfWinningOnComingOutRoll() {
		return winsOnComingOutRoll / (double) gamesPlayed;
	}

	public double probabilityOfLosingOnComingOutRoll() {
		return lossesOnComingOutRoll / (double) gamesPlayed;
	}
}
