public class Solution {
    public int lengthOfLastWord(String s) {
        String[] array = s.split(" ");
        if (array.length == 0)
            return 0;
        return array[array.length - 1].length();
    }
}//用了额外数组

public int lengthOfLastWord(String s) {
    return s.trim().length()-s.trim().lastIndexOf(" ")-1;
}//更简洁用了trim

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0)
            return 0;
        int index = -1;
        int counter = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' ')
                index = i;
        }//找符合要求的空格
        if (index < 0 && s.charAt(0) == ' ') 
            return counter;//排除“   ”，而”aaa   “这种情况符合先面的循环可以不用排除，“   aaa”这种情况不会index < 0
        for (int i = index + 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                break;
            else
                counter++;
        }//数word长度
        return counter;
    }
}//不用标准库正着数

public int lengthOfLastWord(String s) {
    //228ms
    int lenIndex = s.length()-1;
    int len = 0;

    /*can also use while here, resulting in 264ms
    while (lenIndex>=0 && s.charAt(lenIndex)==' ') lenIndex--;*/
    
    /*or use trim - 324ms
    s = s.trim();*/

    for (int i=lenIndex; i>=0 && s.charAt(i)==' '; i--) 
        lenIndex--;
    
    for (int i=lenIndex; i>=0 && s.charAt(i)!=' '; i--) 
        len++;
    return len;
}//倒着数更简洁
