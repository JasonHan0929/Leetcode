public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int head = -1;
        int tail = nums.length;
        int cur = 0;
        int tempo;
        while (cur < tail) {
            switch (nums[cur]) {
//注意不是每次cur都要该改变的，因为head后到cur是已经检验过的所以case 0 cur要++，但是case 2不行
                case 0 :
                    head++;
                    switchArray(nums, cur, head);
                    cur++;
                    break;
                case 1 : 
                    cur++;
                    break;
                case 2 :
                    tail--;
                    switchArray(nums, cur, tail);
                    break;
            }
        }
    }
    public void switchArray(int[]nums, int from, int to) {
        int tempo = nums[from];
        nums[from] = nums[to];
        nums[to] = tempo;
    }
}
