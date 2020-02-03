public class Trie {
    private class TrieNode {
        boolean isEnd;
        TrieNode[] next;
        
        public TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
        }
    }
    
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0)
            return;
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (curr.next[letter - 'a'] == null)
                curr.next[letter- 'a'] = new TrieNode();
            curr = curr.next[letter - 'a'];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0)
            return false;
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (curr.next[letter - 'a'] == null)
                return false;
            curr = curr.next[letter - 'a'];
        }
        return curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0)
            return false;
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char letter = prefix.charAt(i);
            if (curr.next[letter - 'a'] == null)
                return false;
            curr = curr.next[letter - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
