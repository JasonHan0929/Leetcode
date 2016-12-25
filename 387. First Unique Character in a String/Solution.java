public class Solution {
    public int firstUniqChar(String s) {
        int[] bucket = new int[26];
        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {//注意不是bucket[i]，不是按统计好后容器的顺序，而且是s中出现的顺序
            if (bucket[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}//hashmap也可以
public class Solution {
	public static int firstUniqChar(String s) {
        
		char[] a = s.toCharArray();
		
		for(int i=0; i<a.length;i++){
			if(s.indexOf(a[i])==s.lastIndexOf(a[i])){return i;}
		}
		return -1;
    	}
}//简洁做法
