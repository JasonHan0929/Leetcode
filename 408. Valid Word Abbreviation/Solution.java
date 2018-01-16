class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        char[] wordChar = word.toCharArray();
        char[] abbrChar = abbr.toCharArray();
        int i = 0, j = 0;
        while (i < wordChar.length && j < abbrChar.length) {
            if (wordChar[i] == abbrChar[j]) {
                i++; j++;
                continue;
            }
            if (abbrChar[j] <= '0' || abbrChar[j] > '9') return false;
            int begin = j;
            while (j < abbrChar.length && abbrChar[j] <= '9' && abbrChar[j] >= '0') j++;
            i += Integer.parseInt(abbr.substring(begin, j));
        }
        return i == wordChar.length && j == abbrChar.length;
    }
}
