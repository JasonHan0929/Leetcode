public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strings = str.split(" ");
        if (strings.length != pattern.length())
            return false;
        Map<Character, String> hash = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (hash.containsKey(pattern.charAt(i)) && !hash.get(pattern.charAt(i)).equals(strings[i]))
                return false;
            if (!hash.containsKey(pattern.charAt(i))) {
                if (hash.containsValue(strings[i]))
                    return false;//注意避免"abba"->"dog dog dog dog"情况
                hash.put(pattern.charAt(i), strings[i]);
            }
        }
        return true;
    }
}

public boolean wordPattern(String pattern, String str) {
    String[] words = str.split(" ");
    if (words.length != pattern.length())
        return false;
    Map index = new HashMap();
    for (int i=0; i<words.length; ++i)
        if (!Objects.equals(index.put(pattern.charAt(i), i),
                            index.put(words[i], i)))
            return false;
    return true;
}//牛人方法，注意hashmap的put返回的是之前的value，看不太懂
