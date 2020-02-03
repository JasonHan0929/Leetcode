public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;
        Set<Integer> set = new TreeSet<>();
        for (int num : nums)
            set.add(num);
        Iterator<Integer> itr = set.iterator();
        int max = 0, preNum = itr.next(), curNum = -1;
        while (itr.hasNext()) {
            curNum = itr.next();
            max = Math.max(curNum - preNum, max);
            preNum = curNum;
        }
        return max;
    }
}//tree set, what is the time complexity of building the tree ?
