public List<List<Integer>> threeSum(int[] nums) {
    int key;
    Arrays.sort(nums);
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    for(int i=0;i<nums.length;i++) map.put(nums[i],i);//会帮你自动排除选择第三个时的重复情况
    for(int i=0;i<nums.length-2;i++){
        if(i!=0&&nums[i]==nums[i-1]) continue;  //注意不能用nums[i] == nums[i + 1]来判断，会跳过有效数据
        for(int j=i+1;j<nums.length-1;j++){
            if(j!=i+1&&nums[j]==nums[j-1]) continue;//注意三个值的脚标控制
            key=0-nums[i]-nums[j];
            if(map.containsKey(key)&&(map.get(key)>j))
                result.add(Arrays.asList(nums[i], nums[j], key));//注意简便方法
        }
    }
    return result;
}//hashmap


public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        if(nums==null) return null;
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>(); 
        for (int i = 0; i < num.length-2; i++) {
            if(i==0 || (i>0 && num[i]!=num[i-1])){ // remove duplicate
                int left = i+1, right = num.length-1;
                while(left<right){
                    int sum = num[i] + num[left] + num[right];
                    if(sum<0){
                        while(left<right && num[left]==num[left+1]) left++; // remove duplicate
                        left++;
                    } else if(sum>0){
                        while(left<right && num[right]==num[right-1]) right--; // remove duplicate
                        right--;
                    } else {
                        res.add(Arrays.asList(num[i], num[left], num[right]));
                        while(left<right && num[left]==num[left+1]) left++; // remove duplicate
                        while(left<right && num[right]==num[right-1]) right--; // remove duplicate
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}//three pointer
