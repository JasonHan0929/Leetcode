public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<LinkedList<Integer>> bucket = new ArrayList<LinkedList<Integer>>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++)
            bucket.add(i, new LinkedList<Integer>());
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            bucket.get(entry.getValue()).add(entry.getKey());
        }
        for (int i = nums.length; i >= 0; i--) {
            if (!bucket.get(i).isEmpty() && k > 0) {
                result.addAll(bucket.get(i));
                k -= bucket.get(i).size();
            }
        }
        return result;
    }
}


public List<Integer> topKFrequent(int[] nums, int k) {

	List<Integer>[] bucket = new List[nums.length + 1]; //不能用new List<Integer>[]，这里相当与建立了List<object>[],可以想其中添加Integer
	Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

	for (int n : nums) {
		frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
	}

	for (int key : frequencyMap.keySet()) {
		int frequency = frequencyMap.get(key);
		if (bucket[frequency] == null) {
			bucket[frequency] = new ArrayList<>();
		}
		bucket[frequency].add(key);
	}

	List<Integer> res = new ArrayList<>();

	for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
		if (bucket[pos] != null) {
			res.addAll(bucket[pos]);
		}
	}
	return res;
}
