public class Solution {
    public String decodeString(String s) {
        if (s.length() <= 0)
            return "";
        Deque<String> string = new LinkedList<>();
        Deque<Integer> number = new LinkedList<>();//注意分两个栈，分别记录当前string的情况和number的情况
        int index = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                index = i;
                while (s.charAt(i + 1) <= '9' && s.charAt(i + 1) >= '0')
                    i++;
                number.push(Integer.parseInt(s.substring(index, i + 1)));
            }
            else if (s.charAt(i) == '[') {
                string.push("");//用来区分每个数组对应的字符串长度
            }
            else if (s.charAt(i) == ']') {
                StringBuilder buffer = new StringBuilder();
                String ch = string.pop();
                while(!ch.equals("")) {
                    buffer.insert(0,ch);
                    ch = string.pop();
                }
                StringBuilder builder = new StringBuilder();
                int times = number.pop();
                for (int k = 0; k < times; k++)//不能直接写k < number.pop()
                    builder.append(buffer);
                string.push(builder.toString());
            }
            else {
                string.push(Character.toString(s.charAt(i)));
            }
            i++;
        }
        StringBuilder result = new StringBuilder();
        while (string.size() > 0)
            result.insert(0, string.pop());//3[a]2[bc]这种情况最后还要整合栈里的结果
        return result.toString();
    }
}//遇到麻烦的题请理性分析不要慌，么么哒～
