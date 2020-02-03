public class WordDictionary {
    private class TrieNode {
        TrieNode[] next;
        boolean isEnd;
        
        TrieNode() {
            next = new TrieNode[26];
            isEnd = false;
        }
    }
    
    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() == 0)
            return;
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (curr.next[letter - 'a'] == null)
                curr.next[letter - 'a'] = new TrieNode();
            curr = curr.next[letter - 'a'];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.length() == 0)
            return false;
        return dfs(root, word, 0);
    }
    
    public boolean dfs(TrieNode root, String word, int index) {
        if (root.isEnd && index == word.length())// idnex == length() is used to pass the case where you add("a") but search("aa")
            return true;
        else if (index > word.length())
            return false;
        else if (word.charAt(index) == '.') {
            for (TrieNode node : root.next) {
                if (node != null) {
                    if (dfs(node, word, index + 1))
                        return true;
                }
            }
        } else if (root.next[word.charAt(index) - 'a'] != null)
            return dfs(root.next[word.charAt(index) - 'a'], word, index + 1);
        return false;
    }
}//dfs

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

/*
public class WordDictionary {
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isWord = false;
    }
    TrieNode root = new TrieNode();
    public void addWord(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            if (p.child[c - 'a'] == null) p.child[c - 'a'] = new TrieNode();
            p = p.child[c - 'a'];
        }
        p.isWord = true;
    }

    public boolean search(String word) {
        return helper(word, 0, root);
    }
    
    private boolean helper(String s, int index, TrieNode p) {
        if (index >= s.length()) return p.isWord;
        char c = s.charAt(index);
        if (c == '.') {
            for (int i = 0; i < p.child.length; i++)
                if (p.child[i] != null && helper(s, index + 1, p.child[i]))
                    return true;
            return false;
        } else return (p.child[c - 'a'] != null && helper(s, index + 1, p.child[c - 'a']));
    }
}
*/
