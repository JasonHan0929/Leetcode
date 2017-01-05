public class Solution {
    public String removeKdigits(String num, int k) {
         if (num.length() <= k)
            return "0";
         StringBuilder result = new StringBuilder();
         Deque<Character> stack = new ArrayDeque<>();
         int i = 0;
         while (i < num.length()) {
             while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {//while not if
                stack.pop();
                k--;
             }
             stack.push(num.charAt(i++));
         }
         while (k > 0) {
             stack.pop();
             k--;
         }//to deall with the cases like "1111" or "1234"
         while (!stack.isEmpty())
            result.insert(0, stack.pop());
         while (result.length() > 0 && result.charAt(0) == '0')
            result.deleteCharAt(0);
         return result.length() == 0 ? "0" : result.toString();
    }
}//when num sorted like a increasing sequence it has the minium value because every digit with big value is at the least significant digit, so you should delete the digit which violates the increasing sequence
/*
public class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        //corner case
        if(k==len)        
            return "0";
            
        Stack<Character> stack = new Stack<>();
        int i =0;
        while(i<num.length()){
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        
        // corner case like "1111"
        while(k>0){
            stack.pop();
            k--;            
        }
        
        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        
        //remove all the 0 at the head
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
*/
