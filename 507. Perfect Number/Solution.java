class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1)
            return false;
        int sqrt = (int)Math.sqrt(num);
        int sum = 1;
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        return sum == num;
    }
}

/*
public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        
        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        sum++;
        
        return sum == num;
    }
}
*/
