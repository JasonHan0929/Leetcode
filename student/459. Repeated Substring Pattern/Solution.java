public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        int[] next = calculateNext(str);
        int p = next[str.length()];
        return p > 0 && str.length() % (str.length() - p) == 0;// 若真的由循环构成，length - p恰好为循环结构的长度
    }
    public int[] calculateNext(String b) {
        int len = b.length();
        int[] next = new int[len + 1];
        int j = 0;
        next[0] = next[1] = 0;
        for (int i = 1; i < len; i++) {
            while (j > 0 && b.charAt(j) != b.charAt(i)) {
                j = next[j];
            }
            if (b.charAt(j) == b.charAt(i)) {
                next[i + 1] = ++j;
            }
        }
        return next;
    }
}//基于KPM解法，若为true，则一定有：记字符串长度为size，利用KMP算法求next数组，记next数组的最后一个元素为p，若p > 0 并且 size % (size - p) == 0（好像为false是不是一定不满足这个条件并不知道）
