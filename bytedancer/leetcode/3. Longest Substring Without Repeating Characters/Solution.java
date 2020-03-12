class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] array = s.toCharArray();
        int result = 0;
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        while (right < array.length) {
            if (set.contains(array[right])) {
                result = Math.max(right - left, result);
                while (left < right) {
                    if (array[left] == array[right]) {
                        right++;
                        left++;
                        result = Math.max(right - left, result);
                        break;
                    } else {
                        set.remove(array[left]);
                        left++;
                    }
                }
            } else {
                set.add(array[right]);
                right++;
                result = Math.max(right - left, result);
            }
        }
        return result;
    }
}
