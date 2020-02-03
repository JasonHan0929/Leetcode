public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < ppid.size(); i++) {
            int key = ppid.get(i);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(pid.get(i));
        }
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            result.add(temp);
            if (map.get(temp) != null) {
                for (Integer cid : map.get(temp))
                    queue.offer(cid);
            }
        }
        return result;
    }
}
/*
public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
    
    // Store process tree as an adjacency list
    Map<Integer, List<Integer>> adjacencyLists = new HashMap<>();
    for (int i=0;i<ppid.size();i++) {
        adjacencyLists.putIfAbsent(ppid.get(i), new LinkedList<>());
        adjacencyLists.get(ppid.get(i)).add(pid.get(i));
    }
    
    // Kill all processes in the subtree rooted at process "kill"
    List<Integer> res = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();
    stack.add(kill);
    while (!stack.isEmpty()) {
        int cur = stack.pop();
        res.add(cur);
        List<Integer> adjacencyList = adjacencyLists.get(cur);
        if (adjacencyList == null) continue;
        stack.addAll(adjacencyList);
    }
    return res;   

}
*/
