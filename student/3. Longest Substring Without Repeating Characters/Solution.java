public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();
        int max = 1;
        int left = 0;
        int right = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(left));
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            else {
                max = Math.max(max, right - left);
                set.remove(s.charAt(left));
                left++;
            }
        }
        return Math.max(max, set.size());//s = "au"
    }
}
