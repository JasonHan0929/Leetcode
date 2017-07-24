public class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() <= 1)
            return s;
        char[] string = s.toCharArray();
        int curr = 0, n = s.length();
        while (curr < n) {
            reverse(string, curr, curr + k - 1);
            curr += 2 * k;
        }
        return new String(string);
    }
    public void reverse(char[] string, int left, int right) {
        right = Math.min(right, string.length - 1);
        while (left < right) {
            char temp = string[left];
            string[left] = string[right];
            string[right] = temp;
            left++;
            right--;
        }
    }
}
/*
public class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while(i < n) {
            int j = Math.min(i + k - 1, n - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }
    private void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}
*/
