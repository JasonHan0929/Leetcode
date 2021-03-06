public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length())
            return false;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i < m; i++)
            dp[i + 1][0] = dp[i][0] && s3.charAt(i) == s1.charAt(i);
        for (int i = 0; i < n; i++)
            dp[0][i + 1] = dp[0][i] && s3.charAt(i) == s2.charAt(i);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = (dp[i][j + 1] && s3.charAt(i + j + 1) == s1.charAt(i)) || (dp[i + 1][j] && s3.charAt(i + j + 1) == s2.charAt(j));
            }
        }
        return dp[m][n];
    }
}
/*
public boolean isInterleave(String s1, String s2, String s3) {

    if ((s1.length()+s2.length())!=s3.length()) return false;

    boolean[][] matrix = new boolean[s2.length()+1][s1.length()+1];

    matrix[0][0] = true;

    for (int i = 1; i < matrix[0].length; i++){
        matrix[0][i] = matrix[0][i-1]&&(s1.charAt(i-1)==s3.charAt(i-1));
    }

    for (int i = 1; i < matrix.length; i++){
        matrix[i][0] = matrix[i-1][0]&&(s2.charAt(i-1)==s3.charAt(i-1));
    }

    for (int i = 1; i < matrix.length; i++){
        for (int j = 1; j < matrix[0].length; j++){
            matrix[i][j] = (matrix[i-1][j]&&(s2.charAt(i-1)==s3.charAt(i+j-1)))
                    || (matrix[i][j-1]&&(s1.charAt(j-1)==s3.charAt(i+j-1)));
        }
    }

    return matrix[s2.length()][s1.length()];

}
*/
