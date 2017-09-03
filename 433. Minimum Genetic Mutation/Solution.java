public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int level = 0;
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        queue.add(start);
        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                visited.add(curr);
                if (curr.equals(end))
                    return level;
                char[] currArray = curr.toCharArray();//String is immutable so you should turn it into an array
                for (int i = 0; i < currArray.length; i++) {
                    char old = currArray[i];
                    for (char c : charSet) {
                        currArray[i] = c;
                        String next = new String(currArray);
                        if (bankSet.contains(next) && !visited.contains(next))
                            queue.offer(next);
                    }
                    currArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }
}//BFS

/*
    static int findMutationDistance(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String sequence : bank) {
            bankSet.add(sequence);
        }
        bankSet.remove(start);
        if (!bankSet.contains(end)) {
            return -1;
        } else if (start.equals(end)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        queue.add(start);
        int level = 0;
        int size = 0;
        char[] currArray = null;
        while (queue.size() > 0) {
            size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                if (curr.equals(end)) {
                    return level;
                }
                currArray = curr.toCharArray();
                for (int i = 0; i < currArray.length; i++) {
                    char old = currArray[i];
                    for (char c : charSet) {
                        if (c == currArray[i]) {
                            continue;
                        }
                        currArray[i] = c;
                        String next = new String(currArray);
                        if (bankSet.contains(next)) {
                            queue.offer(next);
                            bankSet.remove(next);
                        }
                    }
                    currArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }//use less time because do not maintain the vistied set
*/
