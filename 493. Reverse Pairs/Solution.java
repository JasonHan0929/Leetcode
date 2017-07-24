/*
MergeSort nlog(n)

Explanation: In each round, we divide our array into two parts and sort them. So after "int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e); ", the left part and the right part are sorted and now our only job is to count how many pairs of number (leftPart[i], rightPart[j]) satisfies leftPart[i] <= 2*rightPart[j].
For example,
left: 4 6 8 right: 1 2 3
so we use two pointers to travel left and right parts. For each leftPart[i], if j<=e && nums[i]/2.0 > nums[j], we just continue to move j to the end, to increase rightPart[j], until it is valid. Like in our example, left's 4 can match 1 and 2; left's 6 can match 1, 2, 3, and left's 8 can match 1, 2, 3. So in this particular round, there are 8 pairs found, so we increases our total by 8.

public class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] nums, int s, int e){
        if(s>=e) return 0; 
        int mid = s + (e-s)/2; 
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e); 
        for(int i = s, j = mid+1; i<=mid; i++){
            while(j<=e && nums[i]/2.0 > nums[j]) j++; 
            cnt += j-(mid+1); 
        }
        Arrays.sort(nums, s, e+1); 
        return cnt; 
    }
}

Or:
Because left part and right part are sorted, you can replace the Arrays.sort() part with a actual merge sort process. The previous version is easy to write, while this one is faster.

public class Solution {
    int[] helper;
    public int reversePairs(int[] nums) {
        this.helper = new int[nums.length];
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] nums, int s, int e){
        if(s>=e) return 0; 
        int mid = s + (e-s)/2; 
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e); 
        for(int i = s, j = mid+1; i<=mid; i++){
            while(j<=e && nums[i]/2.0 > nums[j]) j++; 
            cnt += j-(mid+1); 
        }
        //Arrays.sort(nums, s, e+1); 
        myMerge(nums, s, mid, e);
        return cnt; 
    }
    
    private void myMerge(int[] nums, int s, int mid, int e){
        for(int i = s; i<=e; i++) helper[i] = nums[i];
        int p1 = s;//pointer for left part
        int p2 = mid+1;//pointer for rigth part
        int i = s;//pointer for sorted array
        while(p1<=mid || p2<=e){
            if(p1>mid || (p2<=e && helper[p1] >= helper[p2])){
                nums[i++] = helper[p2++];
            }else{
                nums[i++] = helper[p1++];
            }
        }
    }
}

or:
you could combine sorting process with counting process

public class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }
    private int mergeSort(int[] nums, int l, int r) {
        if (l >= r) return 0;
        int mid = l + (r - l)/2;
        int count = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);
        int[] cache = new int[r - l + 1];
        int i = l, t = l, c = 0;
        for (int j = mid + 1; j <= r; j++, c++) {
            while (i <= mid && nums[i] <= 2 * (long)nums[j]) i++;
            while (t <= mid && nums[t] < nums[j]) cache[c++] = nums[t++];
            cache[c] = nums[j];
            count += mid - i + 1;//count while sorting
        }
        while (t <= mid) cache[c++] = nums[t++];
        System.arraycopy(cache, 0, nums, l, r - l + 1);
        return count;
    }
}
*/

