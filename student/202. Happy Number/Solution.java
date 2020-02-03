public class Solution {
    public boolean isHappy(int n) {
        if (n <= 0)
            return false;
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            int temp = 0;
            while (n > 0) {
                temp += (n % 10) * (n % 10);
                n /= 10;
            }
            if (set.contains(temp))
                return false;
            else {
                n = temp;
                set.add(temp);
            }
        }
        return true;
    }
}
