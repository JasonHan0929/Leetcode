public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(candidates);
        backtracing(result, new LinkedList<>(), candidates, target, 0);
        return result;
    }
    public void backtracing(List<List<Integer>> result, List<Integer> temp, int[]candidates, int target, int start) {
        if (target == 0)
            result.add(new LinkedList<>(temp));
        else {
            for (int i = start; i < candidates.length; i++) {
                if (i < candidates.length -1 && candidates[i] == candidates [i + 1])
                    continue;//简单优化，减少时间复杂度
                if (candidates[i] <= target) {
                    temp.add(candidates[i]);
                    backtracing(result, temp, candidates, target - candidates[i], i);//start的作用要明白
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}
