class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        int total = 0;
        boolean down = true, up = true;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                total += prices[i + 1] - prices[i];
                if (down) start.add(i);
                down = false;
                up = true;
            } else if (prices[i + 1] < prices[i]) {
                if (up) end.add(i);
                up = false;
                down = true;
            }
        }
        if (prices[prices.length - 1] > prices[prices.length - 2]) end.add(prices.length - 1);
        System.out.println(start);
        System.out.println(end);
        return total;
    }
}
