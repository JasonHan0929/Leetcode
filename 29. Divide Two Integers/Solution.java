/*public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        int sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? 1 : -1;
        int result = 0;
        dividend = dividend * (dividend > 0 ? -1 : 1);
        divisor = divisor * (divisor > 0 ? -1 : 1);
        while (dividend <= divisor) {
            dividend -= divisor;
            result++;
        }
        return result * sign;
    }
}*/ // ETL

public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        long dividendLong = (long)dividend * (dividend < 0 ? -1 : 1);
        long divisorLong = (long)divisor * (divisor < 0 ? -1 : 1);
        long result = 0;
        int sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? 1 : -1;
        while (dividendLong >= divisorLong) {
            int i = 0;
            while ((divisorLong << i) <= dividendLong)
                i++;
            result += (long)Math.pow(2, i - 1);
            dividendLong -= (divisorLong << (i - 1));
        }
        result = result * (sign < 0 ? -1 : 1);
        return result >= Integer.MAX_VALUE ? Integer.MAX_VALUE : result <= Integer.MIN_VALUE ? Integer.MIN_VALUE : (int)result;
    }
}

/*public static int divide(int dividend, int divisor) {

	if(dividend==0)
		return 0;
	int signal;
	if((dividend<0&&divisor>0)||(dividend>0&&divisor<0))
		signal=-1;
	else
		signal=1;
	long absDividend=Math.abs((long)dividend);//Math.abs(最小负数) 结果还是其本身. 在进行该运算前，要将其转化为long类型。
	long absDivisor=Math.abs((long)divisor);//
	long result=0;
	while(absDividend>=absDivisor){
		long tmp=absDivisor,count=1;;
		while(tmp<=absDividend){
			tmp=tmp<<1;//这里可能溢出！！超出int表示的范围
			count=count<<1;//这里可能溢出！！超出int表示的范围
		}
		tmp=tmp>>1;
		count=count>>1;
		result+=count;
		absDividend-=tmp;
	}
      if(signal==-1)              	 
        return (int)(signal*result);               
      else{
        if(result>Integer.MAX_VALUE)//溢出
           return Integer.MAX_VALUE;
        else
           return (int)result;
    }
}*/
