import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import java.util.*;

/**
 * Constrains:
 *  1. The graph is always connected.
 *  2. The weight of each node is integer.
 *
 * Instructions:
 *  1. Use "A->B" to represent an edge.
 *  2. Use "A:1" to represent an weight.
 *  3. Suppose that eges and weights have same nodes.
 *
 *  RunTime = O(V + E)
 *  Space = O(E * E)
 */
public class FindPath {
    private final Map<String, Set<String>> graph = new HashMap<>();
    private final Map<String, Integer> weights = new HashMap<>();

    public FindPath(String[] edges, String[] weights) {
        if (edges == null || weights == null) {
            throw new InvalidParameterException("Invalid Input!");
        }
        for (String edge : edges) {
            String[] pair = edge.split("->");
            if (!graph.containsKey(pair[0])) {
                graph.put(pair[0], new HashSet<>());
            }
            if (!graph.containsKey(pair[1])) {
                graph.put(pair[1], new HashSet<>());
            }
            graph.get(pair[0]).add(pair[1]);
        }

        for (String weight : weights) {
            String[] pair = weight.split(":");
            this.weights.put(pair[0], Integer.parseInt(pair[1]));
        }
    }

    private boolean findLoop() {
        Set<String> visited = new HashSet<>();
        Set<String> inStack = new HashSet<>();
        for (String node : graph.keySet()) {
            if (!visited.contains(node)) {
                if (findLoopAssistDfs(node, inStack, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findLoopAssistDfs(String node, Set<String> inStack, Set<String> visited) {
        if (graph.get(node).isEmpty()) {
            visited.add(node);
            return false;
        }
        visited.add(node);
        inStack.add(node);
        for (String child : graph.get(node)) {
            if (inStack.contains(child)) {
                return true;
            }
            if (!visited.contains(child)) {
                if (findLoopAssistDfs(child, inStack,visited)) {
                    return true;
                }
            }
        }
        inStack.remove(node);
        return false;
    }

    private int findMaxWeightPathAssistDfs(String node) {
        if (graph.get(node).isEmpty()) {
            return weights.get(node);
        }
        int max = Integer.MIN_VALUE;
        for (String child : graph.get(node)) {
            max = Math.max(findMaxWeightPathAssistDfs(child), max);
        }
        return max + weights.get(node);
    }

    public int findMaxWeightPath(String node) {
        if (graph.isEmpty()) {
            return 0; // corner case
        }
        if (findLoop()) {
            throw new RuntimeException("The graph has a loop!");
        }
        if (!graph.containsKey(node)) {
            throw new InvalidParameterException("Invalid Input!");
        }
        return findMaxWeightPathAssistDfs(node);
    }

}
