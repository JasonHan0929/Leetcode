//because every value in the nums is different from others, so each node of the graph couldonly be arrived one times except the start node. That means this graph could only has circles.
public class Solution {
    public int arrayNesting(int[] nums) {
        int len = nums.length;
        boolean[] visited = new boolean[len];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (visited[i])
                continue;
            int count = 0, index = i;
            while (!visited[nums[index]]) {
                index = nums[index];
                visited[index] = true;
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
/*
public int arrayNesting(int[] nums) {
    int res = 0;
    for (int i=0;i<nums.length;i++) {
        if (nums[i] < 0) continue;
        int length = 1, val = nums[i];
        while (Math.abs(val) != i) {
            length++;
            val = nums[Math.abs(val)];
            nums[Math.abs(val)] *= -1;
        }
        res = Math.max(res, length);
    }
    return res;
}
*/
