public class Solution {
    public int islandPerimeter(int[][] grid) {
        int[] count = new int[5];
        int width = grid[0].length;
        int length = grid.length;
        int adjoin = 0;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    if (i - 1 >= 0)
                        adjoin += grid[i - 1][j];
                    if (j - 1 >= 0)
                        adjoin += grid[i][j - 1];
                    if (i + 1 < length)
                        adjoin += grid[i + 1][j];
                    if (j + 1 < width)
                        adjoin += grid[i][j + 1];
                    count[adjoin]++;
                    adjoin = 0;
                }
            }
        }
        for (int k = 0; k < count.length; k++) {
            sum += count[k] * (count.length - k - 1);    
        }
        return sum;
    }
}

//loop over the matrix and count the number of islands;
//if the current dot is an island, count if it has any right neighbour or down neighbour;
//the result is islands * 4 - neighbours * 2
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
}//简洁版
