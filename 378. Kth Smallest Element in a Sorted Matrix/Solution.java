public class Solution {
    class Tuple implements Comparable<Tuple> {
        public final int x;
        public final int  y;
        public final int  val;
        
        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        
        @Override
        public int compareTo(Tuple that) {
            return val - that.val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> heap = new PriorityQueue<>();
        int len = matrix.length;
        Tuple temp = null;
        for (int i = 0; i < len; i++) 
            heap.offer(new Tuple(0, i, matrix[0][i]));
        for (int i = 0; i < k ; i++) {
            temp = heap.poll();
            if (temp.x == len - 1) continue;
            heap.offer(new Tuple(temp.x + 1, temp.y, matrix[temp.x + 1][temp.y]));
        }
        return temp.val;
    }
}
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int count = 0;
        int high = matrix[len - 1][len - 1] + 1;
        int low = matrix[0][0];
        int mid = 0;
        int target = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            target = len - 1;
            count = 0;
            for (int i = 0; i < len; i++) {
                while (target >= 0 && mid < matrix[i][target])
                    target --;
                count += target + 1;
            }
            if (count < k)
                low = mid + 1;
            else
                high = mid;//不能是high = mid - 1因为有可能要找的数就是mid
        }
        return low;//return high也可以，因为在low = high的时候while循环结束
    }
}
