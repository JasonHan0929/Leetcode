public class Solution {
    /*
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public List<String> wordSearchII(char[][] board, List<String> words) {
        Trie trie = new Trie(board, words);
        trie.find();
        return trie.result;
    }
    
}

class Node {
    
    int index;
    Node[] next;
    
    Node() {
        index = -1;
        next = new Node[26];
    }
}

class Trie {
    
    final Node root;
    final int[] movesI;
    final int[] movesJ;
    final List<String> words;
    final char[][] board;
    final List<String> result;
    
    Trie(char[][] board, List<String> words) {
        root = new Node();
        movesI = new int[]{-1, 1, 0, 0};
        movesJ = new int[]{0, 0, -1, 1}; // up, down, left, right
        this.board = board;
        this.words = words;
        result = new ArrayList<>();
    }
    
    private void insert(String word, int i) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.next[index] == null) {
                curr.next[index] = new Node();
            }
            curr = curr.next[index];
        }
        curr.index = i;
    }
    
    void find() {
        for (int i = 0; i < words.size(); i++) {
            insert(words.get(i), i);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(root.next[board[i][j] - 'a'], i, j, visited);
                visited[i][j] = false;
            }
        }
    }
    
    private void dfs(Node curr, int i, int j, boolean[][] visited) {
        if (curr == null) return;
        visited[i][j] = true;
        if (curr.index >= 0) {
            result.add(words.get(curr.index));
            curr.index = -1;// to deal with duplicate result
        }
        for (int k = 0; k < movesI.length; k++) {
            int nextI = i + movesI[k];
            int nextJ = j + movesJ[k];
            if (nextI >= 0 && nextI < board.length && nextJ >= 0 && nextJ < board[0].length && !visited[nextI][nextJ]) {
                dfs(curr.next[board[nextI][nextJ] - 'a'], nextI, nextJ, visited);
                visited[nextI][nextJ] = false;
            }
        }
    }
}
