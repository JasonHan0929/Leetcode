public class Solution {
    public String toHex(int num) {
        if (num == 0)
            return "0";
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < 32) {
            int temp = 0;
            for (int j = 0; j < 4; j++)
                temp += ((num & (1 << (31 - i - j))) == (1 << (31 - i - j)) ? 1 : 0) * (int)Math.pow(2, 3 - j);
            switch (temp) {
                case 15:
                    builder.append("f");
                    break;
                case 14:
                    builder.append("e");
                    break;
                case 13:
                    builder.append("d");
                    break;
                case 12:
                    builder.append("c");
                    break;
                case 11:
                    builder.append("b");
                    break;
                case 10:
                    builder.append("a");
                    break;
                default:
                    builder.append(Integer.toString(temp));
            }
            i += 4;
        }
        i = 0;
        while (i < builder.length() && builder.charAt(i) == '0')
            i++;
        if (i != 0)
            builder.delete(0, i);
        return builder.toString();
    }
}

public class Solution {
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    
    public String toHex(int num) {
        if(num == 0) return "0";
        StringBuilder result = new StringBuilder();
        while(num != 0){
            result = result.insert(0, map[(num & 15)]); 
            num = (num >>> 4);
        }
        return result.toString();
    }
}//simple

public class Solution {
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        do {
            int n = num & 0xf;
            n += n < 0xa ? '0' : 'a' - 10;
            sb.append((char)n);
        } while ((num >>>= 4) != 0); 
        return sb.reverse().toString();
    }
}// Niu B
