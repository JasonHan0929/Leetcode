public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) 
            return new LinkedList<List<String>>();
        Map<String, List<String>> hash = new HashMap<>();
        String temp;
        char[] array;
        for (String string : strs) {
            array = string.toCharArray();
            Arrays.sort(array);
            temp = String.valueOf(array);
            if (!hash.containsKey(temp))
                hash.put(temp, new LinkedList<String>());
            hash.get(temp).add(string);
        }
        return new LinkedList<>(hash.values());
    }
}//once anagrams' characters are sorted by dictionary sequence, it could be used to distringuish anagram of different strings 
