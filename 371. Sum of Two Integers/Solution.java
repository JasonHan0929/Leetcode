public class Solution {
    public int getSum(int a, int b) {
        int carry = 0;
        while (b != 0) {
            carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}//-2 + 4的运算过程会很迷
