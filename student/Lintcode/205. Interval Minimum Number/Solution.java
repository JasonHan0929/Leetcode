/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Node {
    Node left;
    Node right;
    int start;
    int end;
    int min;
    Node (int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Solution {
    /*
     * @param A: An integer array
     * @param queries: An query list
     * @return: The result list
     */
    public List<Integer> intervalMinNumber(int[] A, List<Interval> queries) {
        Node root = buildSegmentTree(0, A.length - 1, A);
        List<Integer> result = new ArrayList<>(queries.size());
        for (Interval query : queries) {
            result.add(querySegmentTree(root, query.start, query.end));
        }
        return result;
    }
    public Node buildSegmentTree(int start, int end, int[] A) {
        Node curr = new Node(start, end);
        if (start < end) {
            int mid = start + (end - start) / 2;
            curr.left = buildSegmentTree(start, mid, A);
            curr.right = buildSegmentTree(mid + 1, end, A);
            curr.min = Math.min(curr.left.min, curr.right.min);
        } else {
            curr.min = A[start];
        }
        return curr;
    }
    public int querySegmentTree(Node root, int start, int end) {
        if (start <= root.start && end >= root.end) {
            return root.min;
        }
        int mid = root.start + (root.end - root.start) / 2; // use start and end from root rather than from query!
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if (start <= mid) {
            left = querySegmentTree(root.left, start, Math.min(mid, end));
        }
        if (mid < end) {
            right = querySegmentTree(root.right, Math.max(start, mid + 1), end);
        }
        return Math.min(left, right);
    }
}

/*
class SegmentTreeNode{
    int start;
    int end;
    int min;
    SegmentTreeNode left;
    SegmentTreeNode right;
    public SegmentTreeNode(int start, int end, int min){
        this.start = start;
        this.end = end;
        this.min = min;
        left = right = null;
    }
}

public class Solution {

    public ArrayList<Integer> intervalMinNumber(int[] A, 
                                                ArrayList<Interval> queries) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(A == null || A.length == 0 || queries == null || queries.size() == 0){
            return res;
        }

        SegmentTreeNode root = SegmentTreeBuilder(A, 0, A.length - 1);

        for(int i = 0; i < queries.size(); i++){
            int min = query(root, queries.get(i).start, queries.get(i).end);
            res.add(min);
        }

        return res;
    }

    private SegmentTreeNode SegmentTreeBuilder(int[] A, int start, int end){
        if(start == end){
            return new SegmentTreeNode(start, end, A[start]);
        }

        int mid = (start + end) / 2;
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        SegmentTreeNode left = SegmentTreeBuilder(A, start, mid);
        SegmentTreeNode right = SegmentTreeBuilder(A, mid + 1, end);

        root.left = left;
        root.right = right;
        root.min = Math.min(left.min, right.min);

        return root;
    }

    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if(root == null || start > end || start > root.end || end < root.start){
            return -1;
        }

        if(start == root.start && end == root.end){
            return root.min;
        }

        int mid = (root.start + root.end) / 2;
        //跨越中点
        if(start <= mid && end >= mid + 1){
            int left = query(root.left, start, mid);
            int right = query(root.right, mid + 1, end);
            return Math.min(left, right);
        }
        //左边
        if(end <= mid){
            return query(root.left, start, end);
        }
        //右边
        return query(root.right, start, end);
    }
}
*/
