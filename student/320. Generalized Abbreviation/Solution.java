class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        if (word == null) return result;
        dfs(word.toCharArray(), 0, new StringBuilder(), 0, result);
        return result;
    }
    private void dfs(char[] word, int pos, StringBuilder temp, int count, List<String> result) {
        int len = temp.length();
        if (pos == word.length) {
            if (count > 0) temp.append(count);
            result.add(temp.toString());
        }
        else {
            dfs(word, pos + 1, temp, count + 1, result);
            if (count > 0) temp.append(count);
            dfs(word, pos + 1, temp.append(word[pos]), 0, result);
            
        }
        temp.setLength(len);
    }
}

/*
For each char c[i], either abbreviate it or not.

Abbreviate: count accumulate num of abbreviating chars, but don't append it yet.
Not Abbreviate: append accumulated num as well as current char c[i].
In the end append remaining num.
Using StringBuilder can decrease 36.4% time.
This comes to the pattern I find powerful:

int len = sb.length(); // decision point
... backtracking logic ...
sb.setLength(len);     // reset to decision point
Similarly, check out remove parentheses and add operators.

public List<String> generateAbbreviations(String word) {
    List<String> res = new ArrayList<>();
    DFS(res, new StringBuilder(), word.toCharArray(), 0, 0);
    return res;
}

public void DFS(List<String> res, StringBuilder sb, char[] c, int i, int num) {
    int len = sb.length();  
    if(i == c.length) {
        if(num != 0) sb.append(num);
        res.add(sb.toString());
    } else {
        DFS(res, sb, c, i + 1, num + 1);               // abbr c[i]

        if(num != 0) sb.append(num);                   // not abbr c[i]
        DFS(res, sb.append(c[i]), c, i + 1, 0);        
    }
    sb.setLength(len); 
}
*/
