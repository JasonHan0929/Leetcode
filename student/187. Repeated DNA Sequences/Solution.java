public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new LinkedList<>();
        if (s.length() <= 10)
            return result;
        HashMap<String,Integer> map = new HashMap<>();//to prevent add the same substring twice in the result list, using a hashmap to count the times the substring appears rather than just using a hashset
        for (int i = 0; i < s.length() - 9; i++) {
            String curr = s.substring(i, i + 10);
            if (map.containsKey(curr) && map.get(curr) == 1)
                result.add(curr);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return result;
    }
}

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set seen = new HashSet(), repeated = new HashSet();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten))
                repeated.add(ten);
        }
        return new ArrayList(repeated);
    }
}//faster than hashmap

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> words = new HashSet<>();
        Set<Integer> doubleWords = new HashSet<>();
        List<String> rv = new ArrayList<>();
        char[] map = new char[26];
        //map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
    
        for(int i = 0; i < s.length() - 9; i++) {
            int v = 0;
            for(int j = i; j < i + 10; j++) {//calculate the hash code for each substring
                v <<= 2;
                v |= map[s.charAt(j) - 'A'];
            }
            if(!words.add(v) && doubleWords.add(v)) {
                rv.add(s.substring(i, i + 10));
            }
        }
        return rv;
    }
}//bit manipulation, more fast
