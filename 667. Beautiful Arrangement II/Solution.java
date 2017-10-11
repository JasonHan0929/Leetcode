class Solution {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        for (int i = 0, l = 1, r = n; i < n; i++) {
            if (k > 1) {
                result[i] = i % 2 == 0 ? l++ : r--;
                k--;
            } else {
                if (i % 2 == 0) {
                    for (; i < n; i++)
                        result[i] = l++;
                }
                else {
                    for (; i < n; i++)
                        result[i] = r--;
                }
            }
        }
        return result;
    }
}
/*
if you have n number, the maximum k can be n - 1;
if n is 9, max k is 8.
This can be done by picking numbers interleavingly from head and tail,

// start from i = 1, j = n;
// i++, j--, i++, j--, i++, j--

1   2   3   4   5
  9   8   7   6
out: 1 9 2 8 3 7 6 4 5
dif:  8 7 6 5 4 3 2 1
Above is a case where k is exactly n - 1
When k is less than that, simply lay out the rest (i, j) in incremental
order(all diff is 1). Say if k is 5:

     i++ j-- i++ j--  i++ i++ i++ ...
out: 1   9   2   8    3   4   5   6   7
dif:   8   7   6   5    1   1   1   1 
C++

class Solution {
public:
    vector<int> constructArray(int n, int k) {
        vector<int> res;
        for (int i = 1, j = n; i <= j; ) {
            if (k > 1) {
                res.push_back(k-- % 2 ? i++ : j--);
            }
            else {
                res.push_back(i++);
            }
        }

        return res;
    }
};
C++ Compact

class Solution {
public:
    vector<int> constructArray(int n, int k) {
        vector<int> res;
        for (int i = 1, j = n; i <= j; )
            res.push_back(k > 1 ? (k-- % 2 ? i++ : j--) : i++;
        return res;
    }
};
Java

class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0, l = 1, r = n; l <= r; i++)
            res[i] = k > 1 ? (k-- % 2 != 0 ? l++ : r--) : l++;
        return res;
    }
}
*/