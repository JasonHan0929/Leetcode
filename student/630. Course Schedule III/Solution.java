class Solution {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        Arrays.sort(courses, (x, y) -> Integer.compare(x[1], y[1]));
        int time = 0;
        for (int[] course : courses) {
            queue.add(course[0]);
            time += course[0];
            if (time > course[1])
                time -= queue.poll();
        }
        return queue.size();
    }
}// maximum unoverlapping interval

/*
public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]); //Sort the courses by their deadlines (Greedy! We have to deal with courses with early deadlines first)
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int time=0;
        for (int[] c:courses) 
        {
            time+=c[0]; // add current course to a priority queue
            pq.add(c[0]);
            if (time>c[1]) time-=pq.poll(); //If time exceeds, drop the previous course which costs the most time. (That must be the best choice!)
        }        
        return pq.size();
    }
}
*/
