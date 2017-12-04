/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int count;
    int number;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return number;
    }
    public void dfs(TreeNode root) {
        if (root == null || count < 1) {
            return;
        }
        dfs(root.left);
        count -= 1;
        if (count == 0) {
            number = root.val;
            return;
        }
        dfs(root.right);
    }
}

/*
  public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
        }
        
        return root.val;
    }
    
    public int countNodes(TreeNode n) {
        if (n == null) return 0;
        
        return 1 + countNodes(n.left) + countNodes(n.right);
    }
*/
