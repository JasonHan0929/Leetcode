class Solution {
    public int shortestSubarray(int[] A, int K) {
        Deque<Integer> deque = new LinkedList<Integer>();
        int result = -1;
        int[] preSum = new int[A.length + 1];
        deque.addFirst(0); // 解决从头到第i个数这种case
        for (int i = 1; i < A.length + 1; i++) {
            preSum[i] = preSum[i - 1] + A[i - 1];
            while (!deque.isEmpty() && preSum[i] <= preSum[deque.peekLast()]) {
                deque.pollLast();
            }
            while (!deque.isEmpty() && preSum[i] - preSum[deque.peekFirst()] >= K) {
                int len = i - deque.pollFirst();
                result = result == -1 ? len : Math.min(result, len);
            }
            deque.addLast(i);
        }
        return result;
    }
}
