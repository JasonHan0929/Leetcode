/**
 * Created by jason on 12/26/16.
 */
import java.util.*;

public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;
     public TreeNode(int x) { val = x; }

     public static TreeNode buildTree(Integer[] datas) {
          if (datas.length <= 0) return null;
          TreeNode root = new TreeNode(datas[0]);
          Queue<TreeNode> queue = new LinkedList<>();
          queue.offer(root);
          int index = 1;
          TreeNode cur;
          while (index < datas.length && queue.size() > 0) {
               cur = queue.poll();
               if (cur == null) continue;
               cur.left = datas[index] == null ? null : new TreeNode(datas[index]);
               queue.offer(cur.left);
               index++;
               if (index >= datas.length) break;
               cur.right = datas[index] == null ? null : new TreeNode(datas[index]);
               queue.offer(cur.right);
               index++;
          }
          return root;
     }

     public static String toString(TreeNode root) {
          StringBuilder result = new StringBuilder();
          Queue<TreeNode> queue = new LinkedList<>();
          if (root == null)
               return result.toString();
          TreeNode cur;
          queue.offer(root);
          while (queue.size() > 0) {
               cur = queue.poll();
               result.append(cur == null ? "null" : cur.val);
               result.append(",");
               if (cur != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
               }
          }
          int index = result.lastIndexOf("null");;
          while (index == result.length() - 5) {
               result.delete(index - 1, result.length() - 1);
               index = result.lastIndexOf("null");
          }
          result.deleteCharAt(result.length() - 1);
          return result.toString();
     }

     public static void printTree(TreeNode root) {
          System.out.println(toString(root));
     }

     public static int getHeight(TreeNode root) {
          int height = 0;
          if (root == null)
               return height;
          return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
     }
}


