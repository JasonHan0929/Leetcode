class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> ugly = new ArrayList<>();
        ugly.add(1);
        int[] index = new int[3];//[index2, index3, index5]
        while (ugly.size() < n) {
            int temp2 = ugly.get(index[0]) * 2;
            int temp3 = ugly.get(index[1]) * 3;
            int temp5 = ugly.get(index[2]) * 5;
            int next = Math.min(temp2, Math.min(temp3, temp5));
            ugly.add(next);
            if (next == temp2)
                index[0]++;
            if (next == temp3)
                index[1]++;
            if (next == temp5)//do not use else if because it may has duplicate in ugly number(2 * 3 = 6, 3 * 2 = 6)
                index[2]++;
        }
        return ugly.get(n - 1);
    }
}//is this a dp solution?

/*
The idea of this solution is from this page:http://www.geeksforgeeks.org/ugly-numbers/

The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split the sequence to three groups as below:

(1) 1×2, 2×2, 3×2, 4×2, 5×2, …
(2) 1×3, 2×3, 3×3, 4×3, 5×3, …
(3) 1×5, 2×5, 3×5, 4×5, 5×5, …
We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5.

Then we use similar merge method as merge sort, to get every ugly number from the three subsequence.

Every step we choose the smallest one, and move one step after,including nums with same value.

Thanks for this author about this brilliant idea. Here is my java solution

public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }
}
*/
