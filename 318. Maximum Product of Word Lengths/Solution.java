public class Solution {
    public int maxProduct(String[] words) {
        if (words.length == 0)
            return 0;
        int n = words.length;
        int[] code = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < words[i].length(); j++)
                temp |= 1 << (words[i].charAt(j) - 'a');
            code[i] = temp;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((code[i] & code[j]) == 0)
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }
}//code string into intger to represent which letters it has
