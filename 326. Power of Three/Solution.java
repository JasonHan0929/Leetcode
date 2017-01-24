public class Solution {
    public boolean isPowerOfThree(int n) {
        return ( n>0 &&  1162261467%n==0);
    }
}// 1162261467 is 3^19,  3^20 is bigger than int
