public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int digit = 1 << i;
            for (int num : nums) {
                int temp = num & digit;
                if (temp == digit)
                    count++;
            }
            if (count % 3 == 1)
                result = result | digit;
            count = 0;
        }
        return result;
    }
}//统计每一位出现1的个数，若他能被3正处，说明single number在这一位的值为0,若余1说明在这一位值为1
