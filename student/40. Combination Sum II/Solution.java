public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        backtracing(result, new LinkedList<>(), candidates, target, 0, 1);
        return result;
    }
    public void backtracing(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int start, int count) {
        if (target == 0)
            result.add(new LinkedList<>(temp));
        else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] != candidates[i - 1])
                    count = 1;//注意对count的还原
                if (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                    count++;
                    continue;
                }
                if (target - candidates[i] >= 0) {
                    temp.add(candidates[i]);
                    if (count > 1)
                        backtracing(result, temp, candidates, target - candidates[i], i, --count);
                    else
                        backtracing(result, temp, candidates, target - candidates[i], i + 1, count);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}//其实不用count，弄复杂了

public List<List<Integer>> combinationSum2(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
    
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(tempList));
    else{
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates//只用考虑同样的位置不循环出现同样的元素即可
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i + 1);
            tempList.remove(tempList.size() - 1); 
        }
    }
}//
