public class Solution {
    /*public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length())
            return -1;
        if (needle.length() == 0)
            return 0;
        int i = 0;
        int j = 0;
        int cur = i;
        int index = 0;
        while (i < haystack.length()) {
            cur = i;
            while (cur < haystack.length() && haystack.charAt(cur) == needle.charAt(j)) {
                j++;
                cur++;
                if (j == needle.length())
                    return i;
            }
            i++;
            j = 0;
        }
        return -1;
    }*/ //time limit exceeded, use i + j to replace cur will pass the case but still very slow
    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() < needle.length())
            return -1;
        if (needle.length() == 0)
            return 0;
        return search(haystack, needle, getNext(needle));
    }
    public int search(String haystack, String needle, int[] next) {
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j))
                j = next[j];
            if (haystack.charAt(i) == needle.charAt(j))
                j++;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;
    }
    public int[] getNext(String needle) {
        int[] next = new int[needle.length() + 1];
        next[0] = next[1] = 0;
        int j = next[1];
        for (int i = 1; i < next.length - 1; i++) {
            while (j > 0 && needle.charAt(j) != needle.charAt(i))
                j = next[j];
            next[i + 1] = needle.charAt(j) != needle.charAt(i) ? j : ++j;
        }
        return next;
    }
}//KMP time complexity is O(n+m) but it seems not very fast

public int strStr(String haystack, String needle) {
  for (int i = 0; ; i++) {
    for (int j = 0; ; j++) {
      if (j == needle.length()) return i;
      if (i + j == haystack.length()) return -1;// pay attention to this return. it helps to optimize this program
      if (needle.charAt(j) != haystack.charAt(i + j)) break;
    }
  }
}// clean and brutle force

