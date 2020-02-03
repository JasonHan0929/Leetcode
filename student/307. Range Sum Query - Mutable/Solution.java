class NumArray {
    
    Node root;
    
    public NumArray(int[] nums) {
        if (nums != null && nums.length > 0) {
            root = buildTree(0, nums.length - 1, nums);
        }
    }
    
    private Node buildTree(int start, int end, int[] nums) {
        Node curr = new Node(start, end);
        if (start < end) {
            int mid = start + (end - start)/2;
            curr.left = buildTree(start, mid, nums);
            curr.right = buildTree(mid + 1, end, nums);
            curr.sum = curr.left.sum + curr.right.sum;
        } else {
            curr.sum = nums[start];
        }
        return curr;
    }
    
    public void update(int i, int val) {
        dfsUpdate(root, i, val);
    }
    
    private void dfsUpdate(Node root, int i, int val) {
        if (root == null) return;
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if ( i <= mid) {
                dfsUpdate(root.left, i, val);
            } else {
                dfsUpdate(root.right, i, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }
    
    public int sumRange(int i, int j) {
        return dfsSum(root, i, j);
    }
    
    public int dfsSum(Node root, int i, int j) {
        if (root == null) return 0;
        if (i <= root.start && j >= root.end) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            int left = 0, right = 0;
            if (i <= mid) {
                left = dfsSum(root.left, i, Math.min(j, mid));
            }
            if (j >= mid + 1) {
                right = dfsSum(root.right, Math.max(mid + 1, i), j);
            }
            return left + right;
        }
    }
}

class Node {
    int start;
    int end;
    int sum;
    Node left;
    Node right;
    Node (int start, int end) {
        this.start = start;
        this.end = end;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
