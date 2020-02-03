
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() < p.length()) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0) {
                    map.remove(cur);
                    if (map.isEmpty()) result.add(left);
                }
                right++;
                continue;
            }
            while (!map.containsKey(cur)) {
                if (left == right) {
                    left++;
                    right++;
                    break;
                }
                if (map.containsKey(s.charAt(left))) map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                else map.put(s.charAt(left), 1);
                left++;
            }
        }
        return result;
    }
}

//https://discuss.leetcode.com/topic/68976/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem

/*
public class Solution {
    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        
        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;
        
        
        while(end < s.length()){
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;
            
            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                if(end-begin == t.length()){
                    result.add(begin);
                }
                begin++;
            }
            
        }
        return result;
    }
}
*/
