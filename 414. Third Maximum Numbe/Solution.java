public class Solution {
    public int thirdMax(int[] nums) {
        Integer firstMax = null;
        Integer secondMax = null;
        Integer thirdMax = null;
        
        for (Integer numbers : nums) {
            if (numbers.equals(firstMax) || numbers.equals(secondMax) || numbers.equals(thirdMax)) 
                continue;
            if (firstMax  == null || numbers > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = numbers;
            }
            else if (secondMax == null || numbers > secondMax) {
                thirdMax = secondMax;
                secondMax = numbers;
            }
            else if (thirdMax == null || numbers > thirdMax) {
                thirdMax = numbers;
            }
        }
        return (thirdMax == null ? firstMax : thirdMax);
    }
}
