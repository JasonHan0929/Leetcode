public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {//only iterates the num of 1s times
            result++;
            n = n & (n - 1);
        }
        return result;
    }
}
public class Solution {
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >>> i) & 1) == 1)
                result++;
        }
        return result;
    }
}//32n
