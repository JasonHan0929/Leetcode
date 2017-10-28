class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        int[] window = new int[2];
        char[] sArray = s.toCharArray();
        int[] hash = new int[256];
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int count = t.length();
        for (char c : t.toCharArray())
            hash[c]++;
        while (right < s.length()) {
            if (hash[sArray[right]] > 0)
                count--;
            hash[sArray[right]]--;
            right++;
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    window[0] = left;
                    window[1] = right;
                }
                hash[sArray[left]]++;
                if (hash[sArray[left]] > 0)
                    count++;
                left++;
            }
        }
        return s.substring(window[0], window[1]);
    }
}

/*
public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] hash = new int[256];
        char[] chs = s.toCharArray(), cht = t.toCharArray();
        for (char c : cht) {
            hash[c]++;
        }
        int[] res = new int[2];
        int lo = 0, hi = 0, count = cht.length, minLen = Integer.MAX_VALUE;
        while (hi < chs.length) {
            char c = chs[hi];
            if (hash[c] >= 1) {
                count--;
            }
            hash[c]--;
            hi++;

            while (count == 0) {
                if (hi - lo < minLen) {
                    minLen = hi - lo;
                    res[0] = lo;
                    res[1] = hi;
                }
                char prev = chs[lo++];
                if (hash[prev]++ >= 0) count++;
            }
        }
        return s.substring(res[0], res[1]);
    }
}
*/
