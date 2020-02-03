public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        int digit = 0;
        for (int i = 0; i < 32; i++) {
            if (result != 0)
                result = result << 1;//注意result只移31次
            digit = 1 << i;
            if ((digit & n) == digit) {
                digit = digit >>> i; 
                result |= digit;
            }
        }
        return result;
    }
}
