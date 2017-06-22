public class Solution {
    public String complexNumberMultiply(String a, String b) {
        return getResult(parseInput(a), parseInput(b));
    }
    public int[] parseInput(String input) {
        int[] result = new int[2];
        int sign = 1;
        int i = 0;
        for (int j = 0; j < input.length(); j++) {
            if (input.charAt(j) == '-')
                sign = -1;
            else if (Character.isDigit(input.charAt(j))) {
                int temp = 0;
                while (Character.isDigit(input.charAt(j))) {
                    temp = 10 * temp + input.charAt(j) - '0';
                    j++;
                }
                result[i] = sign * temp;
                sign = 1;
                i++;
            }
        }
        return result;
    }
    public String getResult(int[] a, int[] b) {
        int real = a[0] * b[0] - a[1] * b[1];
        int img = a[0] * b[1] + a[1] * b[0];
        return String.format("%d+%di", real, img);
    }
}
/*
public class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] valA = getValue(a);
        int[] valB = getValue(b);
        
        int real = valA[0] * valB[0] - valA[1] * valB[1];
        int img = valA[0] * valB[1] + valA[1] * valB[0];
        
        return real + "+" + img + "i";
    }
    
    private int[] getValue(String s) {
        String[] str = s.split("\\+");
        int[] val = new int[2];
        val[0] = Integer.valueOf(str[0]);
        int indexOfI = str[1].indexOf("i");
        val[1] = Integer.valueOf(str[1].substring(0, indexOfI));
        
        return val;
    }
}
*/
