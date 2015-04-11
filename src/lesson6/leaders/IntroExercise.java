package lesson6.leaders;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;

public class IntroExercise {

	public int fastLeader(int[] A) {
		int n = A.length;
		int leader = -1;
		Arrays.sort(A);
		int candidate = A[n / 2];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (A[i] == candidate) {
				count += 1;
			}
		}
		if (count > n / 2) {
			leader = candidate;
		}
		return leader;
	}

	public int goldenLeader(int[] A) {
		int n = A.length;
		int size = 0;
		int value = 0;
		int candidate;
		int leader;
		int count;

		for (int k = 0; k < n; k++) {
			if (size == 0) {
				size += 1;
				value = A[k];
			} else {
				if (value != A[k]) {
					size -= 1;
				} else {
					size += 1;
				}
			}
		}
		candidate = -1;
		if (size > 0) {
			candidate = value;
		}
		leader = -1;
		count = 0;
		for (int k = 0; k < n; k++) {
			if (A[k] == candidate) {
				count += 1;
			}
		}
		if (count > n / 2) {
			leader = candidate;
		}
		return leader;
	}

	@Test
	public void introExerciseTest() {
		int[] arr = { 6, 8, 4, 6, 8, 6, 6 };
		IntroExercise ie = new IntroExercise();
		assertEquals(6, ie.goldenLeader(arr));
		assertEquals(6, ie.fastLeader(arr));
	}

}
