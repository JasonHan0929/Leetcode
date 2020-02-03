public class Solution {
    public int findNthDigit(int n) {
        int i = 1;
        long count = 9;//int could overflow
        int start = 1;
        while (n > count * i) {
            n -= count * i;
            i++;
            count *= 10;
            start *= 10;
        }
        int temp = start + (n - 1) / i;// n - 1
        return Integer.toString(temp).charAt((n - 1) % i) - '0';// n - 1
    }
}
