public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur;
        queue.offer(root);
        int count = 0;
        boolean find = false;
        while(queue.size() > 0 && !find) {
            int levelNodes = queue.size();
            for (int i = levelNodes; i > 0; i--) {
                cur = queue.poll();
                if (cur != null && cur.left ==null && cur.right == null) {
                    find = true;
                    break;
                }
                else if (cur != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
            count++;
        }
        return count;
    }
}//bfs
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) 
            return 0;
        else if (root.left == null) //因为找的是叶子节点，要把一边为空的情况单独拿出来讨论
            return minDepth(root.right) + 1;
        else if  (root.right == null)
            return minDepth(root.left) + 1;
        else 
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}//dfs
