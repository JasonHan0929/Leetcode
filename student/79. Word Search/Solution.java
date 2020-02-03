public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0, visited))
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (i >= 0 && j >= 0 && i < board.length && j < board[0].length && !visited[i][j] && index < word.length() && board[i][j] == word.charAt(index)) {
            visited[i][j] = true;
            index++;
            if (index == word.length())
                return true;
            if (dfs(board, word, i - 1, j, index, visited))
                return true;
            if (dfs(board, word, i, j - 1, index, visited))
                return true;
            if (dfs(board, word, i + 1, j, index, visited))
                return true;
            if (dfs(board, word, i, j + 1, index, visited))
                return true;
            visited[i][j] = false;
        }
        return false;
    }
}
/*
Here accepted solution based on recursion. To save memory I decuded to apply bit mask for every visited cell. Please check board[y][x] ^= 256;

public boolean exist(char[][] board, String word) {
    char[] w = word.toCharArray();
    for (int y=0; y<board.length; y++) {
    	for (int x=0; x<board[y].length; x++) {
    		if (exist(board, y, x, w, 0)) return true;
    	}
    }
    return false;
}

private boolean exist(char[][] board, int y, int x, char[] word, int i) {
	if (i == word.length) return true;
	if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
	if (board[y][x] != word[i]) return false;
	board[y][x] ^= 256;
	boolean exist = exist(board, y, x+1, word, i+1)
		|| exist(board, y, x-1, word, i+1)
		|| exist(board, y+1, x, word, i+1)
		|| exist(board, y-1, x, word, i+1);
	board[y][x] ^= 256;
	return exist;
}
*/
//It is O(4^n) since we are recursively traversing the 4 adjacent cells at each step.
