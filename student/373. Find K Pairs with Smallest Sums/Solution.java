public class Solution {
    private class Pair implements Comparable<Pair>{
        public int num1;
        public int num2;
        public int index1;
        private Pair(int num1, int num2, int index1) {
            this.num1 = num1;
            this.num2 = num2;
            this.index1 = index1;
        }
        @Override public int compareTo(Pair another) {
            return num1 + num2 - another.num1 - another.num2;
        }
        public int[] getPair() {
            return new int[]{num1, num2};
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new LinkedList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return result;
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        for (int i = 0; i < nums2.length && i < k; i++)// only maintain k elements in heap
            heap.offer(new Pair(nums1[0], nums2[i], 0));
        Pair temp;
        while (k-- > 0 && !heap.isEmpty()) {
            temp = heap.poll();
            result.add(temp.getPair());
            if (temp.index1 < nums1.length - 1)
                heap.offer(new Pair(nums1[temp.index1 + 1], temp.num2, temp.index1 + 1));//how to calculate the index of next candidates? [nums2[this specific number], nums1[current_associated_index + 1]]
        }
        return result;
    }
}
/*
Basic idea: Use min_heap to keep track on next minimum pair sum, and we only need to maintain K possible candidates in the data structure.

Some observations: For every numbers in nums1, its best partner(yields min sum) always strats from nums2[0] since arrays are all sorted; And for a specific number in nums1, its next candidate sould be nums1[this specific number] + nums2[current_associated_index + 1], unless out of boundary;)

Here is a simple example demonstrate how this algorithm works.

image

The run time complexity is O(kLogk) since que.size <= k and we do at most k loop.

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        List<int[]> res = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return res;
        for(int i=0; i<nums1.length && i<k; i++) que.offer(new int[]{nums1[i], nums2[0], 0});
        while(k-- > 0 && !que.isEmpty()){
            int[] cur = que.poll();
            res.add(new int[]{cur[0], cur[1]});
            if(cur[2] == nums2.length-1) continue;
            que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
        }
        return res;
    }
}
*/
