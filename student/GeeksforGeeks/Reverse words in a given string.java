import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	    Scanner scanner = new Scanner(System.in);
	    int T = scanner.nextInt();
	    scanner.nextLine();//remove the /n
	    for (int i = 0; i < T; i++) {
	        String str = scanner.nextLine();
	        System.out.println(reverseWordsInString(str));
	    }
	 }
	 public static String reverseWordsInString(String str) {
	     if (str == null || str.length() <= 1)
	        return str;
	     String[] words = str.split("\\.");// escaped characters
	     int left = 0, right = words.length - 1;
	     while (left < right) {
	         String temp = words[left];
	         words[left] = words[right];
	         words[right] = temp;
	         left++;
	         right--;
	     }
	     StringBuilder result = new StringBuilder();
	     for (String word : words)
	        result.append(word).append(".");
	     if (result.length() > 0)
	        result.deleteCharAt(result.length() - 1);
	     return result.toString();
	 }
}//could use stringbuilder and just traver the words[] from the end 
