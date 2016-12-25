public class Solution {
    public int titleToNumber(String s) {
        int column = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            column += (s.charAt(i) - 64) * (int)Math.pow(26, s.length() - 1 - i);//可以不写(int)
        }
        return column;
    }
}//注意java^是按位抑或不是乘方运算

public class Solution {
    public int titleToNumber(String s) {
    
        int result  = 0;
        for (int i = 0; i < s.length(); i++){
            result *= 26;
            result += ((s.charAt(i) - 'A') + 1);    
        }
    
        return result;
    }
}//从左向右算，用移位的思想更简单
