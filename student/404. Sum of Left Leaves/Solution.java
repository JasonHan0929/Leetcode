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
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        sum(root);
        return sum;
    }
    public void sum(TreeNode root) {
        if (root == null)
            return;
        else if (root.left != null && root.left.left == null && root.left.right == null)
            sum += root.left.val;
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);        
    }
}

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        int sum = 0;//注意sum在迭代过程中的意义，不用把sum作为行惨传给下一层函数
        if (root.left != null && root.left.left == null && root.left.right == null)
            sum += root.left.val;
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right); 
        return sum;
    }
}//不用全局变量

public int sumOfLeftLeaves(TreeNode root) {
    if(root == null) return 0;
    int ans = 0;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    
    while(!stack.empty()) {
        TreeNode node = stack.pop();
        if(node.left != null) {
            if (node.left.left == null && node.left.right == null)
                ans += node.left.val;
            else
                stack.push(node.left);
        }
        if(node.right != null) {
            if (node.right.left != null || node.right.right != null)
                stack.push(node.right);
        }
    }
    return ans;
}//迭代模式
