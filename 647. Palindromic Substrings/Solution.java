class Solution {// same as Longest Palindromic Substring
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = n;
        for (int i = 0; i < n; i++)
            dp[i][i] = true;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (len > 2 && dp[i + 1][j - 1] || len <= 2)
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                if (dp[i][j])
                    count++;
            }
        }
        return count;
    }
}
/*
public class Solution {
    int count = 0;
    
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }
        
        return count;
    }
    
    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }
}
*/
