/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end) {
 *         this.start = start, this.end = end;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param start: start value.
     * @param end: end value.
     * @return: The root of Segment Tree.
     */
    public SegmentTreeNode build(int start, int end) {
        if (end < start) {
            return null;
        }
        SegmentTreeNode root = dfs(start, end);
        return root;
    }
    public SegmentTreeNode dfs(int start, int end) {
        SegmentTreeNode curr = new SegmentTreeNode(start, end);
        if (start < end) {
            int mid = (start + end) / 2;
            curr.left = dfs(start, mid);
            curr.right = dfs(mid + 1, end);
        }
        return curr;
    }
}
