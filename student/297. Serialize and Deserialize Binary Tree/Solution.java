public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return result.toString();
        TreeNode cur;
        queue.offer(root);
        while (queue.size() > 0) {
            cur = queue.poll();
            result.append(cur == null ? "n" : cur.val);
            result.append(",");
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        int index = result.lastIndexOf("n");;
        while (index == result.length() - 1) {
            result.delete(index - 1, result.length() - 1);
            index = result.lastIndexOf("n");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

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
}//和序列化、饭序列化BST的题一模一样 449. Serialize and Deserialize BST
