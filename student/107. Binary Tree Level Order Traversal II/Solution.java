public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();//不涉及查询只涉及添加用linkedlist更好
        assist(root, result, 0);
        return result;
    }
    public void assist(TreeNode root, List<List<Integer>> result, int level) {//因为每层用一个list，所以必须统计level
        if (root == null) {
            return;
        }
        if (result.size() <= level) {//注意层数是0,1,2,3……当level = 3时，实际有4层，即size=level时实际上size还少了一层也要新建list
            result.add(0, new LinkedList<Integer>());
        }
        assist(root.left, result,level + 1);
        assist(root.right, result, level + 1);
        result.get(result.size() - level - 1).add(root.val);//注意get（）内的坐标推算，因为列表坐标起始为0,要多减一
    }
}//DFS版,在assist里检验root是否为null来决定是否添加root点，而不是检验root的子节点来决定是否加入其字节点，这样会简单很多
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();//注意与stack不同，queue是接口，由LinkedList实现
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (queue.size() > 0) {
            int levelNodes = queue.size();//注意怎么得到每层应该有多少元素的方法，每次迭代前queue中的元素为该层的所有元素
            result.add(0,new LinkedList<Integer>());
            for (int i = 0; i < levelNodes; i++) {
                root = queue.poll();
                result.get(0). add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
        }
        return result;
    }
}//BFS版
