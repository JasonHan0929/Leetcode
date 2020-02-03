class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] temp = word.toCharArray();
            Arrays.sort(temp);
            String anagram = new String(temp);
            if (!map.containsKey(anagram)) {
                map.put(anagram, new ArrayList<>());
            }
            map.get(anagram).add(word);
        }
        return new ArrayList<>(map.values());
    }
}

/*
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (String word : strs) {
            Map<Character, Integer> count = new HashMap<>();
            for (char c : word.toCharArray()) {
                count.put(c, count.getOrDefault(c, 0) + 1);
            }
            if (!map.containsKey(count)) {
                map.put(count, new ArrayList<>());
            }
            map.get(count).add(word);
        }
        return new ArrayList<>(map.values());
    }
} // exceed time limit
*/

/*
public int getID(String s){
        int[] counter   =   new int[26];
        for(char ch : s.toCharArray()){
            counter[ch - 'a']++;
        }
        
        return Arrays.hashCode(counter);    //use the counter array's hash code as this anagram's ID
    } // will have a collision?
    
    //solution takes 18ms
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups   =   new ArrayList<>();
        Map<Integer, List<String>> anagramMap   =   new HashMap<>();
        
        for(String word : strs){
            int id   =   getID(word);   //unique for each anagram
            List<String> group  =   anagramMap.get(id);
            
            if(null == group){
                group  =   new ArrayList();
                anagramMap.put(id, group);
           
            }
            
            group.add(word);
        }
        
        groups.addAll(anagramMap.values());
        
        return groups;
    }
*/
