class Solution {
    double loss = 0.00001;
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length == 0) return 0;
        double max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        while (max - min > loss) {
            double mid = min + (max - min) / 2;
            if (check(nums, k, mid)) min = mid;
            else max = mid;
        }
        return max;
    }
    private boolean check(int[] nums, int k, double target) {
        double sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i] - target;
        if (sum >= 0) return true;
        double preSum = 0;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - target;
            preSum += nums[i - k] - target;
            if (preSum < 0) {
                sum -= preSum;
                preSum = 0;
            }
            if (sum >= 0) return true;
        }
        return false;
    }
}

/*
Java solution O(nlogM) Binary search the answer
22
K KakaHiguain 
Reputation:  86
(nums[i]+nums[i+1]+...+nums[j])/(j-i+1)>x
=>nums[i]+nums[i+1]+...+nums[j]>x*(j-i+1)
=>(nums[i]-x)+(nums[i+1]-x)+...+(nums[j]-x)>0

public class Solution {
    boolean check(int[] nums,int k,double x) //Check whether we can find a subarray whose average is bigger than x
    {
        int n=nums.length;
        double[] a=new double[n];
        for (int i=0;i<n;i++) a[i]=nums[i]-x; //Transfer to a[i], find whether there is a subarray whose sum is bigger than 0
        double now=0,last=0;
        for (int i=0;i<k;i++) now+=a[i];
        if (now>=0) return true;
        for (int i=k;i<n;i++)
        {
            now+=a[i];
            last+=a[i-k];
            if (last<0) 
            {
                now-=last;
                last=0;
            }
            if (now>=0) return true;
        }
        return false;
    }
    public double findMaxAverage(int[] nums, int k) {
        double l=Integer.MIN_VALUE,r=Integer.MAX_VALUE;
        while (r-l>0.000004) //Binary search the answer
        {
            double mid=(l+r)/2;
            if (check(nums,k,mid)) l=mid; else r=mid;
        }
        return r;
    }
}
*/
