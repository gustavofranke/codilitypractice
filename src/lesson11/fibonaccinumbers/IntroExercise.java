package lesson11.fibonaccinumbers;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntroExercise {
	public int fibInefficient(int n) {
		if (n <= 1) {
			return n;
		}
		return fibInefficient(n - 1) + fibInefficient(n - 2);
	}

	public int fibDynamic(int n) {
		int[] fib = new int[n + 2];
		fib[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}

	@Test
	public void introExerciseTest() {
		IntroExercise ei = new IntroExercise();
		assertEquals(514229, ei.fibInefficient(29));
		assertEquals(514229, ei.fibDynamic(29));
	}

}
