public class Solution {
    /*public int numDecodings(String s) {
        if (s.length() == 0)
            return 0;
        int[] dp = new int[s.length()];
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0')
                dp[i] += i > 1 ? dp[i - 1] : 1;
            if (i > 0)
                temp = s.charAt(i) - '0' + (s.charAt(i - 1) - '0') * 10;
            if (temp <= 26 && temp > 0)
                dp[i] += i > 2 ? dp[i - 2] : 1;
        }
        return dp[s.length() - 1];
    }*/ //wrong code
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i< s.length(); i++) {
            if (s.charAt(i) != '0')
                dp[i] += dp[i - 1];
            if (s.charAt(i - 1) != '0') {
                int temp = s.charAt(i) - '0' + (s.charAt(i - 1) - '0') * 10;
                if (temp <= 26 && temp >0)
                    dp[i] += i >= 2 ? dp[i - 2] : 1;
            }
        }
        return dp[s.length() - 1];
    }// pay attention to how to deal with '0'
}
