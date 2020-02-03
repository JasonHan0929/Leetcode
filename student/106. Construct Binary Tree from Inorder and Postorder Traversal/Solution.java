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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            hash.put(inorder[i], i);
        return buildTree(postorder.length - 1, 0, hash.size() - 1, hash, postorder);
    }
    public TreeNode buildTree(int postIndex, int inStart, int inEnd, Map<Integer, Integer> inorder, int[] postorder) {
        if (postIndex < 0 || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postIndex]);    
        int inIndex = inorder.get(root.val);
        int rightTreeLen = inEnd - inIndex;
        root.right = buildTree(postIndex - 1, inIndex + 1, inEnd, inorder, postorder);
        root.left = buildTree(postIndex - rightTreeLen - 1, inStart, inIndex - 1, inorder, postorder);
        return root;
    }
}//using hashmap to reduce running time
