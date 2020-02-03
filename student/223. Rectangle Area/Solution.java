public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E);
        int right = Math.max(Math.min(C, G), left);
        int bottom = Math.max(B, F);
        int up = Math.max(Math.min(D, H), bottom);
        return (C - A) * (D - B) + (G - E) * (H - F) - (up - bottom) * (right -left);
    }
}// pay attention to how to avoid the wrong answer when there is no arean overlapped
