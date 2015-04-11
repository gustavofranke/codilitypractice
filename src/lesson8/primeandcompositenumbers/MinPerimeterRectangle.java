package lesson8.primeandcompositenumbers;

import static org.junit.Assert.*;

import org.junit.Test;

/*An integer N is given, representing the area of some rectangle.

 The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).

 The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.

 For example, given integer N = 30, rectanglmes of area 30 are:

 (1, 30), with a perimeter of 62,
 (2, 15), with a perimeter of 34,
 (3, 10), with a perimeter of 26,
 (5, 6), with a perimeter of 22.
 Write a function:

 class Solution { public int solution(int N); }

 that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.

 For example, given an integer N = 30, the function should return 22, as explained above.

 Assume that:

 N is an integer within the range [1..1,000,000,000].
 Complexity:

 expected worst-case time complexity is O(sqrt(N));
 expected worst-case space complexity is O(1).
 */
public class MinPerimeterRectangle {

	public int solution(int N) {
		int minPerimeter = Integer.MAX_VALUE;

		for (int a = 1; a * a <= N; a++) {
			if (N % a == 0) {
				minPerimeter = Math.min(minPerimeter, 2 * (N / a + a));
			}
		}
		return minPerimeter;
	}

	@Test
	public void minPerimeterRectangleTest() {
		MinPerimeterRectangle pr = new MinPerimeterRectangle();

		assertEquals(22, pr.solution(30));
		assertEquals(4, pr.solution(1));
	}

}
