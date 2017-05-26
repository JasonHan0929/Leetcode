public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];// do not build final result by columns, build it by rows
        for (int i = 0; i < numRows; i++)
            sb[i] = new StringBuilder();
        char[] str = s.toCharArray();
        int len = s.length();
        int i = 0;
        while (i < len) {
            for (int row = 0; row < numRows && i < len; row++)
                sb[row].append(str[i++]);
            for (int row = numRows - 2; row >= 1 && i < len; row--)
                sb[row].append(str[i++]);
        }
        for (int row = 1; row < numRows; row++)
            sb[0].append(sb[row]);
        return sb[0].toString();
    }
}
/*
n=numRows
Δ=2n-2    1                           2n-1                         4n-3
Δ=        2                     2n-2  2n                    4n-4   4n-2
Δ=        3               2n-3        2n+1              4n-5       .
Δ=        .           .               .               .            .
Δ=        .       n+2                 .           3n               .
Δ=        n-1 n+1                     3n-3    3n-1                 5n-5
Δ=2n-2    n                           3n-2                         5n-4
that's the zigzag pattern the question asked!
Be careful with nR=1 && nR=2
*/
