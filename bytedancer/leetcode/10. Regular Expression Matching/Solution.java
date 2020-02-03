class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()][p.length()];
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                dp[i][j] = isMatchCharacter(i, j, dp, sArray, pArray) && isMatchBefore(dp, i - 1, j - 1, sArray, pArray) || isMatchBefore(dp, i - 1, j, sArray, pArray) && isMatchCharacter(i, j - 1, dp, sArray, pArray) && pArray[j] == '*' ||isMatchBefore(dp, i, j - 2, sArray, pArray) && pArray[j] == '*';
            }
        }
        //for (boolean[] line : dp) {
            //System.out.println(Arrays.toString(line));
        //}
        return isMatchBefore(dp, s.length() - 1, p.length() - 1, sArray, pArray);
    }
    private boolean isMatchCharacter(int i, int j, boolean[][] dp, char[] s, char[] p) {
        if (j < 0 || j < 0) {
            return false;
        }
        if (p[j] == '.') {
            return true;
        } else if (p[j] == s [i]) {
            return true;
        }
        return false;
    }
    private boolean isMatchBefore(boolean[][] dp, int i, int j, char[] s, char[] p) {
        //注意对s为空白串时的讨论
        if (i == -1 && j == -1 || i == -1 && p[j] == '*' && isMatchBefore(dp, i, j - 2, s, p)) {
            return true;
        } else if (i < 0 || j < 0) {
            return false;
        }
        return dp[i][j];
    }
}
