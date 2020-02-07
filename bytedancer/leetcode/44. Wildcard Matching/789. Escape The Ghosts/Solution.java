class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance = getDistance(new int[]{0, 0}, target);
        for (int[] ghost : ghosts) {
            int gDistance = getDistance(ghost, target);
            if (gDistance <= distance) {
                return false;
            }
        }
        return true;
    }
    private int getDistance(int[] A, int[] B) {
        return Math.abs(A[0] - B[0]) + Math.abs(A[1] - B[1]);
    }
}
