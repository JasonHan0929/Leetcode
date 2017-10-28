class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (right >= left) {
            if (s.charAt(left) != s.charAt(right))
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            left++;
            right--;
        }
        return true;
    }
    public boolean isPalindrome(String s, int left, int right) {
        if (right < left)
            return false;
        while (right >= left) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            right--;
            left++;
        }
        return true;
    }
}
/*
public boolean validPalindrome(String s) {
    int l = -1, r = s.length();
    while (++l < --r) 
        if (s.charAt(l) != s.charAt(r)) return isPalindromic(s, l, r+1) || isPalindromic(s, l-1, r);
    return true;
}

public boolean isPalindromic(String s, int l, int r) {
    while (++l < --r) 
        if (s.charAt(l) != s.charAt(r)) return false;
    return true;
}
*/
