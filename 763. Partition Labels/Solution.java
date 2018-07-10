class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        if (S == null || S.length() == 0) return result;
        int n = S.length();
        Map<Character, Integer> lastIndex = new HashMap<>(n);
        for (int i = 0; i < n; i++) lastIndex.put(S.charAt(i), i);
        int part = 0;
        for (int j = 0; j < n; j = part + 1) { // use loop to manipulate two pointers
            for (int i = j; i < n; i++) {
                part = Math.max(lastIndex.get(S.charAt(i)), part);
                if (i == part) {
                    result.add(part - j + 1);
                    break;
                }
            }
        }
        return result;
    }
}

/*
traverse the string record the last index of each char.
using pointer to record end of the current sub string.
public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];  // record the last index of the each char

        for(int i = 0; i < S.length(); i++){
            map[S.charAt(i)-'a'] = i;
        }
        // record the end index of the current sub string
        int last = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++){
            last = Math.max(last, map[S.charAt(i)-'a']);
            if(last == i){
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }
*/

