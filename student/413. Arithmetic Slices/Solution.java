public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3)
            return 0;
        int dif = A[1] - A[0];
        int start = 0, end = 1;
        int result = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i + 1] - A[i] == dif)
                end++;
            else {
                if (end - start >= 2)
                    result += howMany(end - start + 1);
                dif = A[i + 1] - A[i];
                start = i;
                end = i + 1;
            }
        }
        if (end - start >= 2)//while loop could not deal with the last sequence
            result += howMany(end - start + 1);
        return result;
    }
    public int howMany(int n) {
        return (1 + (n - 2)) * (n - 2) / 2;
    }
}
/*
public int numberOfArithmeticSlices(int[] A) {
    int curr = 0, sum = 0;
    for (int i=2; i<A.length; i++)
        if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
            curr += 1;
            sum += curr;
        } else {
            curr = 0;
        }
    return sum;
}
*/
