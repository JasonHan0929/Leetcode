public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
        	if (num <= min)
                min = num;
            else if (num <= secondMin)
                secondMin = num;
            else
                return true;
        }
        return false;
    }
}// this code could not determin the exact increasing sequence when the input is [1,2,0,3]
/*
The main idea is keep two values when check all elements in the array: the minimum value min until now and the second minimum value secondMin from the minimum value's position until now. Then if we can find the third one that larger than those two values at the same time, it must exists the triplet subsequence and return true.

What need to be careful is: we need to include the condition that some value has the same value with minimum number, otherwise this condition will cause the secondMin change its value.

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= min) min = num;
            else if(num < secondMin) secondMin = num;
            else if(num > secondMin) return true;
        }
        return false;
    }
}
The running time complexity is O(n).







In your example, the result becomes true when the second 5 comes in, at this moment the min =1, secondMin =4, which "seems" violate the increasing triplet subsequence rule.

But what I need get is just the boolean value true or false, which means I only wants to know whether there exists an increasing triplet subsequence . So, in your example [5,2,4,1,5,2,2] when the first 1 has been added, it updates the min value of course, but it has no influence on the result because there must exists an element next that larger than the secondMin value to make the result to be true. In this case is 5>4. So although the min and secondMin is not exactly the increasing triplet subsequence's element, the boolean result still can be right.
*/
