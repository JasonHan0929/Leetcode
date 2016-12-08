public class Solution {
    public int removeElement(int[] nums, int val) {
        int tail = nums.length;
        int head = 0;
        int len = 0;
        while (head < tail) {
            if (nums[head] == val)
                swap(nums, --tail, head);
            else {
                head++;
                len++;
            }
        }

        return len;//注意head不一定计数准确，比如[1],1这种情况，head不方便计数
    }
    public void swap(int[] nums, int indexA, int indexB) {
        int tempo = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = tempo;
    }
}
public class Solution {
	public int removeElement(int[] A, int elem) {
	   int m = 0;    
	   for(int i = 0; i < A.length; i++){
	       
	       if(A[i] != elem){
		   A[m] = A[i];
		   m++;
	       }
	   }
	   
	   return m;
	}
}//简洁版但是时间会慢因为交换次数多
