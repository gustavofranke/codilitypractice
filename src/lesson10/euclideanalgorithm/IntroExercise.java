package lesson10.euclideanalgorithm;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntroExercise {
	public int gcdBySubstraction(int a, int b) {
		if (a == b) {
			return a;
		}
		if (a > b) {
			return gcdBySubstraction(a - b, b);
		} else {
			return gcdBySubstraction(a, b - a);
		}
	}

	public int gcdByDivision(int a, int b) {
		if (a % b == 0) {
			return b;
		} else {
			return gcdByDivision(b, a % b);
		}
	}

	@Test
	public void introExerciseTest() {
		IntroExercise ie = new IntroExercise();

		assertEquals(3, ie.gcdBySubstraction(24, 9));
		assertEquals(3, ie.gcdByDivision(24, 9));

		assertEquals(1, ie.gcdBySubstraction(4, 3));
		assertEquals(1, ie.gcdByDivision(4, 3));
	}

}
