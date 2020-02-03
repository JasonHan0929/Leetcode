class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;
        char[] sArray = s2.toCharArray();
        int[] hash = new int[26];
        int left = 0, right = 0;
        int count = s1.length();
        for (char c : s1.toCharArray())
            hash[c - 'a']++;
        while (right < sArray.length) {
            if (hash[sArray[right] - 'a'] > 0) {
                count--;
                if (count == 0)
                    return true;
            }
            hash[sArray[right] - 'a']--;
            while (right < sArray.length && hash[sArray[right] - 'a'] < 0) {
                hash[sArray[left] - 'a']++;
                if (hash[sArray[left] - 'a'] > 0)
                    count++;
                left++;
            }
            right++;
        }
        return false;
    }
}
