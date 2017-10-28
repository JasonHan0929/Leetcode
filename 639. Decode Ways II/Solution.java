class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int n = s.length();
        long[] dp = new long[n];// could overflow if use int
        dp[0] = s.charAt(0) == '*' ? 9 : 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != '0')
                dp[i] += dp[i - 1] * (s.charAt(i) == '*' ? 9 : 1);
            if (s.charAt(i - 1) != '0') {
                if (s.charAt(i) != '*') {
                    if (s.charAt(i - 1) == '*') {
                        if (s.charAt(i) <= '6')
                            dp[i] += i >= 2 ? dp[i - 2] * 2 : 2;
                        else
                            dp[i] += i >= 2 ? dp[i - 2] : 1;
                    }
                    else {
                        long temp = Integer.valueOf(s.substring(i - 1, i + 1));
                        if (temp <= 26)
                            dp[i] += i >= 2 ? dp[i - 2] : 1;
                    }
                } else {
                    long temp = i >= 2 ? dp[i - 2] : 1;
                    if (s.charAt(i - 1) == '1')
                        dp[i] += temp * 9;
                    else if (s.charAt(i - 1) == '2')
                        dp[i] += temp *6;
                    else if (s.charAt(i - 1) == '*')
                        dp[i] += temp * 15;
                }
            }
            dp[i] %= 1000000007; // could not do % only for the final result， (a + b) % p = (a % p + b % p) % p 
        }
        return (int)dp[n - 1];
    }
}

/*
The idea for DP is simple when using two helper functions
ways(i) -> that gives the number of ways of decoding a single character
and
ways(i, j) -> that gives the number of ways of decoding the two character string formed by i and j.
The actual recursion then boils down to :

f(i) = (ways(i) * f(i+1)) + (ways(i, i+1) * f(i+2))
The solution to a string f(i), where i represents the starting index,

f(i) = no.of ways to decode the character at i, which is ways(i) + solve for remainder of the string using recursion f(i+1)
and
no.of ways to decode the characters at i and i+1, which is ways(i, i+1) + solve for remainder of the string using recursion f(i+2)

The base case is ,

return ways(s.charAt(i)) if(i == j) 
The above recursion when implemented with a cache, is a viable DP solution, but it leads to stack overflow error, due to the depth of the recursion. So its better to convert to memoized version.

For the memoized version, the equation changes to

f(i) = ( f(i-1) * ways(i) ) + ( f(i-2) *ways(i-1, i) )
This is exactly the same as the previous recursive version in reverse,

The solution to a string f(i), where i represents the ending index of the string,

f(i) = solution to the prefix of the string f(i-1) + no.of ways to decode the character at i, which is ways(i)
and
solution to the prefix f(i-2) + no.of ways to decode the characters at i - 1 and i, which is ways(i-1, i)

public class Solution {
    public static int numDecodings(String s) {
        long[] res = new long[2];
        res[0] = ways(s.charAt(0));
        if(s.length() < 2) return (int)res[0];

        res[1] = res[0] * ways(s.charAt(1)) + ways(s.charAt(0), s.charAt(1));
        for(int j = 2; j < s.length(); j++) {
            long temp = res[1];
            res[1] = (res[1] * ways(s.charAt(j)) + res[0] * ways(s.charAt(j-1), s.charAt(j))) % 1000000007;
            res[0] = temp;
        }
        return  (int)res[1];
    }
    
    private static int ways(int ch) {
        if(ch == '*') return 9;
        if(ch == '0') return 0;
        return 1;
    }

    private static int ways(char ch1, char ch2) {
        String str = "" + ch1 + "" + ch2;
        if(ch1 != '*' && ch2 != '*') {
            if(Integer.parseInt(str) >= 10 && Integer.parseInt(str) <= 26)
                return 1;
        } else if(ch1 == '*' && ch2 == '*') {
            return 15;
        } else if(ch1 == '*') {
            if(Integer.parseInt(""+ch2) >= 0 && Integer.parseInt(""+ch2) <= 6)
                return 2;
            else
                return 1;
        } else {
            if(Integer.parseInt(""+ch1) == 1 ) {
                return 9;
            } else if(Integer.parseInt(""+ch1) == 2 ) {
                return 6;
            } 
        }
        return 0;
    }
}
*/
