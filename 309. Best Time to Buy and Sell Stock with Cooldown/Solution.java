public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        if (prices.length == 2)
            return Math.max(prices[1] - prices[0], 0);
        int len = prices.length;
        int[] sold = new int[len];
        int[] bought = new int[len];
        sold[0] = 0;
        sold[1] = Math.max(prices[1] - prices[0], 0);
        bought[0] = -prices[0];
        bought[1] = Math.max(-prices[0], -prices[1]);
        for (int i = 2; i < len; i++) {
            sold[i] = Math.max(sold[i - 1], bought[i - 1] + prices[i]);
            bought[i] = Math.max(bought[i - 1], sold[i - 2] - prices[i]);
        }
        return sold[len - 1];
    }
}
/*
解法II：

引入辅助数组sells和buys

sells[i]表示在第i天不持有股票所能获得的最大累计收益
buys[i]表示在第i天持有股票所能获得的最大累计收益

初始化数组：
sells[0] = 0
sells[1] = max(0, prices[1] - prices[0])
buys[0] = -prices[0]
buys[1] = max(-prices[0], -prices[1])
状态转移方程：

sells[i] = max(sells[i - 1], buys[i - 1] + prices[i])
buys[i] = max(buys[i - 1], sells[i - 2] - prices[i])
所求最大收益为sells[-1]

解法II：

引入辅助数组sells和buys

sells[i]表示在第i天不持有股票所能获得的最大累计收益
buys[i]表示在第i天持有股票所能获得的最大累计收益

初始化数组：
sells[0] = 0
sells[1] = max(0, prices[1] - prices[0])
buys[0] = -prices[0]
buys[1] = max(-prices[0], -prices[1])
状态转移方程：

sells[i] = max(sells[i - 1], buys[i - 1] + prices[i])
buys[i] = max(buys[i - 1], sells[i - 2] - prices[i])
所求最大收益为sells[-1]
*/
