public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();    
        if (s.length() > 12)
            return result;
        dfs(s, 0, "", result, 0);
        return result;
    }
    public void dfs(String s, int start, String temp, List<String> result, int parts) {
        if (parts == 3 && start < s.length() && start >= s.length() - 3) {//corner case
            if (s.charAt(start) == '0' && start < s.length() - 1)
                return;
            int part = Integer.parseInt(s.substring(start, s.length()));
            if (part <= 255)
                result.add(temp.substring(1, temp.length()) + "." + part);
        } else {  
            for (int i = start; i < Math.min(s.length(), start + 3); i++) {
                if (s.charAt(start) == '0' && i > start)
                    return;
                int part = Integer.parseInt(s.substring(start, i + 1));
                if (part <= 255)
                    dfs(s, i + 1, temp + "." + part, result, parts + 1);
            }
        }
    }
}
/*
public List<String> restoreIpAddresses(String s) {
    List<String> solutions = new ArrayList<String>();
    restoreIp(s, solutions, 0, "", 0);
    return solutions;
}

private void restoreIp(String ip, List<String> solutions, int idx, String restored, int count) {
    if (count > 4) return;
    if (count == 4 && idx == ip.length()) solutions.add(restored);
    
    for (int i=1; i<4; i++) {
        if (idx+i > ip.length()) break;
        String s = ip.substring(idx,idx+i);
        if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)) continue;
        restoreIp(ip, solutions, idx+i, restored+s+(count==3?"" : "."), count+1);
    }
}
*/
