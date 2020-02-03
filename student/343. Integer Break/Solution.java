public class Solution {
    public int integerBreak(int n) {
        switch (n) {
            case 2 :
                return 1;
            case 3 :
                return 2;
            default :
                int a = n / 3;
                int b = n % 3;
                if (b == 1) {
                    return 4 * (int)Math.pow(3, a - 1);
                }
                else if (b == 0) {
                    return (int)Math.pow(3, a);
                }
                else {
                    return 2 * (int)Math.pow(3, a);
                }
        }
    }
}//纯属数学解法，任何数的最大值都由3，2的乘积组成
/*
观察n从2到13时的情形：

2  ->  1 * 1
3  ->  2 * 1
4  ->  2 * 2
5  ->  3 * 2
6  ->  3 * 3
7  ->  3 * 2 * 2
8  ->  3 * 3 * 2
9  ->  3 * 3 * 3
10 ->  3 * 3 * 2 * 2
11 ->  3 * 3 * 3 * 2
12 ->  3 * 3 * 3 * 3
13 ->  3 * 3 * 3 * 2 * 2
从上面可以找到如下规律：

n / 3 <= 1 时，分为两个数的乘积，尽量均摊
n / 3 > 1 时，分为若干个3和2的乘积
n % 3 == 0 时，分为n个3的乘积
n % 3 == 1 时，分为n-1个3和两个2的乘积
n % 3 == 2 时，分为n个3和一个2的乘积

也可以用动态规划
dp[i]表示整数i拆分可以得到的最大乘积，则dp[i]只与dp[i - 2], dp[i - 3]两个状态有关

得到状态转移方程：

dp[x] = max(3 * dp[x - 3], 2 * dp[x - 2])
*/
