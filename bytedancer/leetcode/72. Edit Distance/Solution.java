class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        } else if (word1 == null) {
            return word2.length(); 
        } else if (word2 == null) {
            return word1.length();
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < word2.length() + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                int insert = dp[i][j - 1] + 1;
                int delete = dp[i - 1][j] + 1;
                int replace = dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1); // 注意这个不加（）会出问题
                dp[i][j] = Math.min(insert, Math.min(delete, replace));
            }
        }
        //for (int[] line : dp) {
            //System.out.println(Arrays.toString(line));
        //}
        return dp[word1.length()][word2.length()];
    }
}
