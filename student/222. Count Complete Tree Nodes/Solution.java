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
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        else if (root.left == null)
            return 1;//must deal with this corner case
        int height = 0;
        int nodesAbove = 0;
        TreeNode curr = root;
        while (curr.left != null) {
            nodesAbove += 1 << height; 
            height++;
            curr = curr.left;
        }
        return nodesAbove + countLastLevelNodes(root, height);//not height + 1
    }
    public int countLastLevelNodes(TreeNode root, int height) {
        if (height == 1) {
            if (root.right != null)
                return 2;
            else if (root.left != null)
                return 1;
            else
                return 0;
        }//these are the base cases
        TreeNode curr = root.left;
        int passHeight = 1;
        while (passHeight < height) {
            curr = curr.right;
            passHeight++;
        }
        if (curr == null)
            return countLastLevelNodes(root.left, height - 1);
        else
            return (1 << (height - 1)) + countLastLevelNodes(root.right, height - 1);
    }
}
//time complexity is O(h ^ 2)

/*
Basically my solution contains 2 steps.
(1) Firstly, we need to find the height of the binary tree and count the nodes above the last level.
(2) Then we should find a way to count the nodes on the last level.

Here I used a kind of binary search. We define the "midNode" of the last level as a node following the path "root->left->right->right->...->last level".

If midNode is null, then it means we should count the nodes on the last level in the left subtree.

If midNode is not null, then we add half of the last level nodes to our result and then count the nodes on the last level in the right subtree.

Of course I used some stop condition to make the code more efficient, e.g. when a tree has height 1, it means it only has 3 cases: 1. has right son; 2. only has left son; 3. has no son.

public int countNodes(TreeNode root) {
	if (root==null) return 0;
	if (root.left==null) return 1;
	int height = 0;
    int nodesSum = 0;
	TreeNode curr = root;
    while(curr.left!=null) {
    	nodesSum += (1<<height);
    	height++;
    	curr = curr.left;
    }
    return nodesSum + countLastLevel(root, height);
}

private int countLastLevel(TreeNode root, int height) {
	if(height==1) 
		if (root.right!=null) return 2;
		else if (root.left!=null) return 1;
		else return 0;
	TreeNode midNode = root.left;
	int currHeight = 1;
	while(currHeight<height) {
		currHeight++;
		midNode = midNode.right;
	}
	if (midNode==null) return countLastLevel(root.left, height-1);
	else return (1<<(height-1)) + countLastLevel(root.right, height-1);
}
*/
