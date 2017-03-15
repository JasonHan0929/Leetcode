public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            int temp = matrix[mid / n][mid % n];
            if (temp > target)
                high = mid - 1;
            else if (temp < target)
                low = mid + 1;
            else
                return true;
        }
        return false;
    }
}
/*
Use binary search.

n * m matrix convert to an array => matrix[x][y] => a[x * m + y]

an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];
*/
