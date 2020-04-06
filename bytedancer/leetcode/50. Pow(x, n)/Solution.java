class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        double result = 1;
        long N = n;
        if (n < 0 ) {
            N *= -1;
        }
        while (N > 0) {
            //System.out.println(String.format("%d %f", n, result));
            if (N % 2 == 1) {
                result *= x;
            }
            x *= x;
            N /= 2;
        }
        return n < 0 ? 1/result : result;
    }
}
