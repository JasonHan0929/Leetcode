public class MyQueue {

    /** Initialize your data structure here. */
    Deque<Integer> outputStack;
    Deque<Integer> inputStack;
    
    public MyQueue() {
        outputStack = new LinkedList<>();
        inputStack = new LinkedList<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        inputStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int result = peek();
        outputStack.pop();
        return result;
    }
    
    /** Get the front element. */
    public int peek() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty())
                outputStack.push(inputStack.pop());
        }
        return outputStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


/*
I have one input stack, onto which I push the incoming elements, and one output stack, from which I peek/pop. I move elements from input stack to output stack when needed, i.e., when I need to peek/pop but the output stack is empty. When that happens, I move all elements from input to output stack, thereby reversing the order so it's the correct order for peek/pop.

The loop in peek does the moving from input to output stack. Each element only ever gets moved like that once, though, and only after we already spent time pushing it, so the overall amortized cost for each operation is O(1).
*/
