import java.util.*;

public class PrefixToPostFix {
	public static String[] solution(String[] prefix) {
		int n = prefix.length;
		Deque<String> stack = new LinkedList<>();
		String[] result = new String[n];
		for (int j = 0; j < n; j++) {
			for (int i = prefix[j].length() - 1; i >= 0 ; i--) {
				char currChar = prefix[j].charAt(i);
				if (Character.isAlphabetic(currChar)) {
					stack.push(Character.toString(currChar));
				} else {
					String segment = stack.pop() + stack.pop() + currChar;
					stack.push(segment);
				}
			}
			result[j] = stack.pop();
		}
		return result;
	}


	public static void main(String[] args) {
		String[] inputs = new String[]{"-*+ABC*-DE+FG", "++A*BCD", "*+AB+CD", "+*AB*CD", "+++ABCD"};
		System.out.println(Arrays.toString(solution(inputs)));
	}
}