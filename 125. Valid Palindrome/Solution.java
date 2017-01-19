public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;
        s = s.toLowerCase();
        StringBuilder pre = new StringBuilder();
        StringBuilder post = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int tempPre = s.charAt(i);
            if (tempPre <= 'z' && tempPre >= 'a' || tempPre <= '9' && tempPre >= '0')
                pre.append(tempPre);
            int tempPost = s.charAt(len - i - 1);
            if (tempPost <= 'z' && tempPost >= 'a' || tempPost <= '9' && tempPost >= '0')
                post.append(tempPost);
        }
        return pre.toString().equals(post.toString());
    }
}//using StringBuilder is very slow
public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;
        int pre = 0, post = s.length() - 1;
        char preChar, postChar;
        while (pre <= post) {
            preChar = s.charAt(pre);
            postChar = s.charAt(post);
            if (!Character.isLetterOrDigit(preChar))//pay attention to how to use the static method of Character
                pre++;
            else if (!Character.isLetterOrDigit(postChar))
                post--;
            else {
                if (Character.toLowerCase(preChar) != Character.toLowerCase(postChar))
                    return false;
                post--;
                pre++;
            }
        }
        return true;
    }
}
