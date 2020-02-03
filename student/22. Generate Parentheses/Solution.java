public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        backtracing(result, new StringBuilder(), n, 0);
        return result;
    }
    public void backtracing(List<String> result, StringBuilder temp, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(temp.toString());
        }
        else {
            if (right > 0) {
                temp.append(")");
                backtracing(result, temp, left, right - 1);
                temp.deleteCharAt(temp.length() - 1);
            }
            if (left > 0) {
                temp.append("(");
                backtracing(result, temp, left - 1, right + 1);
                temp.deleteCharAt(temp.length() - 1);//注意这里一定要清空，但是为什么呢？
            }
        }
    }
    
}

/*
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(result, "", 0, 0, n);
        return result;
    }
    public void backtracking(List<String> result, String temp, int leftNum, int rightNum, int n) {
        if (rightNum == leftNum && leftNum == n) {
            result.add(temp);
        } else {
            if (leftNum > rightNum)
                backtracking(result, temp + ")", leftNum, rightNum + 1, n);
            if (leftNum < n)
                backtracking(result, temp + "(", leftNum + 1, rightNum, n);
        }
    }
}//second time
*/
