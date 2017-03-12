public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            String temp = words[i].trim();
            if (!temp.equals("")) {
                result.append(temp).append(" ");
            }
        }
        return result.toString().trim();
    }
}
