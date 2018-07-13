class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) return result;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(
            k, 
            (x, y) -> Integer.compare(x.getValue(), y.getValue()) == 0 ? y.getKey().compareTo(x.getKey()) : Integer.compare(x.getValue(), y.getValue())
        ); // minHeap for frequency but maxHeap for alphabetic order
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (heap.size() >= k) {
                if (entry.getValue() > heap.peek().getValue() || 
                    entry.getValue() == heap.peek().getValue() && 
                    entry.getKey().compareTo(heap.peek().getKey()) < 0) {
                    heap.poll();
                    heap.add(entry);
                }
            } else {
                heap.add(entry);
            }
        }
        while (!heap.isEmpty()) {
            result.add(heap.poll().getKey());
        }
        Collections.reverse(result);
        return result;
    }
}

/*
This problem is quite similar to the problem Top K Frequent Elements. You can refer to this post for the solution of the problem.

We can solve this problem with the similar idea:
Firstly, we need to calculate the frequency of each word and store the result in a hashmap.

Secondly, we will use bucket sort to store words. Why? Because the minimum frequency is greater than or equal to 1 and the maximum frequency is less than or equal to the length of the input string array.

Thirdly, we can define a trie within each bucket to store all the words with the same frequency. With Trie, it ensures that the lower alphabetical word will be met first, saving the trouble to sort the words within the bucket.

From the above analysis, we can see the time complexity is O(n).
Here is my code:

public List<String> topKFrequent(String[] words, int k) {
        // calculate frequency of each word
        Map<String, Integer> freqMap = new HashMap<>();
        for(String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        // build the buckets
        TrieNode[] count = new TrieNode[words.length + 1];
        for(String word : freqMap.keySet()) {
            int freq = freqMap.get(word);
            if(count[freq] == null) {
                count[freq] = new TrieNode();
            }
            addWord(count[freq], word);
        }
        // get k frequent words
        List<String> list = new LinkedList<>();
        for(int f = count.length - 1; f >= 1 && list.size() < k; f--) {
            if(count[f] == null) continue;
            getWords(count[f], list, k);
        }
        return list;
    }
    
    private void getWords(TrieNode node, List<String> list, int k) {
        if(node == null) return;
        if(node.word != null) {
            list.add(node.word);
        }
        if(list.size() == k) return;
        for(int i = 0; i < 26; i++) {
            if(node.next[i] != null) {
                getWords(node.next[i], list, k);
            }
        }
    }
    
    private boolean addWord(TrieNode root, String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.next[c - 'a'] == null) {
                curr.next[c - 'a'] = new TrieNode();
            }
            curr = curr.next[c - 'a'];
        }
        curr.word = word;
        return true;
    }
    
    class TrieNode {
        TrieNode[] next;
        String word;
        TrieNode() {
            this.next = new TrieNode[26];
            this.word = null;
        }
    }
*/
