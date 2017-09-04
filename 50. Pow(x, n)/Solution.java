class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        else if (n == Integer.MIN_VALUE) {//pay attention
            x = 1 / x;
            n = Integer.MAX_VALUE;
            return x * myPow(x, n);
        }
        else if (n < 0) {
            x = 1 / x;
            n *= -1;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
