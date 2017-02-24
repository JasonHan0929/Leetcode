public class Solution {
    public int findComplement(int num) {
        int result = 0;
        int i = 0;
        while (num >= 1 << i) {
            result ^= ((num >> i & 1) == 1 ? 0 : 1)  << i;
            i++;
        }
        return result;
    }
}//time limit exceeded

public class Solution {
    public int findComplement(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }
}// ~ operation will reverse every bit of a number
