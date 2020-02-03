public class Solution {
    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int count = 0;
        int digit = 1;
        for (int i = 0; i < 32 ; i++) {
            digit = 1 << i;
            if ((temp & digit) == digit)//注意是==digit不是==1
                count++;
        }
        return count;
    }
}
