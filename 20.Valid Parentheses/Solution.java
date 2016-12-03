/**
*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
*
*The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*
*Subscribe to see which companies asked this question 
*/
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() <=1) {
            return false;
        }
        String left = "([{";
        String right = ")]}";
        stack<Character> exame = new stack<>(s.length());
        for (char character : s.toCharArray()) {
            if(left.indexOf(character) != -1) 
                exame.push(character);
            else if(right.indexOf(character) != -1) {
                if (exame.isEmpty())
                    return false;
                else if (left.indexOf(exame.pop()) != right.indexOf(character)) 
                    return false;
            }
        }
     return exame.isEmpty();  
    }
}

class stack<E> {
    private int size = 0;
    private static final int Capacity = 100;
    private E[] data;
    
    public stack() {
        this(Capacity);
    }
    
    public stack(int capacity) {
        data = (E[]) new Object[capacity]; 
    }
    
    public E pop() {
        if(isEmpty())
            return null;
        E top = data[size-1];
        data[size-1] = null;
        size--;
        return top;
    }
    
    public boolean push(E input) throws IllegalStateException {
        if(size == Capacity)
            throw new IllegalStateException("This stack has no capcity.");
        E tempo = input;
        data[++size-1] = input;
        return true;
    }
    
    public E getTop() {
        if(isEmpty())
            return null;
        return data[size-1];
    }
    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public int size() {
        return size;
    }
    
}