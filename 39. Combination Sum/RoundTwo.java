class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, result, new ArrayList<>());
        return result;
    }
    public void dfs(int[] candidates, int i, int target, List<List<Integer>> result, List<Integer> temp) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (target < candidates[i]) return;
        for (int j = i; j < candidates.length; j++) {
            temp.add(candidates[j]);
            dfs(candidates, j, target - candidates[j], result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
