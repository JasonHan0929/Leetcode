/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode last = root; // could not initialized with null
        while (root != null || !stack.isEmpty()) {
            if (root.left != null && last != root.left && last != root.right) {
                stack.push(root);
                root = root.left;
                continue;
            }
            if (root.right != null && last != root.right) {
                stack.push(root);
                root = root.right;
                continue;
            }
            result.add(root.val);
            if (!stack.isEmpty()) {
                last = root;
                root = stack.pop();
                if (root.left == last && root.right != null) {
                    stack.push(root);
                    root = root.right;
                } else {
                    result.add(root.val);
                    if (!stack.isEmpty()) {
                        last = root;
                        root = stack.pop();
                    } else break;
                }
            } else break;
        }
        return result;
    }
}
