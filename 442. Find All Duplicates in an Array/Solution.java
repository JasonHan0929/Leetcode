public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0)
                result.add(Math.abs(nums[i]));
            else
                nums[Math.abs(nums[i]) - 1] *= -1;
        }
        return result;
    }
}//遍历一遍就好，希望先×-1然后再找正数这个思路在[1,1]这种类型会出错


解法II 位置交换法

遍历nums，记当前下标为i

当nums[i] > 0 并且 nums[i] != i + 1时，执行循环：

令n = nums[i]

如果n == nums[n - 1]，则将n加入答案，并将nums[i]置为0

否则，交换nums[i], nums[n - 1]
Python代码：
class Solution(object):
    def findDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ans = []
        for i in range(len(nums)):
            while nums[i] and nums[i] != i + 1:
                n = nums[i]
                if nums[i] == nums[n - 1]:
                    ans.append(n)
                    nums[i] = 0
                else:
                    nums[i], nums[n - 1] = nums[n - 1], nums[i]
        return ans
