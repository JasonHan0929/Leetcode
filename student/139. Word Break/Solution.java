public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len];
        HashSet<String> hash = new HashSet<>();
        for (String str : wordDict)
            hash.add(str);
        for (int i = 0; i < len; i++) {
            if (hash.contains(s.substring(0, i + 1))) {
                dp[i] = true;
                continue;
            }// corner condition, no need to initialize dp[0]
            for (int j = 0; j < i; j++) {
                if (dp[j] && hash.contains(s.substring(j + 1, i + 1))) {// the index relationship between i and j
                    dp[i] = true;                                       // substring is O(n)
                    break;
                }
            }
        }
        return dp[len - 1];
    }
}

/*
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] f = new boolean[s.length() + 1];//f[i] represent whether s[0...i - 1] could be breaked in to words in dect
        f[0] = true;
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}// easy way to contral index and deal with corner case
*/
