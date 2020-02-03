class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    queue.offer(new int[]{i, j});//[row, column]
                else
                    result[i][j] = -1;
            }
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] index = queue.poll();
            for (int[] dir : dirs) {
                int row = index[0] + dir[0];
                int column = index[1] + dir[1];
                if (row >= 0 && column >= 0 && row < m && column < n && result[row][column] == -1) {
                    result[row][column] = result[index[0]][index[1]] + 1;
                    queue.offer(new int[]{row, column});
                }
            }
        }
        return result;
    }
}

/*
public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
                else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n || 
                    matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
                queue.add(new int[] {r, c});
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        
        return matrix;
    }
}
*/

/*
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
           List<List<Integer>> ans = new ArrayList<>();
           int m = matrix.size(), n = matrix.get(0).size();
           int[][] res = new int[m][n];
           for(int i = 0; i < m; i++)
              for(int j = 0; j < n; j++)
                  res[i][j] = (matrix.get(i).get(j) == 0) ? 0 : m+n;
           for(int i = 0; i < m; i++)
               for(int j = 0; j < n; j++){
                   int left =(j-1 >= 0) ? res[i][j - 1]: res[i][j]; 
                   int top = (i-1 >= 0) ? res[i - 1][j]: res[i][j]; 
		res[i][j] = Math.min(res[i][j], Math.min(top, left) + 1);
          }
          for(int i = m-1; i >=0 ; i--)
            for(int j = n-1; j >= 0; j--){
                 int right = (j+1 < n) ? res[i][j+1]: res[i][j]; 
                 int down = (i+1 < m) ? res[i+1][j]: res[i][j]; 
	     res[i][j] = Math.min(res[i][j], Math.min(down, right) + 1);
          }
         for(int i = 0; i < m; i++){
            List<Integer> cur = new ArrayList<>();
            for(int j = 0; j < n; j++)
                cur.add(res[i][j]);
            ans.add(cur);
         }
    
    return ans;
}
*/
