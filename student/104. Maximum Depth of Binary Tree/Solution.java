/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int max = 0;
    public int maxDepth(TreeNode root) {
        if (root == null)
             return max;
        maxDepth(root, 0);
        return max;
    }
    public void maxDepth(TreeNode root, int counter) {
        counter++;
        if (root.left != null)
            maxDepth(root.left, counter);
        if (root.right != null)
            maxDepth(root.right, counter);
        if (root.right == null && root.left == null) {
            max = counter > max ? counter : max;
        }        
    }
}//很繁琐

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
             return 0;
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return left > right ? left : right;
    }
}

public class Solution {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}//牛逼版
