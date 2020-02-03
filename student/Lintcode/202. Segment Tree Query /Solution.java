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
     * @param start: start value.
     * @param end: end value.
     * @return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        return dfs(root, start, end);
    }
    public int dfs(SegmentTreeNode root, int start, int end) {
        if (start <= root.start && end >= root.end) {
            return root.max;
        }
        int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
        int mid = root.start + ((-root.start + root.end) >> 1);
        if (start <= mid) {
            left = dfs(root.left, start, Math.min(mid, end));
        }
        if (mid + 1 <= end) {
            right = dfs(root.right, Math.max(start, mid + 1), end);// pay attention to the index for next dfs()
        }
        return Math.max(left, right);
    }
}
