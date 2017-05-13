public class Solution {
    public String simplifyPath(String path) {
        if (path == null)
            return path;
        String[] splitArray = path.split("/");
        Deque<String> deque = new LinkedList<>();
        for (String str : splitArray) {
            String temp = str.trim();
            if(temp.length() > 0) {
                if(temp.equals("..")) {
                    deque.pollLast();
                } else if (temp.equals(".")) {
                    continue;
                } else {
                    deque.offerLast(temp);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while(!deque.isEmpty()) {
            result.append("/").append(deque.pollFirst());
        }
        return result.length() > 0 ? result.toString() : result.append("/").toString();
    }
}
/*
Hi guys!

The main idea is to push to the stack every valid file name (not in {"",".",".."}), popping only if there's smth to pop and we met "..". I don't feel like the code below needs any additional comments.

public String simplifyPath(String path) {
    Deque<String> stack = new LinkedList<>();
    Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
    for (String dir : path.split("/")) {
        if (dir.equals("..") && !stack.isEmpty()) stack.pop();
        else if (!skip.contains(dir)) stack.push(dir);
    }
    String res = "";
    for (String dir : stack) res = "/" + dir + res;
    return res.isEmpty() ? "/" : res;
}
Hope it helps!
*/
