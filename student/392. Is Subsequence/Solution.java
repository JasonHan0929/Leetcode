public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() != 0 && t.length() == 0)
            return false;
        if (s.length() == 0)
            return true;
        int indexs = 0;
        for (char chr : t.toCharArray()) {
            if (chr == s.charAt(indexs))
                indexs++;
            if (indexs == s.length())
                return true;
        }
        return false;
    }
}//用队列代替指针也可以
