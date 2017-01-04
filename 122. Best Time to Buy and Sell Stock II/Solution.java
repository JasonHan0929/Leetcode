public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length -1 ; i++) {
            if (prices[i] < prices[i + 1])
                result += prices[i + 1] - prices[i];
        }
        return result;
    }
}
/*
Agree. My proof:

for an ascending squence, the answer is prices[last] - price[0]. as prices[j] - price[i] = price[i+1] - price[i] + price[i+2]-price[i+1] ... + price[last] - price[last-1]

for any squence, if there's no sub sequence that is acending, then profit is 0

if there's a longest sub sequence, p[i] to p[j], then p[j+1] will less than p[j]

if there's another sub ascending sequence after p[j+1] say p[m] ~ p[n], then, p[j+1] ~ p[m] is a descending sequence which won't have profit.

sub conclusion: only ascending sequence will have profit. Descending sequence won't have profit. And multiple ascending sequences won't impact each other: Proof: say i~j, m~n is 2 adjacent ascending sequence then j~m should be an descending sequence if they will impact on each other, this mean we won't sell on j then there should be another x: m <= x <= n that p[x] - p[i] > p[m] - p[n] + p[j] - p[i] as p[x] <= p[n] then p[n] - p[i] > p[n] - p[m] + p[j] - p[i] then p[j] - p[m] < 0 => p[m] > p[j] which is impossible as j~m is descend
*/
