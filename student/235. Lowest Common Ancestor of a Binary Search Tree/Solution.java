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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        return search(root, max, min);
    }
    public TreeNode search(TreeNode root, int max, int min){
        if (root == null)
            return null;
        else if (root.val > max)
            return search(root.left, max, min);
        else if (root.val < min)
            return search(root.right, max, min);
        else //if (root.val>= min && root.val <= max) 这里写成else if编译不过，提示该函数没有return
            return root;
    }
}//这个题注意树descendant 和 ancestor的定义
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        while (root != null) {
            if (root.val > max)
                root = root.left;
            else if (root.val < min)
                root = root.right;
            else
                break;
        }
        return root;
    }
}//迭代版，但是速度更慢...

