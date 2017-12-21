class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        int size = triangle.size();
        List<List<Integer>> sum = new ArrayList<>(size);
        List<List<Integer>> step = new ArrayList<>(size - 1);
        for (int i = 0; i < size - 1; i++) {
            sum.add(new ArrayList<>(triangle.get(i)));
            step.add(new ArrayList<>(i + 1));
        }
        sum.add(new ArrayList<>(triangle.get(size - 1)));
        for (int i = size - 2; i >= 0; i--) {
            List<Integer> pre = sum.get(i + 1);
            List<Integer> curr = sum.get(i);
            for (int j = 0; j < curr.size(); j++) {
                if (pre.get(j) < pre.get(j + 1)) {
                    curr.set(j, pre.get(j) + curr.get(j));
                    step.get(i).add(j);
                } else {
                    curr.set(j, curr.get(j) + pre.get(j + 1));
                    step.get(i).add(j + 1);
                }
            }
        }
        System.out.println(getStep(triangle, step));
        return sum.get(0).get(0);
    }
    
    public String getStep(List<List<Integer>> triangle, List<List<Integer>> step) {
        StringBuilder sb = new StringBuilder();
        int next = 0;
        for (int i = 0; i < step.size(); i++) {
            sb.append(triangle.get(i).get(next) + ",");
            next = step.get(i).get(next);
        }
        sb.append(triangle.get(triangle.size() - 1).get(next));
        return sb.toString();
    }
}
