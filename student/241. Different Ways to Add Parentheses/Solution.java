public class Solution {
    /*public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new LinkedList<>();
        if (input == null || input.length() == 0)
            return result;
        recursion(result, input);
        return result;
    }
    public void recursion (List<Integer>result, String input) {
        if (input.length() == 1) {
            result.add(Integer.valueOf(input));
            return;
        }
        for (int i = 1; i < input.length() - 1; i++) {
            if (input.charAt(i) == '*')
                recursion(result, input.substring(0, i - 1) + Integer.toString((input.charAt(i - 1) - '0') * (input.charAt(i + 1) - '0')) 
                    + input.substring(i + 2, input.length()));
            else if (input.charAt(i) == '+')
                recursion(result, input.substring(0, i - 1) + Integer.toString((input.charAt(i - 1) - '0') + (input.charAt(i + 1) - '0')) 
                    + input.substring(i + 2, input.length()));
            else if (input.charAt(i) == '-') {
                int temp = (input.charAt(i - 1) - '0') - (input.charAt(i + 1) - '0');
                if (temp < 0 && i - 2 > 0) {
                    if (input.charAt(i - 2) == '-')
                        input.charAt(i - 2) = '+';
                    else if (input.charAt(i - 2) == '+')
                        input.charAt(i - 2) = '-';
                    else if (input.charAt(i - 2 == '*')) {
                        if (input.charAt(0) == '+')
                            input.charAt(0) = '-';
                        else
                            input = '-' + input;
                    }
                }
                recursion(result, input.substring(0, i - 1) + Integer.toString(Math.abs(temp)) 
                    + input.substring(i + 2, input.length()));
            }
        }
    }*/ //wrong solution, could not deal with negitive numbers
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i < input.length() - 1; i++) {
            if (input.charAt(i) == '+' ||
                input.charAt(i) == '-' ||
                input.charAt(i) == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));//could use dp to simplify
                for (int j : left) {
                    for (int k : right) {
                        switch (input.charAt(i)) {
                            case '+' : 
                                result.add(j + k);
                                break;//every case must have a break
                            case '-' : 
                                result.add(j - k);
                                break;
                            case '*' : 
                                result.add(j * k);
                                break;
                        }
                    }
                }
            }
        }
        if (result.size() == 0)// do not use input.length() == 1 because input could be "-1" or "11"
            result.add(Integer.valueOf(input));
        return result;
    }
}
