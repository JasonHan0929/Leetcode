class Solution {
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }
        TriNode root = buildTriTree(words);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.next[board[i][j] - 'a'] != null) {
                    dfs(board, new boolean[board.length][board[0].length], new StringBuilder(), result, root.next[board[i][j] - 'a'], i, j);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] board, boolean[][] visited, StringBuilder temp, List<String> result, TriNode cur, int i, int j) {
        visited[i][j] = true;  
        char value = board[i][j];
        temp.append(value);
        if (cur.isEnd) {
            result.add(temp.toString());
            cur.isEnd = false;
         }
        for (int[] dir : direction) {
            int nextI = i + dir[0], nextJ = j + dir[1];
            if (nextI >= 0 && nextI < board.length && nextJ >= 0 && nextJ < board[0].length && !visited[nextI][nextJ] && cur.next[board[nextI][nextJ] - 'a'] != null) {
                dfs(board, visited, temp, result, cur.next[board[nextI][nextJ] - 'a'], nextI, nextJ);
            }
        }
        visited[i][j] = false; //  复原visited
        if (temp.length() > 0) {
            temp.deleteCharAt(temp.length() - 1);
        }
        return;
    }

    private TriNode buildTriTree(String[] words) {
        TriNode root = new TriNode('0', false);
        for (String word : words) {
            TriNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char value = word.charAt(i);
                if (cur.next[value - 'a'] == null) {
                    cur.next[value - 'a'] = new TriNode(value);
                }
                cur = cur.next[value - 'a'];
            }
            cur.isEnd = true;
        }
        return root;
    }
}

class TriNode {
    TriNode[] next;
    char value;
    boolean isEnd;

    TriNode(char value, boolean isEnd) {
        this.next = new TriNode[26];
        this.value = value;
        this.isEnd = isEnd;
    }

    TriNode(char value) {
        this.next = new TriNode[26];
        this.value = value;
    }

    public String toString() {
        return String.format("value: %c, isEnd: %b", value, isEnd);
    }
}
