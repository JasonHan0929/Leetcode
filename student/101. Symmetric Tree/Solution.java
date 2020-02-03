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
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        if (root.left == null || root.right == null)
            return false;
        reverse(root.right);
        return same(root.left, root.right);
        
    }
    public TreeNode reverse(TreeNode root) {
        if (root == null)
            return root;
        TreeNode tempo = root.left;
        root.left = reverse(root.right);
        root.right = reverse(tempo);
        return root;
    }
    public boolean same(TreeNode rootA, TreeNode rootB) {
        if (rootA == null && rootB == null)
            return true;
        if (rootA == null || rootB == null)
            return false;
        if (rootA.val != rootB.val)
            return false;
        return same(rootA.left, rootB.left) && same(rootA.right, rootB.right);
    }
}//一开始想到的复杂方法

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        return symmetric(root.left, root.right);
    }
    public boolean symmetric(TreeNode rootA, TreeNode rootB) {
        if (rootA == null && rootB == null)
            return true;
        if (rootA == null || rootB == null)
            return false;
        if (rootA.val != rootB.val)
            return false;
        return symmetric(rootA.left, rootB.right) && symmetric(rootA.right, rootB.left);
    }//只需左子树和右子树成镜像一直递归下去
}//还可以用stack写
