package gameofcraps;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class DiceTest {

	@Test
	public void sumOfFacesIsBetween2And12AfterRollingDice() {
		Dice dice = new Dice();
		int numberOfIterations = 10_000;

		for (int iteration = 0; iteration < numberOfIterations; iteration++) {
			dice.roll();
			assertThat(dice.getSumOfFaces(), both(greaterThan(1)).and(lessThan(13)));
		}
	}
}
