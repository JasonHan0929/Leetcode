public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        int n = nums.length;
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n])
                hash.put(stack.pop(), nums[i % n]);
            stack.push(i % n);//could have duplicate numbers so push the index into the stack rather than the number of that index
        }
        int result[] = new int[n];
        for (int i = 0; i < n; i++)
            result[i] = hash.getOrDefault(i, -1);
        return result;
    }
}

public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int num : nums) {
            while (!stack.isEmpty() && num > stack.peek())
                hash.put(stack.pop(), num);
            stack.push(num);
        }
        int[] result = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++)
            result[i] = hash.getOrDefault(findNums[i], -1);
        return result;
    }
}//faster
