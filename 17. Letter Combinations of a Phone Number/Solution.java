public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return result;
        String[] content = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Deque<Integer> index = new LinkedList<>();
        StringBuilder temp = new StringBuilder();
        int i = 0;
        index.push(0);
        while(!index.isEmpty()) {
            int k = index.poll();
            String chr = content[digits.charAt(i) - '0'];
            if (k < chr.length()) {
                temp.append(chr.charAt(k));
                index.push(k + 1);
                if (i == digits.length() - 1) {
                    result.add(temp.toString());
                    temp.deleteCharAt(temp.length() - 1);
                }
                else {
                    i++;
                    index.push(0);
                }
            }
            else {
                i--;
                if (i < 0)
                    break;
                temp.deleteCharAt(temp.length() - 1);
            }
        }
        return result;
    }
}// this code is messy, how to interpreate backtracing from recursion into iteration?

/*
public List<String> letterCombinations(String digits) {
    LinkedList<String> ans = new LinkedList<String>();
    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    ans.add("");
    for(int i =0; i<digits.length();i++){
        int x = Character.getNumericValue(digits.charAt(i));
        while(ans.peek().length()==i){
            String t = ans.remove();
            for(char s : mapping[x].toCharArray())
                ans.add(t+s);
        }
    }
    return ans;
}
*/
