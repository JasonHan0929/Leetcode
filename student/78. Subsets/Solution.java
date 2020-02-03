public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tempo = new ArrayList<Integer>(); 
        for (long i = 0; i < (1 << nums.length); i++) {
            for (long j = 0; j < nums.length; j++) {
                if (((i >>> j) & 1) == 1)//注意向左移
                    tempo.add(nums[(int)j]);
            }
            result.add(new ArrayList<Integer>(tempo));//注意传的是引用
            tempo.clear();
        }
        return result;
    }
}//还可以用回溯
