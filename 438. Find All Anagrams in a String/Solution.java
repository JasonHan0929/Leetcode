public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int left = 0;
        int right = 0;
        int count = p.length();
        List<Integer> result = new ArrayList<>();
        int[] hashmap = new int[256];
        for (char character : p.toCharArray())
            hashmap[character]++;
        while (right < s.length()) {
            if (hash[s.charAt(right++)]-- >= 1)
                count--;
            if (count == 0)
                result.add(left);
            if (right - left == p.length() && hash[s.charAt(left++)]++ >=0)
                count++;
        }
        return result;
    }
}
