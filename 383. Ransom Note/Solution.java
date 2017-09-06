class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>(ransomNote.length());
        for (int i = 0; i < ransomNote.length(); i++)
            map.put(ransomNote.charAt(i), map.getOrDefault(ransomNote.charAt(i), 0) + 1);
        for (int i = 0; i < magazine.length(); i++) {
            char temp = magazine.charAt(i);
            if (map.containsKey(temp)) {
                if (map.get(temp) == 1)
                    map.remove(temp);
                else
                    map.put(temp, map.get(temp) - 1);
            }
        }
        return map.isEmpty();
    }
}

/*
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
*/
