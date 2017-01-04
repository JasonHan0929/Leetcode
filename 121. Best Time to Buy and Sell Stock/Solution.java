public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int soFarMin = Integer.MAX_VALUE;
        for (int num : prices) {
            if (num > soFarMin)
                result = Math.max(num - soFarMin, result);
            else
                soFarMin = num;
        }
        return result;
    }
}
