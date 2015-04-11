package lesson7.maximumslice;

import static org.junit.Assert.*;

import org.junit.Test;

/*Let’s define a problem relating to maximum slices. You are given a sequence of n integers
 a0, a1, . . . , an−1 and the task is to find the slice with the largest sum. More precisely, we are
 looking for two indices p, q such that the total ap + ap+1 + . . . + aq is maximal. We assume
 that the slice can be empty and its sum equals 0.

 -----------
 a0 a1 a2 a3 a4 a5 a6
 5  -7  3  5 -2  4 -1

 In the picture, the slice with the largest sum is highlighted in gray. The sum of this slice
 equals 10 and there is no slice with a larger sum. Notice that the slice we are looking for may
 contain negative integers, as shown above.*/

public class IntroExercise {

	public int goldenMaxSlice(int[] A) {
		int maxEnding = 0;
		int maxSlice = 0;

		for (int elem : A) {
			maxEnding = Math.max(0, maxEnding + elem);
			maxSlice = Math.max(maxSlice, maxEnding);
		}
		return maxSlice;
	}

	@Test
	public void introExerciseTest() {
		int[] arr = { 5, -7, 3, 5, -2, 4, -1 };
		IntroExercise exer = new IntroExercise();
		assertEquals(10, exer.goldenMaxSlice(arr));
	}

}
