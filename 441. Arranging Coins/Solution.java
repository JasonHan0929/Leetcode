class Solution {
    public int arrangeCoins(int n) {
        int k = 0;
        for (int i = 1; i <= n; i++) {
            n -= i;
            k++;
        }
        return k;
    }

}

/*
class Solution {
    public int arrangeCoins(int n) {
        int result = (int)Math.sqrt(1 + 8l * n) -1;// 8 * n is bigger than Integer.MAX_VALUE
        return result / 2;
    }
}
*/
