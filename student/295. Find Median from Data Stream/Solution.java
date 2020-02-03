public class MedianFinder {
    
    PriorityQueue<Long> large, small;
    /** initialize your data structure here. */
    public MedianFinder() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.offer(-(long)num);
        large.offer(-small.poll());
        if (large.size() > small.size())
            small.offer(-large.poll());//small.size() == large.size() or large.size() + 1
    }
    
    public double findMedian() {
        return small.size() > large.size() ? -small.peek() : (large.peek() - small.peek()) / 2.0;//2.0 not 2 to otherwise the return value will be integer and lose accuracy
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

/*
The basic idea is to maintain two heaps: a max-heap and a min-heap. The max heap stores the smaller half of all numbers while the min heap stores the larger half. The sizes of two heaps need to be balanced each time when a new number is inserted so that their size will not be different by more than 1. Therefore each time when findMedian() is called we check if two heaps have the same size. If they do, we should return the average of the two top values of heaps. Otherwise we return the top of the heap which has one more element.

To do that, we first need to add two PriorityQueues to the class as the max-heap and min-heap:

    private PriorityQueue<Integer> minH;
    private PriorityQueue<Integer> maxH;
We then define the constructor of the class so that the PriorityQueues get initialized. By default, the sorting order of a PriorityQueue is natural order which means it is a min-heap by default. Hence we need to provide a new Comparator to the constructor of the max heap to specify the reversed order.

    MedianFinder(){
        minH = new PriorityQueue<Integer>();
        maxH = new PriorityQueue<Integer>(1, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                if (o1.intValue()>o2.intValue()) return -1;
                if (o1.intValue()<o2.intValue()) return 1;
                return 0;
            }
        });
    }
Now we have the data structure properly built. Let's write the addNum() function next.

    public void addNum(int num) {
        if ((minH.size()==0)&&(maxH.size()==0)) minH.add(num);
        else if ((minH.size())>(maxH.size())) {
            if (num>minH.peek()) {
                maxH.add(minH.poll());
                minH.add(num);
            } else maxH.add(num);
        } else if ((minH.size())<(maxH.size())) {
            if (num<maxH.peek()) {
                minH.add(maxH.poll());
                maxH.add(num);
            } else minH.add(num);            
        } else {
            if (num<maxH.peek()) maxH.add(num);
            else minH.add(num);             
        }
    }
There are several possible situations when a new number is inserted:

1)If both heap are empty, meaning that we are inserting the first number, we just arbitrarily inserted it into a heap, let's say, the min-heap.

2)If min-heap has more elements (later we will argue that the size won't be different by more than 1), we need to compare the new number with the top of the min-heap. If it is larger than that, then the new number belongs to the larger half and it should be added to the min-heap. But since we have to balance the heap, we should move the top element of the min-heap to the max-heap. For the min-heap, we inserted a new number but removed the original top, its size won't change. For the max-heap, we inserted a new element (the top of the min-heap) so its size will increase by 1.

3)If max-heap has more elements, we did the similar thing as 2).

4)If they have the same size, we just compare the new number with one of the top to determine which heap the new number should be inserted. We just simply inserted it there.

It can be seen that for each insertion if it was in situation 1) and 4), then after insertion the heap size difference will be 1. For 2) and 3), the size of the heap with fewer element will increase by 1 to catch up with the heap with more elements. Hence their sizes are well-balanced and the difference will never exceeds 1.

Obviously, the median will be the top element of the heap which has one more element (if max-heap and min-heap have different sizes), or the average of the two tops (if max-heap and min-heap have equal sizes). So the findMedian() function is very straightforward:

    // Returns the median of current data stream
    public double findMedian() {
        if ((minH.size()==0)&&(maxH.size()==0)) return 0.0;
        if ((minH.size())>(maxH.size())) return (double)(minH.peek());
        if ((minH.size())<(maxH.size())) return (double)(maxH.peek());
        return ((double)(maxH.peek()+minH.peek()))/2.0;
    }
The entire codes are here:

class MedianFinder {
    private PriorityQueue<Integer> minH;
    private PriorityQueue<Integer> maxH;
    
    MedianFinder(){
        minH = new PriorityQueue<Integer>();
        maxH = new PriorityQueue<Integer>(1, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                if (o1.intValue()>o2.intValue()) return -1;
                if (o1.intValue()<o2.intValue()) return 1;
                return 0;
            }
        });
    }
    
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        if ((minH.size()==0)&&(maxH.size()==0)) minH.add(num);
        else if ((minH.size())>(maxH.size())) {
            if (num>minH.peek()) {
                maxH.add(minH.poll());
                minH.add(num);
            } else maxH.add(num);
        } else if ((minH.size())<(maxH.size())) {
            if (num<maxH.peek()) {
                minH.add(maxH.poll());
                maxH.add(num);
            } else minH.add(num);            
        } else {
            if (num<maxH.peek()) maxH.add(num);
            else minH.add(num);             
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if ((minH.size()==0)&&(maxH.size()==0)) return 0.0;
        if ((minH.size())>(maxH.size())) return (double)(minH.peek());
        if ((minH.size())<(maxH.size())) return (double)(maxH.peek());
        return ((double)(maxH.peek()+minH.peek()))/2.0;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
*/
