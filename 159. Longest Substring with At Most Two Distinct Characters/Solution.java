class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int result = Integer.MIN_VALUE;
        int length = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            if (map.containsKey(cur))  {
                map.put(cur, map.get(cur) + 1);
                length++;
            } else {
                if (map.size() == 2) {
                    result = Math.max(length, result);
                    while (map.size() == 2) {
                        if (map.get(s.charAt(left)) == 1) {
                            map.remove(s.charAt(left));
                        } else {
                            map.put(s.charAt(left), map.get(s.charAt(left)) -1);
                        }
                        length--;
                        left++;
                    }
                }
                map.put(cur, 1);
                length++;
            }
            right++;
        }
        return Math.max(result, length);
    }
}
