public class Solution {

    int[] nums;
    Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] result = Arrays.copyOf(nums, nums.length);
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            index = random.nextInt(i + 1);
            swap(result, i, index);
        }
        return result;
    }
    private void swap(int[] array, int indexA, int indexB) {
        int temp= array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }
}//仍然是reservoir sampling思想

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

/*
伪代码如下：

for (i = 0 to nums.length)
    swap(nums[randint(0, i)], nums[i])
*/
