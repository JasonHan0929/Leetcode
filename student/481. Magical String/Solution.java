public class Solution {
    public int magicalString(int n) {
        if (n < 1)
            return 0;
        int result = 1;
        int[] magic = new int[n];
        int countPointer = 0;
        int stringPointer = 1;
        magic[0] = 1;
        int cur = 1;
        int count = magic[0] - 1;
        while (stringPointer < n) {
            if(count == 0) {
                magic[stringPointer] = cur == 1 ? 2 : 1;
                countPointer++;
                count = magic[countPointer] - 1;
                cur = cur == 1 ? 2 : 1;
            }
            else {
                magic[stringPointer] = cur;
                count--;
            }
            if (magic[stringPointer] == 1)
                result++;
            stringPointer++;
        }
        return result;
    }
}//find the rule between count and the content of the string
