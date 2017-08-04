public class Solution {
    public boolean checkRecord(String s) {
        if (s == null || s.length() == 0)
            return false;
        int countA = 0;
        int countL = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == 'L')
                countL++;
            else {
                if (temp == 'A')
                    countA++;
                countL = 0;
            }
            if (countL == 3 || countA > 1)
                return false;
        }
        return true;
    }
}

/*
public class Solution {
    public boolean checkRecord(String s) {
        if(s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"))
            return false;
        return true;
    }
}
*/

/*
public boolean checkRecord(String s) {
    return !s.matches(".*LLL.*|.*A.*A.*");
}
*/
