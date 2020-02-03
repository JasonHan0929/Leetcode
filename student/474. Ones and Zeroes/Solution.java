public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String string : strs) {
            int[] count = count(string);
            int[][] next = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i >= count[0] && j >= count[1])
                        next[i][j] = Math.max(dp[i][j], dp[i - count[0]][j - count[1]] + 1);
                    else
                        next[i][j] = dp[i][j];
                }
            }
            dp = next;
        }
        return dp[m][n];
    }
    public int[] count(String strs) {
        int[] result = new int[2];
        for (int i = 0; i< strs.length(); i++)
            result[strs.charAt(i) - '0']++;
        return result;
    }
}//two-dimention knapsack. m, n is the same as 'weight' of the knapsack problem

public int findMaxForm(String[] strs, int m, int n) {
    int[][] dp = new int[m+1][n+1];
    for (String s : strs) {
        int[] count = count(s);
        for (int i=m;i>=count[0];i--) 
            for (int j=n;j>=count[1];j--) 
                dp[i][j] = Math.max(1 + dp[i-count[0]][j-count[1]], dp[i][j]);
    }
    return dp[m][n];
}
    
public int[] count(String str) {
    int[] res = new int[2];
    for (int i=0;i<str.length();i++)
        res[str.charAt(i) - '0']++;
    return res;
 }//need to think
/*
Hi there! I am sharing explanation of my solution. In the problem what matters is the number of zeros and ones in each string. Therefore the first thing we have to do, is to turn the array of string into array of pairs. The ith pair contains number of zeros and ones in ith string. Next step is to determine how many pairs from the array we can cover by m and n;
The strightforward idea is backtracking. So we can just try out covering strings starting from different positions and maximize the result. Implementation of this idea is written below:

public class Solution {
    Integer memo[][][];
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs == null || strs.length == 0 || (m == 0 && n == 0)) return 0;
        memo = new Integer[m+1][n+1][strs.length];
        int [][] pairs = new int[strs.length][2];
        for(int i = 0;i<strs.length;i++){
            for(int j = 0;j<strs[i].length();j++){
                char ch  = strs[i].charAt(j);
                if(ch == '0') pairs[i][0]++;
                else pairs[i][1]++;
            }
        }
        return go(pairs, 0, m, n);
    }
    
    public int go(int pairs[][], int s, int m, int n){
        if(s >= pairs.length) return 0;
        if(memo[m][n][s] != null) return memo[m][n][s];
        int count = 0;
        for(int i = s;i<pairs.length;i++){
            int dm = m - pairs[i][0];
            int dn = n - pairs[i][1];
            if(dm >= 0 && dn >=0) {
                count = Math.max(count, 1+go(pairs, i+1, dm, dn));
            }
        }
        memo[m][n][s] = count;
        return count;
    }
} 

This top to down approach solution gets TLE at 51/56 test. But I think this approach could be accepted in an interview.
My second solution uses bottom-up algorithm (DP). But pursues the same thinking approach.
A state of my DP (int i, int numOfZeros, int numOfOnes) describes the maximum number of strings we can construct starting from index 'i' by having numOfZeros zeros and numOfOnes ones.
There are two simple transition functions from upper state to lower state.

First transition is skipping the ith string and just taking the maximum value we can construct starting from i-1 th string.
Second transition is constructing current string (ith string) then adding maximum number of strings that can be constructed starting from i-1 th string by the rest of ones and zeros (numOfZeros - pair[i][0] and numOfOnes-pair[i][1]).
The value for the current state is the maximum of values of the two transaction. Finally the answer is the value of state that describes the number of strings that can be constructed starting from the last(or the first,actually does not matter) index of the input string by m zeros and n ones. In other words just return dp[strs.length-1][m][n];

public class Solution {
    
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs == null || strs.length == 0 || (m == 0 && n == 0)) return 0;
        int dp [][][] = new int[strs.length][m+1][n+1];
        int [][] pairs = new int[strs.length][2];
        for(int i = 0;i<strs.length;i++){
            for(int j = 0;j<strs[i].length();j++){
                char ch  = strs[i].charAt(j);
                if(ch == '0') pairs[i][0]++;
                else pairs[i][1]++;
            }
        }
        for(int zeros =  pairs[0][0];zeros<=m;zeros++){
               for(int ones = pairs[0][1];ones<=n;ones++){
                   dp[0][zeros][ones] = 1;
               }
        } 
        for(int i  = 1;i<strs.length;i++){
           for(int zeros =  0;zeros<=m;zeros++){
               for(int ones = 0;ones<=n;ones++){
                   dp[i][zeros][ones] = dp[i-1][zeros][ones];
               }
           }
           for(int zeros =  pairs[i][0];zeros<=m;zeros++){
               for(int ones = pairs[i][1];ones<=n;ones++){
                   dp[i][zeros][ones] = Math.max(dp[i-1][zeros][ones], 1+dp[i-1][zeros-pairs[i][0]][ones-pairs[i][1]]);
               }
           }
        }
        return dp[strs.length-1][m][n];
    }
    
   
}

Time and space complexity of the solution is O(n*m*pairs.length)
*/

