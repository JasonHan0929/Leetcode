public class MyStack {

    Queue<Integer> stack;
    
    public MyStack() {
        stack = new LinkedList<>();
    }
    
    public void push(int x) {
        stack.add(x);
        for (int i = 0; i < stack.size() - 1; i++)//stack.size() - 1 not stack.size()
            stack.add(stack.poll());
    }
    
    public int pop() {
        return stack.poll();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}// push() is O(n)

public class MyStack {

    /** Initialize your data structure here. */
    
    Queue<Integer> q1;
    Queue<Integer> q2;
    
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        Queue<Integer> noneEmpty = q1.isEmpty() ? q2 : q1;
        noneEmpty.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> noneEmpty = q1.isEmpty() ? q2 : q1;
        Queue<Integer> empty = noneEmpty == q1 ? q2 : q1;
        int size = noneEmpty.size();
        for (int i = 0; i < size - 1; i++)
            empty.offer(noneEmpty.poll());
        return noneEmpty.poll();
    }
    
    /** Get the top element. */
    public int top() {
        Queue<Integer> empty = q1.isEmpty() ? q1 : q2;
        int result = pop();
        empty.offer(result);
        return result;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}// pop()/top() is O(n)

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
