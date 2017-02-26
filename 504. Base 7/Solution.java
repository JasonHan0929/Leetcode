public class Solution {
    public String convertToBase7(int num) {
        if (num == 0)
            return "0";
        StringBuilder result = new StringBuilder();
        String sign = num < 0 ? "-" : "";
        num = Math.abs(num);
        int digit = 0;
        while (num > 0) {
            digit = num % 7;
            result.append(digit);
            num /= 7;
        }
        result.append(sign);
        return result.reverse().toString();
    }
}

public String convertTo7(int num) {
    return Integer.toString(num, 7);
}

public String convertTo7(int num) {
    if (num < 0)
        return '-' + convertTo7(-num);
    if (num < 7)
        return num + "";
    return convertTo7(num / 7) + num % 7;
}
