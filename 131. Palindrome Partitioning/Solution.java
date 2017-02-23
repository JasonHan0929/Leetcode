public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(s, 0, 0, new ArrayList<>(), result);
        return result;
    }
    public void dfs(String s, int start, int pIndex, List<String> temp, List<List<String>> result) {
        if (pIndex == s.length())
            result.add(new ArrayList<>(temp));
        for (int i = 1; i <= s.length() - start; i++) {
            String p = s.substring(start, start + i);
            if (p.equals(new StringBuilder(p).reverse().toString())) {
                temp.add(p);
                dfs(s, start + p.length(), pIndex + p.length(), temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }
}//only backtracing

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int[][] mem = new int[s.length()][s.length()];
        dfs(s, 0, 0, new ArrayList<>(), result, mem);
        return result;
    }
    public void dfs(String s, int start, int pIndex, List<String> temp, List<List<String>> result, int[][] mem) {
        if (pIndex == s.length())
            result.add(new ArrayList<>(temp));
        for (int i = 1; i <= s.length() - start; i++) {
            String p = s.substring(start, start + i);
            if (mem[start][start + i - 1] == 0)
                mem[start][start + i - 1] = p.equals(new StringBuilder(p).reverse().toString()) ? 1 : -1;
            if (mem[start][start + i - 1] == 1) {
                temp.add(p);
                dfs(s, start + p.length(), pIndex + p.length(), temp, result, mem);
                temp.remove(temp.size() - 1);
            }
        }
    }
}//using a little bit memoization

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int[][] mem = new int[s.length()][s.length()];//not really useful
        dfs(s, 0, 0, new ArrayList<>(), result, mem);
        return result;
    }
    public void dfs(String s, int start, int pIndex, List<String> temp, List<List<String>> result, int[][] mem) {
        if (pIndex == s.length())
            result.add(new ArrayList<>(temp));
        for (int i = 1; i <= s.length() - start; i++) {
            if (mem[start][start + i - 1] == 0)
                mem[start][start + i - 1] = isPalindrome(s, start, start + i - 1) ? 1 : -1;
            if (mem[start][start + i - 1] == 1) {
                temp.add(s.substring(start, start + i));
                dfs(s, start + i, pIndex + i, temp, result, mem);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String str, int l, int r){
	    if(l==r) return true;
	    while(l<r){
	        if(str.charAt(l)!=str.charAt(r)) return false;
	        l++;r--;
	    }
	    return true;
	}// a little bit faster
}

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int[][] mem = new int[s.length()][s.length()];
        dfs(s, 0, new ArrayList<>(), result, mem);
        return result;
    }
    public void dfs(String s, int start, List<String> temp, List<List<String>> result, int[][] mem) {
        if (start == s.length())
            result.add(new ArrayList<>(temp));
        for (int i = 1; i <= s.length() - start; i++) {
            if (mem[start][start + i - 1] == 0)
                mem[start][start + i - 1] = isPalindrome(s, start, start + i - 1) ? 1 : -1;
            if (mem[start][start + i - 1] == 1) {
                temp.add(s.substring(start, start + i));
                dfs(s, start + i, temp, result, mem);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String str, int l, int r){
	    if(l==r) return true;
	    while(l<r){
	        if(str.charAt(l)!=str.charAt(r)) return false;
	        l++;r--;
	    }
	    return true;
	}
}//no need to pIndex and faster

/*
The normal dfs backtracking will need to check each substring for palindrome, but a dp array can be used to record the possible break for palindrome before we start recursion.

Edit:
Sharing my thought process:
first, I ask myself that how to check if a string is palindrome or not, usually a two point solution scanning from front and back. Here if you want to get all the possible palindrome partition, first a nested for loop to get every possible partitions for a string, then a scanning for all the partitions. That's a O(n^2) for partition and O(n^2) for the scanning of string, totaling at O(n^4) just for the partition. However, if we use a 2d array to keep track of any string we have scanned so far, with an addition pair, we can determine whether it's palindrome or not by justing looking at that pair, which is this line if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])). This way, the 2d array dp contains the possible palindrome partition among all.

second, based on the prescanned palindrome partitions saved in dp array, a simple backtrack does the job.

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
            }
        }
        helper(res, new ArrayList<>(), dp, s, 0);
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> path, boolean[][] dp, String s, int pos) {
        if(pos == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = pos; i < s.length(); i++) {
            if(dp[pos][i]) {
                path.add(s.substring(pos,i+1));
                helper(res, path, dp, s, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
*/