/*
BST 

This is literally the same problem with 315. Count of Smaller Numbers After Self.
The only difference is to find count of numbers smaller than half of the current number after itself.
To efficiently search for count of numbers smaller than a target, we can use a Binary Search Tree. There is a little change of the TreeNode to include count of numbers smaller or equal to it. This will make the query even faster because we don't need to traverse all its left sub-tree to get the count.

Overall Algorithm:

Scan the numbers from right to left.
First search the tree to get count of numbers smaller than nums[i] / 2.0, sum to the final result.
Insert nums[i] to the tree.
Insert logic:

Recursively try to find a place to insert this number. When root is null, its time to create a new node. If meet the same number, just increase the count.
When try to insert the number to left sub-tree, increase count of current node.
Query logic:

If target value is greater than the current value, meaning current node and all left sub-tree are smaller than target, return count (remember it stands for count of numbers smaller or equal to current number) of current node plus any possible smaller number than target in right sub-tree.
Otherwise, only search left sub-tree.
public class Solution {
    class Node {
	int value, count;
	Node left, right;
	Node (int v) {
	    value = v; count = 1;
	}
    }
	
    public int reversePairs(int[] nums) {
        int result = 0;
        if (nums == null || nums.length <= 1) return result;
        
        int len = nums.length;
	Node root = new Node(nums[len - 1]);
	    
	for(int i = len - 2; i >= 0; i--) {
	    result += query(root, nums[i] / 2.0);
	    insert(root, nums[i]);
	}

	return result;
    }
    
    private Node insert(Node root, int value) {
	if (root == null) return new Node(value);
		
	if (root.value == value) {
	    root.count++;
	}
	else if (root.value > value) {
	    root.count++;
	    root.left = insert(root.left, value);
	}
	else {
	    root.right = insert(root.right, value);
	}
		
	return root;
    }
	
    private int query(Node root, double value) {
	if (root == null) return 0;
		
	if (value > root.value) {
	    return root.count + query(root.right, value);
	}
	else {
	    return query(root.left, value);
	}
    }
}

@shawngao what's the time complexity for this solution? I think at worst case it can be O(n^2).
For example case where all numbers are sorted. 1 2 3 4 5 6 7 8 9 10.
At each iteration you will go to the deepest node on the tree O(n).
Thus, the total complexity could reach O(n^2).
Is there anything that I miss here?

@qweruiop Yes, you are right. Worst case runtime complexity is O(n^2) because this home-made tree is not a balanced tree.
*/

/*
BIT-based solution

For BIT, the searching and insertion operations are:

private int search(int[] bit, int i) {
    int sum = 0;
    
    while (i < bit.length) {
        sum += bit[i];
        i += i & -i;
    }

    return sum;
}

private void insert(int[] bit, int i) {
    while (i > 0) {
        bit[i] += 1;
        i -= i & -i;
    }
}
And the main program, where again we will search for all elements greater than twice of current element while insert the element itself into the BIT. For each element, the "index" function will return its index in the BIT. Unlike the BST-based solution, this is guaranteed to run at O(nlogn).

public int reversePairs(int[] nums) {
    int res = 0;
    int[] copy = Arrays.copyOf(nums, nums.length);
    int[] bit = new int[copy.length + 1];
    
    Arrays.sort(copy);
    
    for (int ele : nums) {
        res += search(bit, index(copy, 2L * ele + 1));
        insert(bit, index(copy, ele));
    }
    
    return res;
}

private int index(int[] arr, long val) {
    int l = 0, r = arr.length - 1, m = 0;
    	
    while (l <= r) {
    	m = l + ((r - l) >> 1);
    		
    	if (arr[m] >= val) {
    	    r = m - 1;
    	} else {
    	    l = m + 1;
    	}
    }
    
    return l + 1;
}
More explanation for the BIT-based solution:

We want the elements to be sorted so there is a sorted version of the input array which is copy.

The bit is built upon this sorted array. Its length is one greater than that of the copy array to account for the root.

Initially the bit is empty and we start doing a sequential scan of the input array. For each element being scanned, we first search the bit to find all elements greater than twice of it and add the result to res. We then insert the element itself into the bit for future search.

Note that conventionally searching of the bit involves traversing towards the root from some index of the bit, which will yield a predefined running total of the copy array up to the corresponding index. For insertion, the traversing direction will be opposite and go from some index towards the end of the bit array.

For each scanned element of the input array, its searching index will be given by the index of the first element in the copy array that is greater than twice of it (shifted up by 1 to account for the root), while its insertion index will be the index of the first element in the copy array that is no less than itself (again shifted up by 1). This is what the index function is for.

For our case, the running total is simply the number of elements encountered during the traversal process. If we stick to the convention above, the running total will be the number of elements smaller than the one at the given index, since the copy array is sorted in ascending order. However, we'd actually like to find the number of elements greater than some value (i.e., twice of the element being scanned), therefore we need to flip the convention. This is what you see inside the search and insert functions: the former traversing towards the end of the bit while the latter towards the root.
*/



