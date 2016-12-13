public class Solution {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        int carry = 0;
        int sum = 0;
        StringBuilder builder = new StringBuilder();
        while (n1 >=0 || n2 >= 0) {
            if (n1 >= 0)
                sum += num1.charAt(n1--) - '0';
            if (n2 >= 0)
                sum += num2.charAt(n2--) - '0';
            carry = sum / 10;
            sum = sum % 10;
            builder.insert(0, sum);
            sum = carry;
        }
        if (carry != 0)
            builder.insert(0, carry);
        return builder.toString();
    }
}
