public class Solution {
    public List<String> summaryRanges(int[] nums) {
        int high = 0;
        int low = 0;
        List<String> result = new ArrayList<>();
        if (nums.length == 1) {
            result.add(Integer.toString(nums[0]));
            return result;
        }
        if (nums.length == 0) // two corner cases
            return result;
        while (high < nums.length - 1) {
            if (nums[high] + 1 != nums[high + 1]) {
                String tempo = nums[low] == nums[high] ? Integer.toString(nums[low]) : nums[low] + "->" + nums[high];
                result.add(tempo);
                low = high + 1;// not low = high
            }
            high++;
        }
        String tempo = nums[low] == nums[high] ? Integer.toString(nums[low]) : nums[low] + "->" + nums[high];
        result.add(tempo);
        return result;
    }
}

/*List<String> list=new ArrayList();
	if(nums.length==1){
		list.add(nums[0]+"");
		return list;
	}
    for(int i=0;i<nums.length;i++){
    	int a=nums[i];
    	while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
    		i++;
    	}
    	if(a!=nums[i]){
    		list.add(a+"->"+nums[i]);
    	}else{
    		list.add(a+"");
    	}
    }
    return list;*/
