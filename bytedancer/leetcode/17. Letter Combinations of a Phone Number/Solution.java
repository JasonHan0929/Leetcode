class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        String[] dict = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder builder = new StringBuilder();
        List<String> result = new ArrayList<String>();
        dfs(builder, result, dict, 0, digits);
        return result;
    }
    private void dfs(StringBuilder builder, List<String> result, String[] dict, int i, String digits) {
        if (i == digits.length()) {
            result.add(builder.toString());
            return;
        }
        int curNumber = digits.charAt(i) - '0';
        if (curNumber == 0 || curNumber == 1) {
            return;
        }
        for (int j = 0; j < dict[curNumber].length(); j++) {
            builder.append(dict[curNumber].charAt(j));
            dfs(builder, result, dict, i + 1, digits);
            builder.deleteCharAt(i); // 注意在什么地方还原builder
        }

        return;
    }
}
