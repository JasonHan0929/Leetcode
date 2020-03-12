class NumArray {
    int tree[];
    int length;

    public NumArray(int[] nums) {
        if (nums == null) {
            return;
        }
        this.length = nums.length;
        this.tree = new int[2 * nums.length];
        buildTree(nums);
    }

    private void buildTree(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            tree[i + length] = nums[i];
        }
        for (int i = length - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    public void update(int i, int val) {
        int diff = val - tree[length + i];
        i += length;
        while (i > 0) {
            tree[i] += diff;
            i /= 2;
        }
    }

    public int sumRange(int i, int j) {
        if (i >= length) {
            return 0;
        }
        if (j >= length) {
            j = length - 1;
        }
        i += length;
        j += length;
        int sum = 0;
        while (i <= j) { // 隐含i,j均大于0
            if (i % 2 == 1) {
                sum += tree[i];
                i++;
            }
            if (j % 2 == 0) {
                sum += tree[j];
                j--;
            }
            i /= 2;
            j /= 2;
        }
        return sum;
    }
}
