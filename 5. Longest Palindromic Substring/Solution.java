public class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - maxLen - 1, i)) {
                start = i - maxLen - 1;
                end = i;
                maxLen += 2;
            }
            else if (isPalindrome(s, i - maxLen, i)) {
                start = i - maxLen;
                end = i;
                maxLen += 1;
            }
        }
        return s.substring(start, end + 1);
    }
    public boolean isPalindrome(String s, int i, int j) {
        if (i < 0)
            return false;
        while (i < j) { // if i == j still return true
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}
/*
Key idea, every time we move to right, we only need to consider whether using this new character as tail could produce new palindrome string of length (current length +1) or (current length +2)

public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int currLength = 0;
        for(int i=0;i<s.length();i++){
            if(isPalindrome(s,i-currLength-1,i)){
                res = s.substring(i-currLength-1,i+1);
                currLength = currLength+2;
            }
            else if(isPalindrome(s,i-currLength,i)){
                res = s.substring(i-currLength,i+1);
                currLength = currLength+1;
            }
        }
        return res;
    }
    
    public boolean isPalindrome(String s, int begin, int end){
        if(begin<0) return false;
        while(begin<end){
        	if(s.charAt(begin++)!=s.charAt(end--)) return false;
        }
        return true;
    }
}
For friends who are confused about the key idea to check only new palindrome with length = current length +2 or +1, I add some more explanation here.

Example: "xxxbcbxxxxxa", (x is random character, not all x are equal) now we 
          are dealing with the last character 'a'. The current longest palindrome
          is "bcb" with length 3.
1. check "xxxxa" so if it is palindrome we could get a new palindrome of length 5.
2. check "xxxa" so if it is palindrome we could get a new palindrome of length 4.
3. do NOT check "xxa" or any shorter string since the length of the new string is 
   no bigger than current longest length.
4. do NOT check "xxxxxa" or any longer string because if "xxxxxa" is palindrome 
   then "xxxx" got  from cutting off the head and tail is also palindrom. It has 
   length > 3 which is impossible.'
*/