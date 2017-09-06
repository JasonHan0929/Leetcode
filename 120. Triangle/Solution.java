class Solution {
    /*public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        List<Integer> dp = new LinkedList<>();
        dp.add(0, triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
            dp.add(0, dp.get(0) + triangle.get(i).get(0));
            int size = dp.size();
            for (int j = 1; j < size - 1; j++)
                dp.set(j, Math.min(dp.get(j), dp.get(j + 1)) + triangle.get(i).get(j));
            dp.set(size - 1, dp.get(size - 1) + triangle.get(i).get(size - 1));
        }
        int min = Integer.MAX_VALUE;
        for (int value : dp)
            min = Math.min(min, value);
        return min;
    }*/ // top-down, very slow
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size() + 1;//add a lowest level which is filled by 0
        int[] dp = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++)
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
        }
        return dp[0];
    }
}
