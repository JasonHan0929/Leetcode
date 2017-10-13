class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask = 0, max = 0;
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 31; i >= 0; i--) {
            set.clear();
            mask = mask | (1 << i);
            for (int num : nums)
                set.add(mask & num);
            int temp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(prefix ^ temp)) { // if x ^ y = z, then x = z ^ y
                    max = temp;
                    break;
                } 
            }
        }
        return max;
    }
}

/*
This algorithm's idea is:
to iteratively determine what would be each bit of the final result from left to right. And it narrows down the candidate group iteration by iteration. e.g. assume input are a,b,c,d,...z, 26 integers in total. In first iteration, if you found that a, d, e, h, u differs on the MSB(most significant bit), so you are sure your final result's MSB is set. Now in second iteration, you try to see if among a, d, e, h, u there are at least two numbers make the 2nd MSB differs, if yes, then definitely, the 2nd MSB will be set in the final result. And maybe at this point the candidate group shinks from a,d,e,h,u to a, e, h. Implicitly, every iteration, you are narrowing down the candidate group, but you don't need to track how the group is shrinking, you only cares about the final result.(but this is not the algorithm of the code)

public class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            HashSet<Integer> set = new HashSet<Integer>();
            for (int num : nums) {
                set.add(num & mask); // reserve Left bits and ignore Right bits
            }
            int tmp = max | (1 << i); // in each iteration, there are pair(s) whoes Left bits can XOR to max
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                }
            }
        }
        return max;
    }
}
*/

/*
 class Trie {
        Trie[] children;
        public Trie() {
            children = new Trie[2];
        }
    }
    
    public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        // Init Trie.
        Trie root = new Trie();
        for(int num: nums) {
            Trie curNode = root;
            for(int i = 31; i >= 0; i --) {
                int curBit = (num >>> i) & 1;
                if(curNode.children[curBit] == null) {
                    curNode.children[curBit] = new Trie();
                }
                curNode = curNode.children[curBit];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            Trie curNode = root;
            int curSum = 0;
            for(int i = 31; i >= 0; i --) {
                int curBit = (num >>> i) & 1;
                if(curNode.children[curBit ^ 1] != null) {
                    curSum += (1 << i);
                    curNode = curNode.children[curBit ^ 1];
                }else {
                    curNode = curNode.children[curBit];
                }
            }
            max = Math.max(curSum, max);
        }
        return max;
    }
*/
