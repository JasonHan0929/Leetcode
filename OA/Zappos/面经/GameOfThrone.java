public class GameOfThrone {
	public static int gameOfThrone(int[][] venue) {
		int m = venue.length;
		int n = venue[0].length;
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (venue[i][j] == 1) {
					dfs(venue, i, j, m, n);
					count++;
				}
			}
		}
		return count;
	}
	public static void dfs(int[][] venue, int i, int j, int m, int n) {
        	if (j < 0 || j >= n || i < 0 || i >= m) {
            		return;
        	}
		if ( venue[i][j] == 1) {
			venue[i][j] = -1;
			dfs(venue, i, j + 1, m, n);
			dfs(venue, i, j - 1, m, n);
			dfs(venue, i + 1, j, m, n);
			dfs(venue, i - 1, j, m, n);
			dfs(venue, i + 1, j + 1, m, n);
			dfs(venue, i + 1, j - 1, m, n);
			dfs(venue, i - 1, j + 1, m, n);
			dfs(venue, i - 1, j - 1, m, n);
		}
	}
	public static void main(String args[]) {
		int[][]venue = new int[][]{new int[]{0,0,0,0,1,0,0,0}, new int[]{0,0,1,0,0,0,0,1}, new int[]{0,1,1,1,0,0,0,0}};
		System.out.print(gameOfThrone(venue));
	}
}
