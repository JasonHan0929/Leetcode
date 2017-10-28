class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (sb.length() < B.length()) {
            count++;
            sb.append(A);
        }
        if (sb.indexOf(B) != -1)
            return count;
        if (sb.append(A).indexOf(B) != -1) // to deal with rotation lik A = 'abc', B = 'bca'
            return count + 1;
        return -1;
    }
}
