/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        //int height = getHeight(root);
        if (root == null)
            return result.toString();
        TreeNode cur;
        queue.offer(root);
        //int level = 0;
        while (queue.size() > 0) {
            //for (int levelNodes = queue.size(); levelNodes > 0; levelNodes--) {
                cur = queue.poll();
                //if (cur == null && queue.size() > 0)
                    //result.append("n");
                //else if (cur != null)
                    //result.append(cur.val);
		result.append(cur == null ? "n" : cur.val);
                result.append(",");
                //if (cur != null && level < height) {
                if (cur != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            //}
            //level++;
        }
        int index = result.lastIndexOf("n");;
        while (index == result.length() - 1) {
            result.delete(index - 1, result.length() - 1);
            index = result.lastIndexOf("n");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }//修正了一下把不需要的null都放结尾最后去除

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() <= 0) return null;
        String[] datas = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(datas[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        TreeNode cur;
        while (index < datas.length && queue.size() > 0) {
            cur = queue.poll();
            if (cur == null) continue;
            cur.left = datas[index].equals("n") ? null : new TreeNode(Integer.parseInt(datas[index]));
            queue.offer(cur.left);
            index++;
            if (index >= datas.length) break;
            cur.right = datas[index].equals("n") ? null : new TreeNode(Integer.parseInt(datas[index]));
            queue.offer(cur.right);
            index++;
        }
        return root;
    }
    public int getHeight(TreeNode root) {
        int height = 0;
        if (root == null)
            return height;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
