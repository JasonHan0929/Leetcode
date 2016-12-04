public class Solution {
    public int longestPalindrome(String s) {
        int[] hash = new int[128];
        int sum = 0;
        int oddAppear = 0;
        for (char chr : s.toCharArray())
            hash[chr]++;
        for (int num : hash) {
            if (num > 0 && num % 2 == 0)
                sum += num;
            if (num > 0 && num % 2 == 1) {
                sum += num - 1;
                oddAppear = 1;
            }
        }
        return sum + oddAppear;
    }
}
/*解题思路：
统计每个字母的出现次数：

  若字母出现偶数次，则直接累加至最终结果

  若字母出现奇数次，则将其值-1之后累加至最终结果

若存在出现奇数次的字母，将最终结果+1*/
