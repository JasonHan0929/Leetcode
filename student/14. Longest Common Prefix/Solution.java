public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        StringBuilder builder = new StringBuilder();
        int min = Integer.MAX_VALUE;
        for (String string : strs)
            min = Math.min(min, string.length());
        for (int i = 0; i < min; i++) {
            char cur = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != cur)
                    return builder.toString();
            }
            builder.append(cur);
        }
        return builder.toString();
    }
}

/*
public String longestCommonPrefix(String[] strs) {
    if(strs == null || strs.length == 0)    return "";
    String pre = strs[0];
    int i = 1;
    while(i < strs.length){
        while(strs[i].indexOf(pre) != 0)
            pre = pre.substring(0,pre.length()-1);
        i++;
    }
    return pre;
}
*/
