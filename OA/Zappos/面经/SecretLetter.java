public class SecretLetter {
	public static String secretLetter(String input) {
		String[] words = input.split(" ");
		StringBuilder result = new StringBuilder();
		int i = 0;
		while (i < words.length) {
			/*if (words[i].equals(" ")) {
				while (i < words.length) {
					result.append(words[i++]);
				}
				result.append(" ");
				continue;
			}*/
			//else {
				result.append(new StringBuilder(words[i++]).reverse());
				result.append(" ");
			//}
		}
		if (input.charAt(input.length() - 1) != ' ') {
			result.deleteCharAt(result.length() - 1);
		}
		return result.toString();
	}
	public static void main(String[] args) {
		String input = "Let's meet         in the   owlery  today ";
		System.out.println(secretLetter(input));
		System.out.println("s'teL teem         ni eht   yrelwo  yadot ");
		System.out.print(secretLetter(input).equals("s'teL teem         ni eht   yrelwo  yadot "));
	}
}