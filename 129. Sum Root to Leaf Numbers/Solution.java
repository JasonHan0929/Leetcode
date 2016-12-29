public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        return sumNumbers(root, 0, 0); 
    }
    public int sumNumbers(TreeNode root, int sum, int number) {
        number = number * 10 + root.val;
        if (root.left == null && root.right == null)
            return sum + number;
        else if (root.left == null)
            return sumNumbers(root.right, sum, number);
        else if (root.right == null)
            return sumNumbers(root.left, sum, number);
        else {
            int left = sumNumbers(root.left, sum, number);
            int right = sumNumbers(root.right, sum, number);
            return left + right - sum;
        }
    }
}

public int sumNumbers(TreeNode root) {
	return sum(root, 0);
}

public int sum(TreeNode n, int s){
	if (n == null) return 0;
	if (n.right == null && n.left == null) return s*10 + n.val;
	return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
}//牛人简洁版
