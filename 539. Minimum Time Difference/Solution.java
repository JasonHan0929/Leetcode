public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            String[] temp = timePoints.get(i).split(":");
            time[i] = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        }
        Arrays.sort(time);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++)
            min = Math.min(min, time[i + 1] - time[i]);
        min = Math.min(24*60 + time[0] - time[n - 1], min);//pay attention
        return min;
    }
}

/*
There is only 24 * 60 = 1440 possible time points. Just create a boolean array, each element stands for if we see that time point or not. Then things become simple...

public class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] mark = new boolean[24 * 60];
        for (String time : timePoints) {
            String[] t = time.split(":");
            int h = Integer.parseInt(t[0]);
            int m = Integer.parseInt(t[1]);
            if (mark[h * 60 + m]) return 0;
            mark[h * 60 + m] = true;
        }
        
        int prev = 0, min = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for (int i = 0; i < 24 * 60; i++) {
            if (mark[i]) {
                if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }
        
        min = Math.min(min, (24 * 60 - last + first));
        
        return min;
    }
}
*/
