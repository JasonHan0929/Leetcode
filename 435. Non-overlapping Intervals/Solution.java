/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (x, y) -> x.start - y.start);
        int endTime = intervals[0].end;
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < endTime) {
                count++;
                endTime = Math.min(intervals[i].end, endTime);
            }
            else
                endTime = intervals[i].end; 
        }
        return count;
    }
}//very slow

/*First we sort the array by below rules

1) sort by end, smaller end in front
2) if end is same, sort by start, bigger start in front
Then, visited array by end. If we visited next closest end interval, access the bigger start priority.

public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.end != o2.end) return o1.end - o2.end;  //first sort by end
                return o2.start - o1.start;  //second sort by start, could be omitted
            }
        });

        int end = Integer.MIN_VALUE;
        int count = 0;
        for (Interval interval : intervals) {
            if (interval.start >= end) end = interval.end;
            else count++;
        }

        return count;
    }//much faster

public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;  //first sort by end
            }
        });

        int end = Integer.MIN_VALUE;
        int count = 0;
        for (Interval interval : intervals) {
            if (interval.start >= end) end = interval.end;
            else count++;
        }

        return count;
    }//also could pass
*/
