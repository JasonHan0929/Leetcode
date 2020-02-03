import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
    	 Scanner scanner = new Scanner(System.in);
    	 int T = scanner.nextInt();//must read the '\n'
    	 scanner.nextLine();
    	 while (T-- > 0) {
             scanner.nextLine();
    	     String A = scanner.nextLine();
    	     String B = scanner.nextLine();
    	     char[] a = A.toCharArray();
    	     char[] b = B.toCharArray();
    	     System.out.println(lsc2(a, b));
    	 }
	 }
	private static int lsc2(char[] a, char[] b) {
        int lenA = a.length, lenB = b.length;
        int[][] dp = new int[lenA + 1][lenB + 1];
        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (a[i - 1] == b[j - 1])
                    dp[i][j] = findMax(dp[i - 1][j - 1] + 1, dp[i - 1][j], dp[i][j - 1]);
                else
                    dp[i][j] = findMax(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[lenA][lenB];
    }
    
    private static int findMax(int...o) {
        int max = Integer.MIN_VALUE;
        for (int num : o)
            max = Math.max(max, num);
        return max;
    }
}
