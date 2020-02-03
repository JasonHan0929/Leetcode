public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) 
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if ((left == p && right == q) || (left == q && right == p))
            return root;
        else if (right != null)
            return right;
        else if (left != null)
            return left;
        else
            return null;
    }
}//递归法，介于p，q之间的root

/*
迭代法：
后序遍历二叉树，得到从根节点到目标节点的“路径”，两条路径公共部分的末尾节点即为LCA,用栈储存路径
*/
