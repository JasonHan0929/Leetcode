public class Solution {

    public int addDigits(int num) {

        return num==0?0:(num%9==0?9:(num%9));

    }

}//观察法找规律

public class Solution {
    /*public int addDigits(int num) {
        String tempo = String.valueOf(num);
        while (tempo.length() > 1) {
            int sum = 0;
            for (int i = 0; i < tempo.length(); i++)//用string可以快速求位数
                sum += (int)tempo.charAt(i) - 48;
            tempo = String.valueOf(sum);
        }
        return Integer.parseInt(tempo);
    }*/
    /*public int addDigits(int num) {
        int sum = 0;
        while (num > 9) {
            sum = 0;
            while (num > 0) {
                sum += num%10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }*/
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
