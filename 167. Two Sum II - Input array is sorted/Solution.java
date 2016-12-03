public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int tail = numbers.length - 1;
        int head = 0;
        int sum = 0;
        int[] result = new int[2];
        while (tail > head) {
            sum = numbers[head] + numbers[tail];
            if (sum == target) {
                result[0] = head + 1;
                result[1] = tail + 1;
                return result;
            }
            else if (sum > target) {
                tail--;
                while (tail < numbers.length - 1 && numbers[tail] == numbers[tail + 1])
                tail--;
            }
            else {
                head++;
                while (head > 0 && numbers[head] == numbers[head - 1])
                    head++;
            }
        }
        return result;
    }
}
