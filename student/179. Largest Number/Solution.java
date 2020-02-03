public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        String[] string = new String[nums.length];
        for(int i = 0; i < string.length; i++)
            string[i] = String.valueOf(nums[i]);
        Arrays.sort(string, new Comparator<String>() {//注意范型的位置在（）前且必须给出
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);//注意排出降序
            }
        });
        if (string[0].equals("0"))//注意这个corner case， 不能输出00要输出0
            return "0";
        StringBuilder result = new StringBuilder();
        for (String num : string) 
            result.append(num);
        return result.toString();
    }
}
