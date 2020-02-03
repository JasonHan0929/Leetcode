public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || s.length() != t.length())
            return false;
        int[] hash = new int[26]; 
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i) - 'a']++;
            hash[s.charAt(i) - 'a']--;
        }
        for (int num : hash) {
            if (num < 0)
                return false;
        }
        return true;
    }
}//之考虑小写字母用int[26]即可但是-‘a’让速度更慢了...
