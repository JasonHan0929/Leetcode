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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<>(intervals);
        result.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        int i = 0;
        while (i < result.size() - 1) {
            Interval next = result.get(i + 1);
            Interval curr = result.get(i);
            if (next.start <= curr.end) {
                next.start = curr.start;
                next.end = Math.max(curr.end, next.end);
                result.remove(i);//more faster than reulst.remove(curr)
            }
            else
                i++;
        }
        return result;
    }
}// not a O(n) solution

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;
        List<Interval> result = new LinkedList<>();
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        int i = 1;
        int j = 0;
        result.add(intervals.get(0));
        while (i < intervals.size()) {
            Interval next = intervals.get(i);
            Interval curr = result.get(j);
            if (next.start <= curr.end) {
                curr.end = Math.max(curr.end, next.end);
                i++;
            }
            else {
                result.add(next);
                j++;
            }
        }
        return result;
    }
}//O(n) but using extra space

/*
The idea is to sort the intervals by their starting points. Then, we take the first interval and compare its end with the next intervals starts. As long as they overlap, we update the end to be the max end of the overlapping intervals. Once we find a non overlapping interval, we can add the previous "extended" interval and start over.

Sorting takes O(n log(n)) and merging the intervals takes O(n). So, the resulting algorithm takes O(n log(n)).

I used an a lambda comparator (Java 8) and a for-each loop to try to keep the code clean and simple.

public List<Interval> merge(List<Interval> intervals) {
    if (intervals.size() <= 1)
        return intervals;
    
    // Sort by ascending starting point using an anonymous Comparator
    intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
    
    List<Interval> result = new LinkedList<Interval>();
    int start = intervals.get(0).start;
    int end = intervals.get(0).end;
    
    for (Interval interval : intervals) {
        if (interval.start <= end) // Overlapping intervals, move the end if needed
            end = Math.max(end, interval.end);
        else {                     // Disjoint intervals, add the previous one and reset bounds
            result.add(new Interval(start, end));
            start = interval.start;
            end = interval.end;
        }
    }
    
    // Add the last interval
    result.add(new Interval(start, end));
    return result;
}
*/
