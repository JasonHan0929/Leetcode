public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 0)
            return result;
        int rowBegin = 0, rowEnd = n - 1;
        int colBegin = 0, colEnd = n - 1;
        int count = 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++)
                result[rowBegin][i] = count++;
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++)
                result[i][colEnd] = count++;
            colEnd--;
            if (rowBegin > rowEnd || colBegin > colEnd)
                break;
            for (int i = colEnd; i >= colBegin; i--)
                result[rowEnd][i] = count++;
            rowEnd--;
            for (int i = rowEnd; i >= rowBegin; i--)
                result[i][colBegin] = count++;
            colBegin++;
        }
        return result;
    }
}
/*
This is my solution for Spiral Matrix I, https://oj.leetcode.com/discuss/12228/super-simple-and-easy-to-understand-solution. If you can understand that, this one is a no brainer :)

Guess what? I just made several lines of change (with comment "//change") from that and I have the following AC code:

public class Solution {
    public int[][] generateMatrix(int n) {
        // Declaration
        int[][] matrix = new int[n][n];
        
        // Edge Case
        if (n == 0) {
            return matrix;
        }
        
        // Normal Case
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        int num = 1; //change
        
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i ++) {
                matrix[rowStart][i] = num ++; //change
            }
            rowStart ++;
            
            for (int i = rowStart; i <= rowEnd; i ++) {
                matrix[i][colEnd] = num ++; //change
            }
            colEnd --;
            
            for (int i = colEnd; i >= colStart; i --) {
                if (rowStart <= rowEnd)
                    matrix[rowEnd][i] = num ++; //change
            }
            rowEnd --;
            
            for (int i = rowEnd; i >= rowStart; i --) {
                if (colStart <= colEnd)
                    matrix[i][colStart] = num ++; //change
            }
            colStart ++;
        }
        
        return matrix;
    }
}
*/
