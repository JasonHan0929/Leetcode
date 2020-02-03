public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> mapAB = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j ++) {
                mapAB.put(A[i] + B[j], mapAB.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                count += mapAB.getOrDefault(-(c + d), 0);
            }
        }
        return count;
    }
}//只需一个hashmap就好
