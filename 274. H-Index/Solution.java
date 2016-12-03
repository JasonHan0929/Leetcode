public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0; 
        Arrays.sort(citations);
        int result = 0;
        for(int i = 0; i < citations.length; i++) {
            if (citations.length - i >= citations[i])
                result = citations[i];
            else
                result = result > citations.length - i ? result : citations.length -i;//注意
        }
        return result;
    }
}//n*logn
public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0; 
        int N = citations.length;
        int[] count = new int[N + 1];
        int result = 0;
        int sum = 0;
        for (int h : citations) {
            if (h > N)//h不可能大过N
                count[N]++;
            else
                count[h]++;
        }
        for (int i = 0; i <= N; i++) {
            if (N - sum >= i)
                result = result < i? i : result;
            sum += count[i];
        }
        return result;
    }
}//n
