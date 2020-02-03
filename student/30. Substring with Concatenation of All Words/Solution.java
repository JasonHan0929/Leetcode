class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int size = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        List<Integer> result = new ArrayList<>();
        int count = words.length;
        for (int i = 0; i < size; i++) {
            int left = i, right = i;
            while (right <= s.length() - size) {
                String tempR = s.substring(right, right + size);
                if (!map.containsKey(tempR)) {
                    right += size;
                    while (left != right) {
                        String tempL = s.substring(left, left + size);
                        if (map.containsKey(tempL)) {
                            map.put(tempL, map.get(tempL) + 1);
                            count++;
                        }
                        left += size;
                    }
                    continue;
                }
                while (map.get(tempR) <= 0) {
                    String tempL = s.substring(left, left + size);
                    map.put(tempL, map.get(tempL) + 1);
                    left += size;
                    count++;
                }
                if (map.get(tempR) > 0) {
                    count--;
                    map.put(tempR, map.get(tempR) - 1);
                    if (count == 0)
                        result.add(left);
                }
                right += size;
            }
            while (left != right) {
                String tempL = s.substring(left, left + size);
                if (map.containsKey(tempL)) {
                    map.put(tempL, map.get(tempL) + 1);
                    count++;
                }
                left += size;
            }
        }
        return result;
    }
}
