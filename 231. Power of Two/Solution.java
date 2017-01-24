public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;
        while (n > 1) {
            if (n % 2 != 0)
                return false;
            n /= 2;
        }
        return true;
    }
}//normal solution

public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }
}// if n is the power of two, then it's binary representation should only has one bit as 1, all the others are 0
class Solution {
    public:
        bool isPowerOfTwo(int n) {
            if(n<=0) return false;
            return !(n&(n-1));
        }
};
