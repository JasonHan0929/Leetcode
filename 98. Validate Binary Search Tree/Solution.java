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
    public boolean isValidBST(TreeNode root) {
        return assist(root, null, null);
    }
    public boolean assist(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;
        if (min != null && root.val <= min)
            return false;
        if (max != null && root.val >= max)
            return false;
        return assist(root.left, min, root.val) && assist(root.right, root.val, max);
    }
}//牛人的递归写法，给定每个节点一个true的范围，超出这个范围则不是BST，你不能在递归的时候只判断每个节点的左子节点和右子节点的值，因为BST是要求左子树、根节点、右子树满足一定的关系

public class Solution {	
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        Stack<Integer> minStack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        Integer min = null;
        Integer max = null;
        stack.push(root);
        minStack.push(min);
        maxStack.push(max);
        while (!stack.isEmpty()) {//注意ArrayDeque的函数是isEmpty()，stack的是empty()
            root =stack.pop();
            min = minStack.pop();
            max = maxStack.pop();
            if ((max != null && root.val >= max) || (min != null && root.val <= min))
                return false;
            if (root.left != null) {
                stack.push(root.left);
                maxStack.push(root.val);
                minStack.push(min);
            }
            if (root.right != null) {
                stack.push(root.right);
                minStack.push(root.val);
                maxStack.push(max);
            }
        }
        return true;
    }//上述递归的迭代翻译版，完全的翻译，三个堆栈维护每次递归需要的值，时间效率比较低
}
public class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<Integer> minStack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        Integer min = null;
        Integer max = null;
        stack.push(root);
        minStack.push(min);
        maxStack.push(max);
        while (!stack.empty() || root != null) {
            root =stack.pop();
            min = minStack.pop();
            max = maxStack.pop();
            if (root == null)
                continue;
            if ((max != null && root.val >= max) || (min != null && root.val <= min))
                return false;
            stack.push(root.left);
            maxStack.push(root.val);
            minStack.push(min);
            stack.push(root.right);
            minStack.push(root.val);
            maxStack.push(max);
        }
        return true;
    }	
}//上述翻译版的简化版，让null可以入堆栈，减少一些判断

public boolean isValidBST(TreeNode root) {
   if (root == null) return true;
   Stack<TreeNode> stack = new Stack<>();
   TreeNode pre = null;
   while (root != null || !stack.isEmpty()) {
      while (root != null) {
         stack.push(root);
         root = root.left;
      }
      root = stack.pop();
      if(pre != null && root.val <= pre.val) return false;
      pre = root;
      root = root.right;
   }
   return true;
}//牛人中序遍历版，因为BST中序遍历是由小到大输出的，所以前一个节点的值必须比后来的节点的值要小，就不用维护一个minStack和maxStack，递归方法也可以中序遍历，更方便

