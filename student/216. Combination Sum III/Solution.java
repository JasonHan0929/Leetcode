public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        backtracing(result, new LinkedList<>(), k, n, 1);
        return result;
    }
    public void backtracing(List<List<Integer>> result, List<Integer> temp, int k, int n, int start) {
        if (n == 0) {
            if (k == 0)//用k来控制result中结果的位数
                result.add(new LinkedList<>(temp));
            else
                return;
        }
        else {
            for (int i = start; i <= 9; i ++) {
                if (n - i >= 0) {
                    temp.add(i);
                    backtracing(result, temp, k - 1, n - i, i + 1);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}
