class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if (words == null || words.length == 0) return result;
        Trie trie = new Trie(words);
        List<String> temp = new ArrayList<>(words.length);
        for (String word : words) {            
            temp.add(word);
            dfs(result, temp, trie);
            temp.remove(temp.size() - 1);
        }
        return result;
    }
    
    private void dfs(List<List<String>> result, List<String> temp, Trie trie) {
        if (temp.size() == temp.get(0).length()) {
            result.add(new ArrayList<>(temp));
        } else {
            int index = temp.size();
            StringBuilder sb = new StringBuilder();
            for (String word : temp) sb.append(word.charAt(index));
            List<String> candidates = trie.findByPrefix(sb.toString());
            if (candidates == null) return;
            else {
                for (String candidate : candidates) {
                    temp.add(candidate);
                    dfs(result, temp, trie);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}

class Node {
    List<String> words = new ArrayList<>();
    Node[] next = new Node[26];   
}

class Trie {
    Node root = new Node();
    
    Trie(String[] words) {
        for (String word : words) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (cur.next[c - 'a'] == null) cur.next[c - 'a'] = new Node();
                cur = cur.next[c - 'a'];
                cur.words.add(word);
            }
        }
    }
    
    List<String> findByPrefix(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.next[c -'a'] == null) return null;
            else cur = cur.next[c - 'a'];
        }
        return cur.words;
    }
}

/*
Explained. My Java solution using Trie [126ms 16/16]
90
L lzb700m 
Reputation:  430
My first approach is brute-force, try every possible word sequences, and use the solution of Problem 422 (https://leetcode.com/problems/valid-word-square/) to check each sequence. This solution is straightforward, but too slow (TLE).

A better approach is to check the validity of the word square while we build it.
Example: ["area","lead","wall","lady","ball"]
We know that the sequence contains 4 words because the length of each word is 4.
Every word can be the first word of the sequence, let's take "wall" for example.
Which word could be the second word? Must be a word start with "a" (therefore "area"), because it has to match the second letter of word "wall".
Which word could be the third word? Must be a word start with "le" (therefore "lead"), because it has to match the third letter of word "wall" and the third letter of word "area".
What about the last word? Must be a word start with "lad" (therefore "lady"). For the same reason above.

The picture below shows how the prefix are matched while building the sequence.

0_1476809138708_wordsquare.png

In order for this to work, we need to fast retrieve all the words with a given prefix. There could be 2 ways doing this:

Using a hashtable, key is prefix, value is a list of words with that prefix.
Trie, we store a list of words with the prefix on each trie node.
The implemented below uses Trie.

public class Solution {
    class TrieNode {
        List<String> startWith;
        TrieNode[] children;

        TrieNode() {
            startWith = new ArrayList<>();
            children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;

        Trie(String[] words) {
            root = new TrieNode();
            for (String w : words) {
                TrieNode cur = root;
                for (char ch : w.toCharArray()) {
                    int idx = ch - 'a';
                    if (cur.children[idx] == null)
                        cur.children[idx] = new TrieNode();
                    cur.children[idx].startWith.add(w);
                    cur = cur.children[idx];
                }
            }
        }

        List<String> findByPrefix(String prefix) {
            List<String> ans = new ArrayList<>();
            TrieNode cur = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (cur.children[idx] == null)
                    return ans;

                cur = cur.children[idx];
            }
            ans.addAll(cur.startWith);
            return ans;
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<>();
        if (words == null || words.length == 0)
            return ans;
        int len = words[0].length();
        Trie trie = new Trie(words);
        List<String> ansBuilder = new ArrayList<>();
        for (String w : words) {
            ansBuilder.add(w);
            search(len, trie, ans, ansBuilder);
            ansBuilder.remove(ansBuilder.size() - 1);
        }

        return ans;
    }

    private void search(int len, Trie tr, List<List<String>> ans,
            List<String> ansBuilder) {
        if (ansBuilder.size() == len) {
            ans.add(new ArrayList<>(ansBuilder));
            return;
        }

        int idx = ansBuilder.size();
        StringBuilder prefixBuilder = new StringBuilder();
        for (String s : ansBuilder)
            prefixBuilder.append(s.charAt(idx));
        List<String> startWith = tr.findByPrefix(prefixBuilder.toString());
        for (String sw : startWith) {
            ansBuilder.add(sw);
            search(len, tr, ans, ansBuilder);
            ansBuilder.remove(ansBuilder.size() - 1);
        }
    }
}
*/
