import java.util.*;

public class Solution{
    public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String readline = scanner.nextLine();
        String[] temp = readline.split(" ");
        System.out.print(output(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2])));
    }
    public static String output(int N, int p, int q) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (check(i, p, q) && (i % p == 0 || i % q == 0))
                result.append("OUTTHINK,");
            else if (check(i, p , q))
                result.append("THINK,");
            else if (i % q == 0 || i % p == 0)
                result.append("OUT,");
            else
                result.append(Integer.toString(i) + ",");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
    public static boolean check(int num, int p, int q) {
        while (num > 0) {
            int digit = num % 10;
            if (digit == p || digit == q)
                return true;
            num = num / 10;
        }
        return false;
    }
}


