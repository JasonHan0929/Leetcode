public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder builder = new StringBuilder();
        int count = K;
        for (int i = S.length() - 1; i >= 0; i--) {
            char temp = S.charAt(i);
            if (temp == '-')
                continue;
            else if (Character.isAlphabetic(temp))
                builder.append(Character.toUpperCase(temp));
            else
                builder.append(temp);
            if (--count == 0) {
                count = K;
                builder.append('-');
            }
        }
        if (builder.length() > 0 && builder.charAt(builder.length() - 1) == '-')
            builder.deleteCharAt(builder.length() - 1);
        return builder.reverse().toString();
    }
}

public class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != '-')
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
        return sb.reverse().toString().toUpperCase();
    } 
}
