public class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3)
            return false;
        int n = num.length();
        for (int i = 0; i <= n / 2; i++) {
            if (num.charAt(0) == '0' && i > 0)//corner case
                return false;
            long first = Long.parseLong(num.substring(0, i + 1));
            for (int j = i + 1; n - j >= Math.max(i, j - i); j++) {
                if (num.charAt(i + 1) == '0' && j - i != 1)//corner case
                    break;
                long second = Long.parseLong(num.substring(i + 1, j + 1));
                String string = num.substring(j + 1, n);
                if (string.length() == 0)
                    return false;
                long sum = first + second;
                int sumLen = String.valueOf(sum).length();
                while (sumLen <= string.length() && sum == Long.parseLong(string.substring(0, sumLen))) {
                    string = string.substring(sumLen, string.length());
                    long temp = sum;
                    sum = second + sum;
                    second = temp;
                    sumLen = String.valueOf(sum).length();
                }
                if (string.length() == 0)
                    return true;
            }
        }
        return false;
    }
}//logic is messy

/*
The idea is quite straight forward. Generate the first and second of the sequence, check if the rest of the string match the sum recursively. i and j are length of the first and second number. i should in the range of [0, n/2]. The length of their sum should >= max(i,j)

Java Recursive

import java.math.BigInteger;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; ++i) {
            if (num.charAt(0) == '0' && i > 1) return false;
            BigInteger x1 = new BigInteger(num.substring(0, i));
            for (int j = 1; Math.max(j, i) <= n - i - j; ++j) {
                if (num.charAt(i) == '0' && j > 1) break;
                BigInteger x2 = new BigInteger(num.substring(i, i + j));
                if (isValid(x1, x2, j + i, num)) return true;
            }
        }
        return false;
    }
    private boolean isValid(BigInteger x1, BigInteger x2, int start, String num) {
        if (start == num.length()) return true;
        x2 = x2.add(x1);
        x1 = x2.subtract(x1);
        String sum = x2.toString();
        return num.startsWith(sum, start) && isValid(x1, x2, start + sum.length(), num);
    }
}
// Runtime: 8ms
Since isValid is a tail recursion it is very easy to turn it into a loop.

Java Iterative

public class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; ++i)
            for (int j = 1; Math.max(j, i) <= n - i - j; ++j)
                if (isValid(i, j, num)) return true;
        return false;
    }
    private boolean isValid(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        String sum;
        BigInteger x1 = new BigInteger(num.substring(0, i));
        BigInteger x2 = new BigInteger(num.substring(i, i + j));
        for (int start = i + j; start != num.length(); start += sum.length()) {
            x2 = x2.add(x1);
            x1 = x2.subtract(x1);
            sum = x2.toString();
            if (!num.startsWith(sum, start)) return false;
        }
        return true;
    }
}
// Runtime: 9ms
If no overflow, instead of BigInteger we can consider to use Long which is a lot faster.

Java Iterative Using Long

public class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; ++i)
            for (int j = 1; Math.max(j, i) <= n - i - j; ++j)
                if (isValid(i, j, num)) return true;
        return false;
    }
    private boolean isValid(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        String sum;
        Long x1 = Long.parseLong(num.substring(0, i));
        Long x2 = Long.parseLong(num.substring(i, i + j));
        for (int start = i + j; start != num.length(); start += sum.length()) {
            x2 = x2 + x1;
            x1 = x2 - x1;
            sum = x2.toString();
            if (!num.startsWith(sum, start)) return false;
        }
        return true;
    }
}
// Runtime: 3ms
*/
