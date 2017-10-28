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
            if (hash[sArray[right] - 'a'] > 0)
                count--;
            hash[sArray[right] - 'a']--;
            right++;
            while (count == 0) {
                if (right - left == s1.length())
                    return true;
                hash[sArray[left] - 'a']++;
                if (hash[sArray[left] - 'a'] > 0)
                    count++;
                left++;
            }
        }
        return false;
    }
}
/*
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[128];
        for(int i = 0; i < s1.length(); i++) count[s1.charAt(i)]--;
        for(int l = 0, r = 0; r < s2.length(); r++) {
            if (++count[s2.charAt(r)] > 0)
                while(--count[s2.charAt(l++)] != 0) { // do nothing }
            else if ((r - l + 1) == s1.length()) return true;
        }
        return s1.length() == 0;
    }
*/
