/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return bfs(node);
    }
    private Node bfs(Node node) {
        Deque<Node> queue = new LinkedList<Node>();
        HashMap<Node, Node> pair = new HashMap<Node, Node>();
        HashSet<Node> visited = new HashSet<Node>(); // 应该可以优化掉只用一个hashmap
        queue.add(node);
        Node root = new Node(node.val);
        pair.put(node, root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (visited.contains(cur)) {
                continue;
            }
            Node newNode = pair.get(cur);
            for (Node child : cur.neighbors) {
                Node newChild = pair.getOrDefault(child, new Node(child.val));
                newNode.neighbors.add(newChild);
                pair.put(child, newChild);
                queue.add(child);
            }
            visited.add(cur);
        }
        return root;
    }
}
