class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        if (i >= candidates.length || target < candidates[i]) return;
        for (int j = i; j < candidates.length; j++) {
            if (j > i && candidates[j] == candidates[j - 1]) continue;// deal with duplicates
            temp.add(candidates[j]);
            dfs(candidates, j + 1, target - candidates[j], result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
