package lesson5.stacksandqueues;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Stack;

/*A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

 S is empty;
 S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 S has the form "VW" where V and W are properly nested strings.
 For example, the string "{[()()]}" is properly nested but "([)()]" is not.

 Write a function:

 class Solution { public int solution(String S); }

 that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

 For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

 Assume that:

 N is an integer within the range [0..200,000];
 string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 Complexity:

 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(N) (not counting the storage required for input arguments).*/
public class Brackets {

	public int solution(String S) {// got 100% with this one
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < S.length(); i++) {
			char element = S.charAt(i);
			if (element == '(' || element == '[' || element == '{') {
				stack.push(element);
			} else {
				if (stack.isEmpty()) {
					return 0;
				}
				char last = stack.pop();
				if (!isNested(last, element)) {
					return 0;
				}
			}
		}
		if (!stack.isEmpty()) {
			return 0;
		}
		return 1;
	}

	private boolean isNested(char first, char last) {
		if (first == '(' && last == ')')
			return true;
		if (first == '[' && last == ']')
			return true;
		if (first == '{' && last == '}')
			return true;
		else
			return false;
	}

	@Test
	public void bracketsTest() {
		Brackets b = new Brackets();
		String str = "()";
		String str1 = "";
		String str2 = "{[()()]}";
		String str3 = "([)()]";
		assertEquals(1, b.solution(str));
		assertEquals(1, b.solution(str1));
		assertEquals(1, b.solution(str2));
		assertEquals(0, b.solution(str3));

		assertEquals(false, b.isNested('(', '}'));
		assertEquals(true, b.isNested('[', ']'));
		assertEquals(true, b.isNested('{', '}'));
	}

}
