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
    public TreeNode invertTree(TreeNode root) {
        TreeNode tempo;
        if (root == null || (root.left == null && root.right == null))
            return root;
        else if (root.left == null && root.right != null) {
            root.left = invertTree(root.right);
            root.right = null;
            return root;
        }
        else if (root.right == null && root.left != null) {
            root.right = invertTree(root.left);
            root.left = null;
            return root;
        }
        else {
            tempo = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(tempo);
            return root;
        }
           
    }
}//写的不好，递归理解不到为

public TreeNode invertTree(TreeNode root) {
    if(root == null) {
        return root;
    }
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    
    invertTree(root.left);
    invertTree(root.right);
    
    return root;
}//前序遍历思想，先做再递归

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}//简洁写法，注意递归执行流程


