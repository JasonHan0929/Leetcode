public class MinStack {
    
    Deque<Integer> minStack;
    Deque<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        minStack = new ArrayDeque<>();
        stack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        Integer min = minStack.peekFirst();
        stack.push(x);
        if (min == null || x <= min)//注意想等也要入minStack
            minStack.push(x);
    }
    
    public void pop() {
        Integer temp = stack.pop();//注意要用Integer因为peek会出现null，以及Integer间比较用equals
        if (temp != null && temp.equals(minStack.peekFirst())) 
            minStack.pop();
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public int getMin() {
        return minStack.peekFirst();
    }
}//双栈法，一个栈维护当前的最小值。可以优化成一个栈，每次存入栈与当前min的插值，或者打包成一个类，该类里有value和当前的min

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
