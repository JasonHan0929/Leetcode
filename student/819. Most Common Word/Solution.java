class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] parsed = paragraph.replaceAll("[!?',;.]", "").toLowerCase().split(" "); // pay attention to how to use regex here
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet(Arrays.asList(banned));
        for (String word : parsed) {
            if (!set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        return Collections.max(map.entrySet(), (x, y) -> Integer.compare(x.getValue(), y.getValue())).getKey(); // pay attention to how to use Collections.max here
    }
}

/*
    public String mostCommonWord(String p, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        String[] words = p.replaceAll("\\pP" , "").toLowerCase().split("\\s+");
        for (String w : words) if (!ban.contains(w)) count.put(w, count.getOrDefault(w, 0) + 1);
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
*/
