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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) 
            return result;
        path(root, new StringBuilder(), result);
        return result;
    }
        public void path(TreeNode root,StringBuilder path, List<String> result) {
        if (root.left == null && root.right == null) {
            path.append(root.val);
            result.add(path.toString());
            return;
        }
        int len = path.length();
        if (root.left != null) {
            path.append(root.val);
            path.append("->");
            path(root.left, path, result);
        }
        if (root.right != null) {
            path.setLength(len);
            path.append(root.val);
            path.append("->");
            path(root.right, path, result);
        }
    }
}//弄清楚什么时候setLenth

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, root, sb);
        return res;
    }
    
    private void helper(List<String> res, TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            helper(res, root.left, sb);
            helper(res, root.right, sb);
        }
        sb.setLength(len);
    }
}//逻辑清晰版，setLength的位置有点理解不过来

public List<String> binaryTreePaths(TreeNode root) {
    List<String> answer = new ArrayList<String>();
    if (root != null) searchBT(root, "", answer);
    return answer;
}
private void searchBT(TreeNode root, String path, List<String> answer) {
    if (root.left == null && root.right == null) answer.add(path + root.val);
    if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
    if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
}//string省事版
