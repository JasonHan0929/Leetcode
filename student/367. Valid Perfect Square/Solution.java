public class Solution {
    public boolean isPerfectSquare(int num) {
        long low = 0;
        long high = num;//要用long不然testcase存在溢出案例
        long mid = 0;
        while(low <= high) {
            mid = low + (high - low) / 2;
            if (mid * mid < num)
                low = mid + 1;
            else if (mid * mid > num)
                high = mid - 1;
            else
                return true;
        }
        return false;
    }
}
/*
1.a square number is 1+3+5+7+... Time Complexity O(sqrt(N)) (Credit to lizhibupt, thanks for correcting this).
2.binary search. Time Complexity O(logN)
3.Newton Method. See [this wiki page][1]. Time Complexity is close to constant, given a positive integer.


    public boolean isPerfectSquare(int num) {
      if (num < 1) return false;
      for (int i = 1; num > 0; i += 2)
        num -= i;
      return num == 0;
    }
    
    public boolean isPerfectSquare(int num) {
      if (num < 1) return false;
      long left = 1, right = num;// long type to avoid 2147483647 case
    
      while (left <= right) {
        long mid = left + (right - left) / 2;
        long t = mid * mid;
        if (t > num) {
          right = mid - 1;
        } else if (t < num) {
          left = mid + 1;
        } else {
          return true;
        }
      }
    
      return false;
    }
    
    boolean isPerfectSquare(int num) {
      if (num < 1) return false;
      long t = num / 2;
      while (t * t > num) {
        t = (t + num / t) / 2;
      }
      return t * t == num;
    }



  [1]: https://en.wikipedia.org/wiki/Newton%27s_method
*/
