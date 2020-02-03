/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: The root of segment tree.
     * @param index: index.
     * @param value: value
     * @return: 
     */
    public void modify(SegmentTreeNode root, int index, int value) {
        dfs(root, index, value);
    }
    public int dfs(SegmentTreeNode root, int index, int value) {
        if (root.start > index || root.end < index) {
            return root.max;
        }
        if (root.start == root.end) {
            root.max = value;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
            left = dfs(root.left, index, value);
            right = dfs(root.right, index, value);
            root.max = Math.max(left, right);
        }
        return root.max;
    }
}

/*
public void modify(SegmentTreeNode root, int index, int value) {
    if (root.start == index && root.end == index) {
        root.max = value;
        return;
    }
    int mid = (root.start + root.end) / 2;
    if (root.start <= index && index <= mid) {
        modify(root.left, index, value);
    }
    if (mid < index && index <= root.end) {
        modify(root.right, index, value);
    }
    root.max = Math.max(root.left.max, root.right.max);
}
*/
