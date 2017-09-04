class Solution {
    public String convertToTitle(int n) {
        if (n <= 26)
            return String.valueOf((char)('A' - 1 + n));
        else
            return convertToTitle((n - 1) / 26) + convertToTitle(n % 26 == 0 ? 26 : n % 26);// corner case for n % 26
    }
/*
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char)('A' + n % 26));
            n /= 26;
        }
        return sb.reverse().toString();
    }
*/
}
