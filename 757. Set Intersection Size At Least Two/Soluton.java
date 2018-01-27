/*class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        int[] overlap = {Integer.MIN_VALUE, Integer.MAX_VALUE};
        int count = 0;
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(overlap));
            System.out.println(count);
            if (interval[0] <= overlap[1]) {
                int newLeft = Math.max(overlap[0], interval[0]);
                int newRight = Math.min(overlap[1], interval[1]);
                if (newLeft == newRight) {
                    if (overlap[0] != overlap[1]) count += 2; // [[1,2], [2,3], [2, 4]]
                    else count += 1;
                    overlap[0] = interval[0] + 1;
                    overlap[1] = interval[1];
                } else {
                    overlap[0] = newLeft;
                    overlap[1] = newRight;
                }
            } else {
                count += 2;
                overlap[0] = interval[0];
                overlap[1] = interval[1];
            }
        }
        System.out.println(Arrays.toString(overlap));
        return count + 2;
    }
}*/ // wrong answer

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[1], y[1]));
        int max1 = -1, max2 = -1;
        int count = 0;
        for (int[] interval : intervals) {
            if (interval[0] > max1) {
                count += 2;
                max1 = interval[1];
                max2 = max1 - 1;
            } else if (interval[0] > max2) {
                count += 1;
                max2 = max1 == interval[1] ? max1 - 1 : max1; // pay attention to this check
                max1 = interval[1];
            } // else, this interval could be represented by the previous {max1, max2}
        }
        return count;
    }
} // greedy, always choose the biggest num you could choose to represent an interval
