public class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0 || A.length == 1)
            return 0;
        int sum = 0;
        int F = 0;
        int i = 0;
        int n = A.length;
        for (int number : A) {
            sum += number;
            F += i * number;
            i++;
        }
        int result = F;
        for (i = 1; i < n; i++) {
            F += sum - n * A[n - i];
            result = Math.max(result, F);
        }
        return result;
    }
}//推导递推公式
