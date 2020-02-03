public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<Integer>();
        }
        int counterA = 0;
        int counterB = 0;
        Integer numA = nums[0];
        Integer numB = nums[0];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == numA) {
                counterA++;
            }
            else if (nums[i] == numB) {
                counterB++;
            }
            else if (counterA == 0) {
                numA = nums[i];
                counterA = 1;
            }
            else if (counterB == 0) {
                numB = nums[i];
                counterB = 1;
            }
            else {
                counterA--;
                counterB--;
            }
        }
        counterA = 0;
        counterB = 0;
        for (int number : nums) {
            if (number == numA)
                counterA++;
            else if(number == numB)
                counterB++;
        }
        if (counterA >= (nums.length / 3 + 1))
            result.add(numA);
        if(counterB >= (nums.length / 3 + 1))
            result.add(numB);
        return result;
    }
}
