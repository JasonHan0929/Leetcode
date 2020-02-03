class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        Map<Character, Integer> degree = new HashMap<>();
        Map<Character, Set<Character>> children = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            for (char c : word.toCharArray()) degree.put(c, 0);
        }
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            for (int j = 0; j < Math.min(cur.length(), next.length()); j++) {
                char curChar = cur.charAt(j), nextChar = next.charAt(j);
                if (curChar != nextChar) {
                    if (!children.containsKey(curChar)) children.put(curChar, new HashSet<>());
                    if (children.get(curChar).add(nextChar)) degree.put(nextChar, degree.getOrDefault(nextChar, 0) + 1);
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : degree.entrySet()) {
            if (entry.getValue() == 0) queue.offer(entry.getKey());
        }
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            result.append(cur);
            if (!children.containsKey(cur)) continue;
            for (char next : children.get(cur)) {
                degree.put(next, degree.get(next) - 1);
                if (degree.get(next) == 0) queue.offer(next);
            }
        }
        return degree.size() == result.length() ? result.toString() : "";
    }
}// bfs
