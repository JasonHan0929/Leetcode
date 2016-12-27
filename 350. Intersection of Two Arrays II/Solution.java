public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length <= 0 || nums2.length <= 0)
            return new int[0]; 
        Map<Integer,Integer> hash = new HashMap<>();
        Map<Integer,Integer> result = new HashMap<>();//result用list来做更简洁
        int size = 0;
        for (int num : nums1) //注意for-each前要检查是不是lenght未0
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        for (int num : nums2) {
            if (hash.containsKey(num) && hash.get(num) > 0) {
                result.put(num, result.getOrDefault(num, 0) + 1);
                hash.put(num, hash.get(num) - 1);
                size++;
            }
        }
        int[] array = new int[size];
        int index = 0;
        for (Map.Entry<Integer,Integer> entry : result.entrySet()) {
            int count = entry.getValue();
            while (count > 0) {
                array[index++] = entry.getKey();
                count--;
            }
        }
        return array;
    }
}
