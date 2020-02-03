public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        if (nums == null || nums.length == 0)
            return new String[0];
        int n = nums.length;
        String[] result = new String[n];
        Map<Integer, Integer> map = new TreeMap<>((x, y) -> y -x);
        for (int i = 0; i < n; i++)
            map.put(nums[i], i);
        int count = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            switch (count) {
                case 1: 
                    result[entry.getValue()] = "Gold Medal";
                    break;
                case 2:
                    result[entry.getValue()] = "Silver Medal";
                    break;
                case 3:
                    result[entry.getValue()] = "Bronze Medal";
                    break;
                default:
                    result[entry.getValue()] = String.valueOf(count);
            }
            count++;
        }
        return result;
    }
}

/*
O(nlogn)

Basically this question is to find out the score -> ranking mapping. The easiest way is to sort those scores in nums. But we will lose their original order. We can create (score , original index) pairs and sort them by score decreasingly. Then we will have score -> ranking (new index) mapping and we can use original index to create the result.

Time complexity: O(NlgN). Space complexity: O(N). N is the number of scores.

Example:

nums[i]    : [10, 3, 8, 9, 4]
pair[i][0] : [10, 3, 8, 9, 4]
pair[i][1] : [ 0, 1, 2, 3, 4]

After sort:
pair[i][0] : [10, 9, 8, 4, 3]
pair[i][1] : [ 0, 3, 2, 4, 1]
public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[][] pair = new int[nums.length][2];
        
        for (int i = 0; i < nums.length; i++) {
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }
        
        Arrays.sort(pair, (a, b) -> (b[0] - a[0]));
        
        String[] result = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[pair[i][1]] = "Gold Medal";
            }
            else if (i == 1) {
                result[pair[i][1]] = "Silver Medal";
            }
            else if (i == 2) {
                result[pair[i][1]] = "Bronze Medal";
            }
            else {
                result[pair[i][1]] = (i + 1) + "";
            }
        }

        return result;
    }
}
Also we can use an one dimension array. This will save a little bit space but space complexity is still O(n).

public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        Integer[] index = new Integer[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        
        Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));//pay attention to this lambda expression  
        String[] result = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[index[i]] = "Gold Medal";
            }
            else if (i == 1) {
                result[index[i]] = "Silver Medal";
            }
            else if (i == 2) {
                result[index[i]] = "Bronze Medal";
            }
            else {
                result[index[i]] = (i + 1) + "";
            }
        }

        return result;
    }
}
*/

/*
O(n)

Borrow the idea of Pigeonhole Sort, since the scores are UNIQUE, we can use a int[] array as a hash map map[] to store the score-index info. Then we traverse the array map[] in the descent order of scores, it will automatically sort score-index. For each score, we find its index map[i] in original array and assign that position in the original array nums[map[i]] as the ranking number j, which keeps adding 1 whenever it encounters a non-null element.
Since such sorting is not comparison based, it doesn’t have the O(nlogn) lower bound so it can be faster than most sorting methods.
TC: O(n+range) SC: O(range) where range is the range of ints in nums[], also it is the length of map[].
It is my first time to submit my answer, help leave comment if you have any suggestions or better ideas to help improve my post! :)

public String[] findRelativeRanks(int[] nums) {
        int max = nums[0], min = nums[0];
        for(int i=1, n = nums.length; i<n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int length = max - min +1;
        Integer[] map = new Integer[length];
        for(int i=0, n = nums.length; i<n; i++) {
            map[max - nums[i]] = i;
        }
        String[] res = new String[nums.length];
        System.out.println(Arrays.toString(map));
        for (int i=0, j=0; i<length; i++){
            if(map[i] == null) continue;
            else {
                if(j == 0) res[map[i]] = "Gold Medal";
                else if(j == 1) res[map[i]] = "Silver Medal";
                else if(j == 2) res[map[i]] = "Bronze Medal";
                else res[map[i]] = j+1+"";
                j++;
            }
        }
        return res;
    }
*/
