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
        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        if (n == 1)
            return dp[0];
        dp[1] = s.charAt(1) == '0' ? 0 : dp[0];
        int temp = Integer.valueOf(s.substring(0, 2));
        dp[1] += temp <= 26 && temp > 0 ? 1 : 0;
        for (int i = 2; i < n; i++) {
            dp[i] = s.charAt(i) != '0' ? dp[i - 1] : 0;
            temp = Integer.valueOf(s.substring(i - 1, i + 1));
            if (temp <= 26 && temp > 0 && s.charAt(i - 1) != '0')
                dp[i] += dp[i - 2];
        }
        return dp[n - 1];
    }// not clean

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
