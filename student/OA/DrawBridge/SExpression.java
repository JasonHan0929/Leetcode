 static String SExpression(String nodes) {
        if (nodes == null || nodes.length() < 5)
            return "E5";
        String[] edges = nodes.split(" ");
        HashMap<Character, List<Character>> tree = new HashMap<>(); // list contains the childrens in order
        HashMap<Character, Integer> indegree = new HashMap<>();
        String error = null;
        for (String edge : edges) {
            char parent = edge.charAt(1);
            char child = edge.charAt(3);
            indegree.put(child, indegree.getOrDefault(child, 0) + 1);
            indegree.put(parent, indegree.getOrDefault(parent, 0));
            if (Character.isUpperCase(parent) && Character.isUpperCase(child)) {
                if (tree.containsKey(parent)) {
                    List<Character> childs = tree.get(parent);
                    if (childs.size() >= 2) {
                        return "E1";
                    } else if (childs.contains(child)) {
                        return "E2";
                    } else {
                        if (childs.size() == 0) {
                            childs.add(child);
                        } else if (childs.get(0) > child) {
                            childs.add(0, child);
                        } else {
                            childs.add(child);
                        }
                    }
                } else {
                    tree.put(parent, new LinkedList<Character>());
                    tree.get(parent).add(child);
                }
            } else {
                return "E5";
            }
        }
        Character root = null;
        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                if (root == null) {
                    root = entry.getKey();
                } else {
                    if (error == null) {
                        error = "E4";
                    }
                }
            } else if (entry.getValue() != 1) {
                return "E3";
            }
        }
        if (error != null) {
            return error;
        }
        StringBuilder result = new StringBuilder();
        Set<Character> visited = new HashSet<Character>(26);
        Deque<Character> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            char curr = stack.peek();
            if (!visited.contains(curr)) {
                result.append("(").append(curr);
            }
            visited.add(curr);
            List<Character> childs = tree.get(curr);
            if (childs == null || visited.containsAll(childs)) {
                result.append(")");
                stack.poll();
            } else {
                if (childs.size() == 2) {
                    if (!visited.contains(childs.get(1))) {
                        stack.push(childs.get(1));
                    }
                    if (!visited.contains(childs.get(0))) {
                        stack.push(childs.get(0));
                    }
                } else {
                    stack.push(childs.get(0));
                }
            }
        }
        return result.toString();
    }// not pass all the cases
