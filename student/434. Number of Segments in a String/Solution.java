public class Solution {
    public int countSegments(String s) {
        if (s == null || s.length() <= 0)
            return 0;
       int count = 0;
       int index = 0;
       for (int i = 0; i < s.length(); i++) {
           if (s.charAt(i) == ' ' && i != 0 && s.charAt(i - 1) != ' ')
                count++;
            if (s.charAt(i) != ' ')
                index = i;
       } 
       return index == s.length() - 1 && s.charAt(index) != ' ' ? count + 1: count;//这里注意排除" "情况
    }
}//就是怎么排除前后空格
