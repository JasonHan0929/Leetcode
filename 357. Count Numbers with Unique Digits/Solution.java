public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int tail = 0;
        for (int i = n; i > 1; i--) {
            tail += (i - 1) * permutation(i - 2, 9);
        }
        return permutation(n, 10) + tail; 
    }
    public int permutation(int n, int m) {
        int result = 1;
        while (n > 0) {
            result *= m - n + 1;
            n--;
        }
        return result;
    }
}//基于数学求通项的纯手算方法，result(n) = permutation(n, 10) + sum((n - 1) *permutation(9, n - 2))
