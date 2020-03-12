class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int leftBound = 0, rightBound = matrix[0].length - 1, upperBound = 0, bottomBound = matrix.length - 1;
        int i = 0, j = 0;
        int direction = 0; // [0: go_right, 1: go_down, 2: go_left, 3: go_up]
        while (leftBound <=rightBound && upperBound <= bottomBound) {
            result.add(matrix[i][j]);
            if (direction == 0) {
                j++;
                if (j > rightBound) {
                    j = rightBound;
                    i++;
                    upperBound++;
                    direction = 1;
                }
            } else if (direction == 1) {
                i++;
                if (i > bottomBound) {
                    i = bottomBound;
                    j--;
                    rightBound--;
                    direction = 2;
                }
            } else if (direction == 2) {
                j--;
                if (j < leftBound) {
                    j = leftBound;
                    i--;
                    bottomBound--;
                    direction = 3;
                }
            } else if (direction == 3) {
                i--;
                if (i < upperBound) {
                    i = upperBound;
                    j++;
                    leftBound++;
                    direction = 0;
                }
            }
            //System.out.println(String.format("left: %d, right: %d, upper: %d, bottom: %d", leftBound, rightBound, upperBound, bottomBound));
        }
        return result;
    }
}
