class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> counterMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            counterMap.put(nums[i], counterMap.getOrDefault(nums[i], 0) + 1);
        }
        int[] counter = new int[counterMap.size()];
        int i = 0;
        for (int value : counterMap.values()) {
            counter[i] = value;
            i++;
        }
        int kValue = selectTopK(counter, counterMap.size() + 1 - k);
        //System.out.println(Arrays.toString(counter));
        //System.out.println(kValue);
        for (Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
            if (entry.getValue() >= kValue) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
    //很多坑，边界条件特别不清晰
    private int selectTopK(int[] input, int k) {
        int left = 0, right = input.length - 1;
        while (left <= right) { //只有一个的时候
            int curLeft = left + 1, curRight = right;
            int target = input[left];
            while (curLeft <= curRight) {
                while (curLeft <= right && input[curLeft] < target) { //找最左侧的，没有等号
                    curLeft++;
                }
                while (curRight >= left && input[curRight] >= target) {
                    curRight--;
                }
                if (curLeft < curRight && curLeft <= right && curRight >= left) {
                    int temp = input[curLeft];
                    input[curLeft] = input[curRight];
                    input[curRight] = temp;
                }
            }
            int targetIndex = curLeft - 1; //分析出来合理位置
            input[left] = input[targetIndex];
            input[targetIndex] = target;
            if (targetIndex ==  k - 1) {
                return target;
            } else if (targetIndex > k - 1) {
                right = targetIndex - 1;
            } else {
                left = targetIndex + 1;
            }
        }
        return -1;
    }
}
