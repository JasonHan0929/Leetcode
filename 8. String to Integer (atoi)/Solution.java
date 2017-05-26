public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        int result = 0;
        int i = 0;
        int len = str.length();
        int sign = 1;
        while (i < len && str.charAt(i) == ' ')//whitespace
            i++;
        if (i < len && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            if (str.charAt(i) == '-')
                sign *= -1;
            i++;
        }//sign
        int j = i;
        while (j < len && Character.isDigit(str.charAt(j)))//invalid input
            j++;
        while (i < j) {
            result += (int)Math.pow(10, j - i - 1) * (str.charAt(i) - '0') * sign;// Math.pow might overflow?
            if (sign * result < 0)
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;//overflow(a string will be too big so that it will overflow more than one time)
            i++;
        }
        return result;
    }
}

public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        int result = 0;
        int i = 0;
        int len = str.length();
        int sign = 1;
        while (i < len && str.charAt(i) == ' ')
            i++;
        if (i < len && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            if (str.charAt(i) == '-')
                sign *= -1;
            i++;
        }
        while (i < len && Character.isDigit(str.charAt(i))) {
            if (((long)result * 10 + (str.charAt(i) - '0')) > result * 10 + (str.charAt(i) - '0'))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }
        return result * sign;
    }
}


/*
public static int myAtoi(String str) {
    if (str.isEmpty()) return 0;
    int sign = 1, base = 0, i = 0;
    while (str.charAt(i) == ' ')
        i++;
    if (str.charAt(i) == '-' || str.charAt(i) == '+')
        sign = str.charAt(i++) == '-' ? -1 : 1;
    while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {//important
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        base = 10 * base + (str.charAt(i++) - '0');
    }
    return base * sign;
}
*/
