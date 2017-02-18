public class Solution {
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case 'X':
                    if (i + 1 < s.length() && ((s.charAt(i + 1) == 'L') || (s.charAt(i + 1) == 'C')))
                        result -= 10;
                    else
                        result += 10;
                    break;
                case 'V' :
                    result += 5;
                    break;
                case 'I' :
                    if (i + 1 < s.length() && ((s.charAt(i + 1) == 'V') || (s.charAt(i + 1) == 'X')))
                        result -= 1;
                    else
                        result += 1;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    if (i + 1 < s.length() && ((s.charAt(i + 1) == 'D') || (s.charAt(i + 1) == 'M')))
                        result -= 100;
                    else
                        result += 100;
                    break;
                case 'D' :
                    result += 500;
                    break;
                case 'M' :
                    result += 1000;
                    break;
            }
        }
        return result;
    }
}

public static int romanToInt(String s) {
	int res = 0;
	for (int i = s.length() - 1; i >= 0; i--) {
		char c = s.charAt(i);
		switch (c) {
		case 'I':
			res += (res >= 5 ? -1 : 1);
			break;
		case 'V':
			res += 5;
			break;
		case 'X':
			res += 10 * (res >= 50 ? -1 : 1);
			break;
		case 'L':
			res += 50;
			break;
		case 'C':
			res += 100 * (res >= 500 ? -1 : 1);
			break;
		case 'D':
			res += 500;
			break;
		case 'M':
			res += 1000;
			break;
		}
	}
	return res;
}// more simple

