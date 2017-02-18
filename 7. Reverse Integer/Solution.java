public class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE)
            return 0;
        int sign = x >= 0 ? 1 : -1;
        x = Math.abs(x);
        int result = 0;
        while (x >= 10) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (result > Integer.MAX_VALUE / 10 && result * 10 < Integer.MAX_VALUE)
            return 0;
        return (result * 10 + x) * sign;
    }
}

public class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE)
            return 0;
        int result = 0;
        while (x > 0 && x >= 10 || x < 0 && x <= -10) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (result > Integer.MAX_VALUE / 10 && result * 10 < Integer.MAX_VALUE || result < Integer.MIN_VALUE / 10 && result * 10 > Integer.MIN_VALUE)
            return 0;
        return result * 10 + x;
    }
}//more faster, but why? since Math.abs() is O(1)

/*
public class Solution {
    public int reverse(int x) {
        long result =0;
        while(x != 0)
        {
            result = (result*10) + (x%10);
            if(result > Integer.MAX_VALUE) return 0;
            if(result < Integer.MIN_VALUE) return 0;
            x = x/10;
        }
        return (int)result;
        
        
    }
}// more simple

public int reverse(int x)
{
    int result = 0;

    while (x != 0)
    {
        int tail = x % 10;
        int newResult = result * 10 + tail;
        if ((newResult - tail) / 10 != result)
        { return 0; }
        result = newResult;
        x = x / 10;
    }

    return result;
}
*/
