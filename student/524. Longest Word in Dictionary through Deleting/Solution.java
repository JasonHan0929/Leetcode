class Solution {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        char[] str = s.toCharArray();
        for (String word : d) {
            int len = word.length();
            if (len <= str.length) {
                int i = 0;
                for (char c : str) {
                    if (c == word.charAt(i))
                        i++;
                    if (i == len)
                        break;
                }
                if (i == len && result.length() < len)
                    result = word;
                else if (i == len && result.length() == len && result.charAt(0) > word.charAt(0))
                    result = word;
            }
        }
        return result;
    }
}
/*
We sort the input dictionary by longest length and lexicography. Then, we iterate through the dictionary exactly once. In the process, the first dictionary word in the sorted dictionary which appears as a subsequence in the input string s must be the desired solution.

public String findLongestWord(String s, List<String> d) {
    Collections.sort(d, (a,b) -> a.length() != b.length() ? -Integer.compare(a.length(), b.length()) :  a.compareTo(b));
    for (String dictWord : d) {
        int i = 0;
        for (char c : s.toCharArray()) 
            if (i < dictWord.length() && c == dictWord.charAt(i)) i++;
        if (i == dictWord.length()) return dictWord;
    }
    return "";
}
An alternate, more efficient solution which avoids sorting the dictionary:

public String findLongestWord(String s, List<String> d) {
    String longest = "";
    for (String dictWord : d) {
        int i = 0;
        for (char c : s.toCharArray()) 
            if (i < dictWord.length() && c == dictWord.charAt(i)) i++;

        if (i == dictWord.length() && dictWord.length() >= longest.length()) 
            if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0)
                longest = dictWord;
    }
    return longest;
}
Time Complexity: O(nk), where n is the length of string s and k is the number of words in the dictionary.
*/
