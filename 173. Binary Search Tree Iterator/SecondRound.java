/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    TreeNode curr;

    public BSTIterator(TreeNode root) {
        curr = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curr != null;
    }

    /** @return the next smallest number */
    public int next() {
        while (curr != null) {
            if (curr.left == null) {
                int result = curr.val;
                curr = curr.right;
                return result;
            }
            TreeNode prev = curr.left;
            while (prev.right != null && prev.right != curr) {
                prev = prev.right;
            }
            if (prev.right == null) {
                prev.right = curr;
                curr = curr.left;
            } else {
                int result = curr.val;
                prev.right = null;
                curr = curr.right;
                return result;
            }
        }
        return -1;
    }
}// use morris traversal

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
