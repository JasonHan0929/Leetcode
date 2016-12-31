public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        backtracing(result, new LinkedList<>(), n, k, 1);
        return result;
    }
    public void backtracing(List<List<Integer>> result, List<Integer> temp, int n, int k, int start) {
        if (k == 0)
            result.add(new LinkedList<>(temp));
        else if (k > 0){
            for (int i = start; i <= n; i++) {
                temp.add(i);
                backtracing(result, temp, n, k - 1, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
        
    }
}//backtracing

