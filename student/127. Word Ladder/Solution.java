public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int length = 1;
        if (beginWord.equals(endWord))
            return length;
        //Set<String> words = new HashSet<>(wordList);//do not build a new set since once the size of wordList is very big, it will exceed the limit time
        //Set<String> visited = new HashSet<>();//no need for visited map once you remove temp from the given set every time you offer it in the queue
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                //visited.add(curr);
                if (curr.equals(endWord))
                    return length;
                for (int i = 0; i < curr.length(); i++) {
                    for (char change = 'a'; change <= 'z'; change++) {
                        char[] array = curr.toCharArray();
                        array[i] = change;
                        String temp = new String(array);
                        //if (!visited.contains(temp) && words.contains(temp))
                        if (!curr.equals(temp) && wordList.contains(temp))
                            queue.offer(temp);
                            wordList.remove(temp);// to avoid a visited set
                    }
                }
            }
            length++;
        }
        return 0;
    }
}
