class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int m = num1.length(), n = num2.length();
        int[] digits = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {//starting from i = 0 will have problem 
            for (int j = n - 1; j >= 0; j--) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int index1 = m - 1 - i, index2 = n - 1 - j;
                int position1 = (m + n -1) - (index1 + index2), position2 = (m + n -1) - (index1 + index2 + 1);
                temp += digits[position1];
                digits[position1] = temp % 10;
                digits[position2] += temp / 10;
            }//index transition and carry bit manipulation
        }
        StringBuilder result = new StringBuilder();
        if (digits[0] != 0)
            result.append(digits[0]);
        for (int i = 1; i < m + n; i++)
            result.append(digits[i]);
        return result.toString();
    }
}

/*
Remember how we do multiplication?

Start from right to left, perform multiplication on every pair of digits, and add them together. Let's draw the process! From the following draft, we can immediately conclude:

 `num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]` 
Multiplication

https://discuss.leetcode.com/topic/30508/easiest-java-solution-with-graph-explanation


Here is my solution. Hope it helps!

public String multiply(String num1, String num2) {
    int m = num1.length(), n = num2.length();
    int[] pos = new int[m + n];
   
    for(int i = m - 1; i >= 0; i--) {
        for(int j = n - 1; j >= 0; j--) {
            int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
            int p1 = i + j, p2 = i + j + 1;
            int sum = mul + pos[p2];

            pos[p1] += sum / 10;
            pos[p2] = (sum) % 10;
        }
    }  
    
    StringBuilder sb = new StringBuilder();
    for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
    return sb.length() == 0 ? "0" : sb.toString();
}
*/
