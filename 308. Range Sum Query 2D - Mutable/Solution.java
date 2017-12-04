class NumMatrix {

    Node root;
    
    public NumMatrix(int[][] matrix) {
        if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            root = buildTree(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
        }
    }
    
    private Node buildTree(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd) {
        if (rowStart > rowEnd || colStart > colEnd) { // in 2D, this check is necessary
            return null;
        }
        Node curr = new Node(rowStart, rowEnd, colStart, colEnd);
        if (rowStart == rowEnd && colStart == colEnd) {
            curr.sum = matrix[rowStart][colStart];
        } else {
            int rowMid = rowStart + (rowEnd - rowStart) / 2;
            int colMid = colStart + (colEnd - colStart) / 2;
            curr.topLeft = buildTree(matrix, rowStart, rowMid, colStart, colMid);
            curr.topRight = buildTree(matrix, rowStart, rowMid, colMid + 1, colEnd);
            curr.bottomLeft = buildTree(matrix, rowMid + 1, rowEnd, colStart, colMid);
            curr.bottomRight = buildTree(matrix, rowMid + 1, rowEnd, colMid + 1, colEnd);
            curr.sum += curr.topLeft == null ? 0 : curr.topLeft.sum;
            curr.sum += curr.topRight == null ? 0 : curr.topRight.sum;
            curr.sum += curr.bottomLeft == null ? 0 : curr.bottomLeft.sum;
            curr.sum += curr.bottomRight == null ? 0 : curr.bottomRight.sum;
        }
        return curr;
    }
    
    public void update(int row, int col, int val) {
        if (root != null) {
            dfsUpdate(root, row, col, val);
        }
    }
    
    private void dfsUpdate(Node root, int row, int col, int val) {
        if (root.rowStart == root.rowEnd && root.colStart == root.colEnd) {
            root.sum = val;
        } else {
            int rowMid = root.rowStart + (root.rowEnd - root.rowStart) / 2;
            int colMid = root.colStart + (root.colEnd - root.colStart) / 2;
            if (row <= rowMid && col <= colMid) {
                dfsUpdate(root.topLeft, row, col, val);
            } else if (row <= rowMid && col > colMid) {
                dfsUpdate(root.topRight, row, col, val);
            } else if (row > rowMid && col <= colMid) {
                dfsUpdate(root.bottomLeft, row, col, val);
            } else {
                dfsUpdate(root.bottomRight, row, col, val);
            }
            root.sum = 0;
            root.sum += root.topLeft == null ? 0 : root.topLeft.sum;
            root.sum += root.topRight == null ? 0 : root.topRight.sum;
            root.sum += root.bottomLeft == null ? 0 : root.bottomLeft.sum;
            root.sum += root.bottomRight == null ? 0 : root.bottomRight.sum;
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (root == null) return 0;
        return dfsSum(root, row1, row2, col1, col2);
    }
    
    private int dfsSum(Node root, int row1, int row2, int col1, int col2) {
        if (row1 <= root.rowStart && row2 >= root.rowEnd && col1 <= root.colStart && col2 >= root.colEnd) {
            return root.sum;
        } else {
            int rowMid = root.rowStart + (root.rowEnd - root.rowStart) / 2;
            int colMid = root.colStart + (root.colEnd - root.colStart) / 2;
            int sum = 0;
            if (row1 <= rowMid && col1 <= colMid) {
                sum += dfsSum(root.topLeft, row1, Math.min(rowMid, row2), col1, Math.min(colMid, col2));
            }
            if (row1 <= rowMid && col2 > colMid) {
                sum += dfsSum(root.topRight, row1, Math.min(rowMid, row2), Math.max(colMid + 1, col1), col2);
            }
            if (row2 > rowMid && col1 <= colMid) {
                sum += dfsSum(root.bottomLeft, Math.max(rowMid + 1, row1), row2, col1, Math.min(colMid, col2));
            }
            if (row2 > rowMid && col2 > colMid) {
                sum += dfsSum(root.bottomRight, Math.max(rowMid + 1, row1), row2, Math.max(colMid + 1, col1), col2);
            }
            return sum;
        }
    }
}

class Node {
    int rowStart, rowEnd;
    int colStart, colEnd;
    Node topLeft, topRight, bottomLeft, bottomRight;
    int sum;
    Node (int rowStart, int rowEnd, int colStart, int colEnd) {
        this.rowStart = rowStart;
        this.rowEnd = rowEnd;
        this.colStart = colStart;
        this.colEnd = colEnd;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
