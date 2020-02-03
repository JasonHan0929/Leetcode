public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0)
            return new int[0][0];
        Arrays.sort(people, (i, j) -> (i[0] == j[0] ? i[1] - j[1] : j[0] - i[0]));
        int[][] result = new int[people.length][people[0].length];
        List<int[]> list = new LinkedList<>();
        for (int[] arr : people)
            list.add(arr[1], arr);
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);
        return result;
    }

}
/*
Below is my explanation of the following neat solution where we sort people from tall to short (and by increasing k-value) and then just insert them into the queue using their k-value as the queue index:

def reconstructQueue(self, people):
    people.sort(key=lambda (h, k): (-h, k))
    queue = []
    for p in people:
        queue.insert(p[1], p)
    return queue
I didn't come up with that myself, but here's my own explanation of it, as I haven't seen anybody explain it (and was asked to explain it):

People are only counting (in their k-value) taller or equal-height others standing in front of them. So a smallest person is completely irrelevant for all taller ones. And of all smallest people, the one standing most in the back is even completely irrelevant for everybody else. Nobody is counting that person. So we can first arrange everybody else, ignoring that one person. And then just insert that person appropriately. Now note that while this person is irrelevant for everybody else, everybody else is relevant for this person - this person counts exactly everybody in front of them. So their count-value tells you exactly the index they must be standing.

So you can first solve the sub-problem with all but that one person and then just insert that person appropriately. And you can solve that sub-problem the same way, first solving the sub-sub-problem with all but the last-smallest person of the subproblem. And so on. The base case is when you have the sub-...-sub-problem of zero people. You're then inserting the people in the reverse order, i.e., that overall last-smallest person in the very end and thus the first-tallest person in the very beginning. That's what the above solution does, Sorting the people from the first-tallest to the last-smallest, and inserting them one by one as appropriate.

Now that's my explanation. If you have a different one, I'm interested to see it :-)
*/

/*
首先选出k值为0且身高最低的人，记为hi, ki，将其加入结果集。

然后更新队列，若队列中人员的身高≤hi，则令其k值 - 1（需要记录原始的k值）。

循环直到队列为空。

Java代码：
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int size = people.length;
        LinkedList<int[]> list = new LinkedList<int[]>();
        for (int i = 0; i < size; i++) {
            list.add(new int[]{people[i][0], people[i][1], 0});
        }
        int ans[][] = new int[size][];
        for (int i = 0; i < size; i++) {
            Collections.sort(list, new Comparator<int[]>() {
                public int compare (int[] a, int[] b) {
                    if (a[1] == b[1])
                        return a[0] - b[0];
                    return a[1] - b[1];
                }
            });
            int[] head = list.removeFirst();
            ans[i] = new int[]{head[0], head[1] + head[2]};
            for (int[] p : list) {
                if (p[0] <= head[0]) {
                    p[1] -= 1;
                    p[2] += 1;
                }
            }
        }
        return ans;
    }
}
*/
