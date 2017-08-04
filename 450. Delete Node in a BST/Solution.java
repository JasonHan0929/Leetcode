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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null && cur.val != key) {
            pre = cur;
            if (cur.val > key)
                cur = cur.left;
            else
                cur = cur.right;
        }
        if (pre == null)
            return deleteRoot(root);
        else if (pre.left == cur)
            pre.left = deleteRoot(cur);
        else
            pre.right = deleteRoot(cur);
        return root;
    }
    public TreeNode deleteRoot(TreeNode root) {
        if (root == null)
            return null;
        else if (root.right == null)
            return root.left;
        else if (root.left == null)
            return root.right;
        TreeNode cur = root.right;
        TreeNode pre = root;
        while (cur.left != null) {
            pre = cur;
            cur = cur.left;
        }
        cur.left = root.left;
        if (root.right != cur) {
            pre.left = cur.right;
            cur.right = root.right;
        }
        root.left = null;
        root.right = null;
        return cur;
    }
}

/*
    private TreeNode deleteRootNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode next = root.right;
        TreeNode pre = null;
        for(; next.left != null; pre = next, next = next.left);
        next.left = root.left;
        if(root.right != next) {
            pre.left = next.right;
            next.right = root.right;
        }
        return next;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null && cur.val != key) {
            pre = cur;
            if (key < cur.val) {
                cur = cur.left;
            } else if (key > cur.val) {
                cur = cur.right;
            }
        }
        if (pre == null) {
            return deleteRootNode(cur);
        }
        if (pre.left == cur) {
            pre.left = deleteRootNode(cur);
        } else {
            pre.right = deleteRootNode(cur);
        }
        return root;
    }
Find the node to be removed and its parent using binary search, and then use deleteRootNode to delete the root node of the subtree and return the new root node. This idea is taken from https://discuss.leetcode.com/topic/67309/an-easy-understanding-o-h-time-o-1-space-java-solution.

I'd also like to share my thinkings of the other solutions I've seen.

There are many solutions that got high votes using recursive approach, including the ones from the Princeton's Algorithm and Data Structure book. Don't you notice that recursive approach always takes extra space? Why not consider the iterative approach first?
Some solutions swap the values instead of swapping the nodes. In reality, the value of a node could be more complicated than just a single integer, so copying the contents might take much more time than just copying the reference.
As for the case when both children of the node to be deleted are not null, I transplant the successor to replace the node to be deleted, which is a bit harder to implement than just transplant the left subtree of the node to the left child of its successor. The former way is used in many text books too. Why? My guess is that transplanting the successor can keep the height of the tree almost unchanged, while transplanting the whole left subtree could increase the height and thus making the tree more unbalanced
*/
