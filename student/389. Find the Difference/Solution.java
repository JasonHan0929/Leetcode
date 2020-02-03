public class Solution {
    public char findTheDifference(String s, String t) {
        int[] hash = new int[256];
        char result = ' ';
        for (char chr : s.toCharArray())//注意string不能直接for-each
            hash[chr]++;
        for (char chr : t.toCharArray()) {
            if (--hash[chr] < 0 ) {//注意不要{}总是忘写
                result = chr;
                return result;
            }
        }
        return result;
    }
}

public class Solution {
    public char findTheDifference(String s, String t) {
        char ans = 0;
        for (int i = 0; i < s.length(); i++) {
        	ans ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
        	ans ^= t.charAt(i);
        }
        return ans;
    }
}//用抑或求唯一不同
