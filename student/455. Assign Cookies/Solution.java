public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = g.length - 1, j = s.length - 1; i >= 0 && j >= 0;) {
            if (g[i] <= s[j]) {
                count++;
                j--;
            }
            i--;
        }
        return count;
    }
}//or you could use binary search tree
/*
Greedy

Arrays.sort(g);
Arrays.sort(s);
int i = 0;
for(int j=0;i<g.length && j<s.length;j++) {
	if(g[i]<=s[j]) i++;
}
return i;
Just assign the cookies starting from the child with less greediness to maximize the number of happy children .
*/
