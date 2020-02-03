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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        TreeNode result = null;
        if (p.right != null) {
            result = p.right;
            while (result.left != null) {
                result = result.left;
            }
        } else {
            while (root != p) {
                if (p.val < root.val) {
                    result = root;
                    root = root.left;
                } else {
                    root = root.right;
                }
            }    
        }
        return result;
    }
}

/*
The inorder traversal of a BST is the nodes in ascending order. To find a successor, you just need to find the smallest one that is larger than the given value since there are no duplicate values in a BST. It just like the binary search in a sorted list. The time complexity should be O(h) where h is the depth of the result node. succ is a pointer that keeps the possible successor. Whenever you go left the current root is the new possible successor, otherwise the it remains the same.

Only in a balanced BST O(h) = O(log n). In the worst case h can be as large as n.

Java

public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    TreeNode succ = null;
    while (root != null) {
        if (p.val < root.val) {
            succ = root;
            root = root.left;
        }
        else
            root = root.right;
    }
    return succ;
}

// 29 / 29 test cases passed.
// Status: Accepted
// Runtime: 5 ms
*/
