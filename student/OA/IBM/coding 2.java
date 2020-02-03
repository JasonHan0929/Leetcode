import java.util.*;

public class Try{
    private static class Pair {
        private final String original;
        private final String modified;
        private Pair(String original, String modified) {
            this.original = original;
            this.modified = modified;
        }
    }
    public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String[] temp = scanner.nextLine().split("\\|");
        List<String> valid = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].trim().length() > 0)
                valid.add(temp[i]);
        }
        String[] input = new String[valid.size()];
        valid.toArray(input);
        System.out.print(output(input));
    }
    public static String modify(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char temp = Character.toLowerCase(str.charAt(i));
            if (Character.isDigit(temp) || Character.isAlphabetic(temp))
                result.append(temp);
            else if (result.length() > 0 && result.charAt(result.length() - 1) != ' ' && temp == ' ')
                result.append(temp);
        }
        return result.toString();
    }
    public static String output(String[] input) {
        StringBuilder result = new StringBuilder();
        if (input.length == 0)
            return "";
        int len = input.length;
        Pair[] modifiedToOrigin = new Pair[len];
        for (int i = 0; i < len; i++)
            modifiedToOrigin[i] = new Pair(input[i], modify(input[i]));
        for (int i = 0; i < len; i++) {
            boolean addOrNot = true;
            for (int j = 0; j < len; j++) {
                if (j == i)
                    continue;
                String state = KMP(modifiedToOrigin[j].modified, modifiedToOrigin[i].modified);
                if (state.equals("contain")) {
                    addOrNot = false;
                    break;
                }
                else if (state.equals("equal")) {
                    if (modifiedToOrigin[i].original.length() > modifiedToOrigin[j].original.length()
                            || (modifiedToOrigin[i].original.length() == modifiedToOrigin[j].original.length() && i > j))
                        addOrNot = false;
                }
            }
            if (addOrNot) {
                result.append(modifiedToOrigin[i].original);
                result.append("|");
            }
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
    public static String KMP(String a, String b) {
        int[] next = getNext(b);
        return check(a, b, next);
    }
    public static int[] getNext(String str) {
        int len = str.length();
        int[] next = new int[len + 1];
        int j = 0;
        for (int i = 1; i < len; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j))
                j = next[j];
            if (str.charAt(i) == str.charAt(j))
                j++;
            next[i + 1] = j;
        }
        return next;
    }
    public static String check(String a, String b, int[] next) {
        if (a.length() < b.length())
            return "differ";
        int j = 0;
        for (int i = 0; i < a.length(); i++) {
            while (j > 0 && a.charAt(i) != b.charAt(j))
                j = next[j];
            if (a.charAt(i) == b.charAt(j))
                j++;
            if (j == b.length()) {
                if (a.length() != b.length())
                    return "contain";
                else
                    return "equal";
            }
        }
        return "differ";
    }
}


