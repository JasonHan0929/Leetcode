public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1)
            return s;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] sArray = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (!set.contains(sArray[left]) && left < right)
                left++;
            while (!set.contains(sArray[right]) && left < right)
                right--;
            if (left < right) {
                char temp = sArray[left];
                sArray[left] = sArray[right];
                sArray[right] = temp;
                left++;
                right--;
            }
        }
        return new String(sArray);
    }
}

/*
n the inner while loop, don't forget the condition "start less than end" while incrementing start and decrementing end. This is my friend's google phone interview question. Cheers!
// update! May use a HashSet<Character> to reduce the look up time to O(1)

public class Solution {
public String reverseVowels(String s) {
    if(s == null || s.length()==0) return s;
    String vowels = "aeiouAEIOU";
    char[] chars = s.toCharArray();
    int start = 0;
    int end = s.length()-1;
    while(start<end){
        
        while(start<end && !vowels.contains(chars[start]+"")){
            start++;
        }
        
        while(start<end && !vowels.contains(chars[end]+"")){
            end--;
        }
        
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
        
        start++;
        end--;
    }
    return new String(chars);
}
}
*/
