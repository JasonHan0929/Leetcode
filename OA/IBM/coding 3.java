import java.util.*;

public class Try{
    private static class Node{
        private final List<Node> member;
        private final String name;
        private Node(String name) {
            member = new LinkedList<Node>();
            this.name = name;
        }
    }
    public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        Node root = buildTree(input);
        System.out.print(findManager(root, input[input.length - 1], input[input.length - 2]).name);
    }
    /*public static Node buildTree(String[] input) {
        HashSet<String> candidate = new HashSet<>();
        HashSet<String> children = new HashSet<>();
        HashMap<String, Node> nameToNode = new HashMap<>();
        for (int i = 0; i < input.length - 2; i++) {
            String[] temp = input[i].split("->");
            if (!nameToNode.containsKey(temp[0]))
                nameToNode.put(temp[0], new Node(temp[0]));
            if (!nameToNode.containsKey(temp[1]))
                nameToNode.put(temp[1], new Node(temp[1]));
            nameToNode.get(temp[0]).member.add(nameToNode.get(temp[1]));
            if (!children.contains(temp[0]))
                candidate.add(temp[0]);
            if (candidate.contains(temp[1]))
                candidate.remove(temp[1]);
            children.add(temp[1]);
        }
        return nameToNode.get(candidate.iterator().next());
    }*/
    public static Node buildTree(String[] input) {
        HashMap<String, Integer> inDegree = new HashMap<>();
        HashMap<String, Node> nameToNode = new HashMap<>();
        for (int i = 0; i < input.length - 2; i++) {
            String[] temp = input[i].split("->");
            if (!nameToNode.containsKey(temp[0]))
                nameToNode.put(temp[0], new Node(temp[0]));
            if (!nameToNode.containsKey(temp[1]))
                nameToNode.put(temp[1], new Node(temp[1]));
            nameToNode.get(temp[0]).member.add(nameToNode.get(temp[1]));
            if (!inDegree.containsKey(temp[0]))
                inDegree.put(temp[0], 0);
            inDegree.put(temp[1], inDegree.getOrDefault(temp[1], 0) + 1);
        }
        Node root = null;
        for (Map.Entry<String, Integer> indegree : inDegree.entrySet()) {
            if (indegree.getValue() == 0) {
                root = nameToNode.get(indegree.getKey());
                break;
            }
        }
        return root;
    }
    public static Node findManager(Node root, String name1, String name2) {
        if (root.member.size() == 0 || root.name.equals(name1) || root.name.equals(name2))
            return root;//root.member.size() == 0 could not be replaced by root == null
        List<Node> list = new LinkedList<>();
        for (Node node : root.member) {
            Node temp = findManager(node, name1, name2);
            if (temp != null)
                list.add(temp);
        }
        if (list.size() == 2)
            return root;
        else if (list.size() ==1)
            return list.get(0);
        else
            return null;
    }
}


