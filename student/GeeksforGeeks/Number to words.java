/*
Number to words
Show Topic Tags         Amazon    Microsoft    Oracle
Given number into words. For example, if “1234” is given as input, output should be “one thousand two hundred and thirty four”

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N.

Output:

Print the number into words (in small letter).

Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 9999

Example:

Input:
2
2
142

Output:
two
one hundred and forty two
 

**For More Examples Use Expected Output**
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    private String[] lessTen = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private String[] lessTwenty = new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	private String[] tenTimes = new String[]{"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	private String[] more = new String[]{"hundred", "thousand"};
	
	public static void main (String[] args)
	 {
	    Scanner scanner = new Scanner(System.in);
	    GFG test = new GFG();
	    int T = scanner.nextInt();
	    for (int i = 0; i < T; i++) {
	        int num = scanner.nextInt();
	        System.out.println(test.intToStr(num));
	    }
	 }
	 public String intToStr(int num) {
	    if (num < 10)
	        return lessTen[num];
	    else if (num < 20)
	        return lessTwenty[num - 10];
	    else if (num < 100)
	        return tenTimes[num/10 - 2] + " " + (num%10 != 0 ? lessTen[num % 10] : "");
	    else if (num < 1000)
	        return lessTen[num / 100] + " " + more[0] + (num % 100 != 0 ? " and " + intToStr(num % 100) : "");
	    else if (num < 10000)
	        return lessTen[num / 1000] + " " + more[1] +(num % 1000 != 0 ? " " + intToStr(num % 1000) : "");
	    else
	        return "Overflow";
	 }
}
