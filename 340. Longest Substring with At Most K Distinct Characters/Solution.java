class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() <= 0 || k == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int count = 0;
        int max = 0;
        while (right < s.length()) {
            while (right < s.length()) {
                if (!map.containsKey(s.charAt(right))) {
                    if (count == k) break;
                    count++;
                    map.put(s.charAt(right), 1);
                } else map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
                right++;
            }
            max = Math.max(max, right - left);
            while (count >= k && right < s.length()) {
                int num = map.get(s.charAt(left));
                if (num == 1) {
                    count--;
                    map.remove(s.charAt(left));
                } else map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
        }
        return max;
    }
} // slide window, very slow

/*
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(i++)] > 0);
                num--;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}// fast
*/

