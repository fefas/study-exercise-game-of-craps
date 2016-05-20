package gameofcraps;

import java.util.Arrays;
import java.util.List;

class SequencedDice extends Dice {
	private final List<Integer> sequencedResults;
	private int position;

	public SequencedDice(Integer... results) {
		sequencedResults = Arrays.asList(results);
		position = 0;
	}

	public int getSumOfFaces() {
		return sequencedResults.get(position++);
	}

	public int size() {
		return sequencedResults.size();
	}
}
