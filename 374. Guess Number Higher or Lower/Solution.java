/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 0;
        int high = n;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (guess(mid) > 0)
                low = mid + 1;
            else if (guess(mid) < 0)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}//注意这个题不能用左闭由开模式，因为n为Integer.MAX_VALUE的时候，high = n + 1会溢出
