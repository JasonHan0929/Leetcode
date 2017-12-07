class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() < t.length()) {
            return isOneEditDistance(t, s); // suppose s.length() >= t.length
        }
        if (s.length() > t.length() + 1) return false;
        int currS = 0, currT = 0;
        boolean firstTime = true;
        while (currS < s.length()) {
            if (currT == t.length()) return firstTime && currS == s.length() - 1; // firstTime should be used
            if (s.charAt(currS) != t.charAt(currT)) {
                if (!firstTime) return false;
                firstTime = false;
                if (s.length() > t.length()) currT--; // not currS++
            }
            currS++;
            currT++;
        }
        return !firstTime;
    }
}
