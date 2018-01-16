class Solution {
    public List<String> wordsAbbreviation(List<String> dict) {
        List<String> result = new ArrayList<>(Collections.nCopies(dict.size(), null));
        Map<String, List<Integer>> group = new HashMap<>();
        for (int i = 0; i < dict.size(); i++) {
            String word = dict.get(i);
            String key = getGroupKey(word);
            if (!group.containsKey(key)) group.put(key, new ArrayList<>());
            group.get(key).add(i);
        }
        for (Map.Entry<String, List<Integer>> entry : group.entrySet()) {
            String key = entry.getKey();
            List<Integer> pos = entry.getValue();
            if (pos.size() == 1) result.set(pos.get(0), key);
            else {
                Node root = buildTrie(dict, pos);
                parseTrie(root, result, pos, dict);
            }
        }
        return result;
    }
    private String getGroupKey(String word) {
        if (word.length() <= 3) return word;
        return word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
    }
    private Node buildTrie(List<String> dict, List<Integer> pos) {
        Node root = new Node();
        for (int index : pos) {
            char[] word = dict.get(index).toCharArray();
            Node cur = root;
            for (int i = 0; i < word.length; i++) {
                if (!cur.next.containsKey(word[i])) cur.next.put(word[i], new Node());
                cur = cur.next.get(word[i]);
                cur.count++;
            }
        }
        return root;
    }
    private void parseTrie(Node root, List<String> result, List<Integer> pos, List<String> dict) {
        for (int index : pos) {
            String word = dict.get(index);
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                cur = cur.next.get(word.charAt(i));
                if (cur.count == 1) {
                    if (i >= word.length() - 3) result.set(index, word);
                    else result.set(index, word.substring(0, i + 1) + String.valueOf(word.length() - i - 2) + word.charAt(word.length() - 1));
                    break;
                }
            }
        }
    }
}

class Node {
    int count = 0;
    Map<Character, Node> next = new HashMap<>();
}

/*
The basic idea is to group all conflicted words, and then resolve the conflicts using Trie. The time complexity will be O(nL) for building trie, O(nL) to resolve conflicts, O(n) to group words. So the time complexity will be O(n(2L + 1). n is the number of words, and L is the average length of each words.

I added the comments in code, so you can directly see the code. Please correct me if I make some mistakes and welcome to make my code concise.

public class Solution {
    
    public List<String> wordsAbbreviation(List<String> dict) {
        Map<String, List<Integer>> abbrMap = new HashMap<>();
        // 1) create result set
        List<String> res = new ArrayList<>(Collections.nCopies(dict.size(), null));
        // 2) Group all words with the same shortest abbreviation. For example:
        // "internal", "interval" => grouped by "i6l"
        // "intension", "intrusion" => grouped by "i7n"
        // "god" => grouped by "god"
        // we can notice that only words with the same length and the same start
        // and end letter could be grouped together
        for (int i = 0; i < dict.size(); i ++) {
            String word = dict.get(i);
            String st = getShortestAbbr(word);
            List<Integer> pos = abbrMap.get(st);
            if (pos == null) {
                pos = new ArrayList<>();
                abbrMap.put(st, pos);
            }
            pos.add(i);
        }
        // 3) Resolve conflicts in each group
        for (Map.Entry<String, List<Integer>> entry : abbrMap.entrySet()) {
            String abbr = entry.getKey();
            List<Integer> pos = entry.getValue();
            resolve(dict, res, abbr, pos);
        }
        return res;
    }
    
    //To resolve conflicts in a group, we could build a trie for all the words
    //in the group. The trie node will contain the count of words that has the
    //same prefix. Then we could use this trie to determine when we could resolve
    //a conflict by identifying that the count of words in that trie node will only
    //have one word has the prefix.     
    private void resolve(List<String> dict, List<String> res, String abbr, List<Integer> pos) {
        if (pos.size() == 1) {
            res.set(pos.get(0), abbr);
        } else {
            Trie trie = buildTrie(dict, pos);
            for (int p : pos) {
                String w = dict.get(p);
                Trie cur = trie;
                int i = 0;
                int n = w.length();
                // while loop to find the trie node which only has the 1 word which has
                // the prefix. That means in that position, only current word has that
                // specific character.
                while (i < n && cur.next.get(w.charAt(i)).cnt > 1) {
                    cur = cur.next.get(w.charAt(i));
                    i ++;
                }
                if (i >= n - 3) {
                    res.set(p, w);
                } else {
                    String pre = w.substring(0, i+1);
                    String st = pre + (n - i - 2) + "" + w.charAt(n - 1);
                    res.set(p, st);
                }
            }
        }
    }
    
    //Get the shortest abbreviation for a word 
    private String getShortestAbbr(String s) {
        if (s.length() <= 3) {
            return s;
        } else {
            return s.charAt(0) + "" + (s.length() - 2) + "" + s.charAt(s.length() - 1);
        }
    }
    
    //Standard way to build the trie, but we record each trie node with the information
    //of the count of words with the same prefix.
    private Trie buildTrie(List<String> dict, List<Integer> pos) {
        Trie root = new Trie();
        for (int p : pos) {
            String w = dict.get(p);
            Trie cur = root;
            for (int i = 0; i < w.length(); i ++) {
                char c = w.charAt(i);
                if (cur.next.containsKey(c)) {
                    cur = cur.next.get(c);
                } else {
                    Trie next = new Trie();
                    cur.next.put(c, next);
                    cur = next;
                }
                cur.cnt ++;
            }
        }
        return root;
    }
    
    private class Trie {
        int cnt = 0;
        Map<Character, Trie> next = new HashMap<>();
    }
}
*/
