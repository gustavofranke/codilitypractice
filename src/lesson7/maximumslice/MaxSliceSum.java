package lesson7.maximumslice;

import static org.junit.Assert.*;

import org.junit.Test;

/*A non-empty zero-indexed array A consisting of N integers is given. 
 * A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. 
 * The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].

 Write a function:

 class Solution { public int solution(int[] A); }

 that, given an array A consisting of N integers, returns the maximum sum of any slice of A.

 For example, given array A such that:

 A[0] = 3  A[1] = 2  A[2] = -6
 A[3] = 4  A[4] = 0
 the function should return 5 because:

 (3, 4) is a slice of A that has sum 4,
 (2, 2) is a slice of A that has sum −6,
 (0, 1) is a slice of A that has sum 5,
 no other slice of A has sum greater than (0, 1).
 Assume that:

 N is an integer within the range [1..1,000,000];
 each element of array A is an integer within the range [−1,000,000..1,000,000];
 the result will be an integer within the range [−2,147,483,648..2,147,483,647].
 Complexity:

 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 Elements of input arrays can be modified.*/
public class MaxSliceSum {
	public int solution(int[] A) {
		int ans = A[0], sum = 0;
		for (int i = 0; i < A.length; i++) {
			if (sum > 0) {
				sum += A[i];
			} else {
				sum = A[i];
			}
			ans = Math.max(ans, sum);
		}
		return ans;
	}

	public int solution1(int[] A) {
		int maxSlice = 0;
		int maxProcessed = 0;

		for (int elem : A) {
			maxProcessed = Math.max(0, maxProcessed + elem);
			maxSlice = Math.max(maxSlice, maxProcessed);
		}
		return maxSlice;
	}

	@Test
	public void introExerciseTest() {
		MaxSliceSum ss = new MaxSliceSum();
		int[] arr = { 3, 2, -6, 4, 0 };
		int[] arr1 = { 3 };

		assertEquals(5, ss.solution1(arr));
		assertEquals(3, ss.solution(arr1));
	}

}
