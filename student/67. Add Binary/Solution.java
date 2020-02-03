public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int sum = 0;
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        while (lenA >=0 || lenB >= 0) {
            sum = carry;
            if (lenA >= 0)
                sum += a.charAt(lenA--) - '0';
            if (lenB >= 0)
                sum += b.charAt(lenB--) - '0';//ascii中数字0对应48以及int和char在一起的算式有可能会把int变成string
            result.insert(0, sum % 2);
            carry = sum / 2;
        }
        if (carry == 1)
            result.insert(0, carry);//注意stringbuilder可以insert任意位置的
        return result.toString();//或者也可以append最后reverse（）
    }
}//逻辑一定要清晰，不一定分清楚谁长谁短，只需要每个字符串用len控制位数就好


