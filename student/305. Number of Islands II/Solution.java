class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] parent = new int[m * n];
        int[] size = new int[m * n];
        Arrays.fill(parent, -1);
        int[][] assist = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int k = positions.length;
        List<Integer> result = new ArrayList<>(k);
        for (int j = 0; j < k; j++) {
            int[] array = positions[j];
            int index = array[0] * n + array[1];
            parent[index] = index;
            size[index] = 1;
            Set<Integer> island = new HashSet<>(4);
            for (int i = 0; i < assist.length; i++) {
                int num = find(parent, array[0] + assist[i][0], array[1] + assist[i][1], m, n);
                if (num != -1) island.add(num);
            }
            if (!island.isEmpty()) {
                result.add(result.get(j - 1) - island.size() + 1);
                int max = 0;
                int choosed = -1;
                for (int num : island) {
                    if (size[num] > max) {
                        choosed = num;
                        max = size[num];
                    }
                }
                parent[index] = choosed;
                size[choosed] += 1;// do not foget the point you just added in grid
                for (int num : island) {
                    if (num != choosed) {
                        parent[num] = choosed;
                        size[choosed] += size[num]; 
                    }
                }
            } else {
                result.add(j > 0 ? result.get(j - 1) + 1 : 1);
            }
        }
        return result;
    }
    private int find(int[] parent, int i, int j, int m, int n) {
        int index = n * i + j;
        if (i < 0 || i >= m || j < 0 || j >= n || parent[index] == -1) return -1;
        int curr = index;
        while (parent[curr] != curr) {
            curr = parent[curr];
        }
        while (parent[index] != curr) {
            int temp = parent[index];
            parent[index] = curr;
            index = temp;
        }
        return curr;
    }
}

/*
int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

public List<Integer> numIslands2(int m, int n, int[][] positions) {
    List<Integer> result = new ArrayList<>();
    if(m <= 0 || n <= 0) return result;

    int count = 0;                      // number of islands
    int[] roots = new int[m * n];       // one island = one tree
    Arrays.fill(roots, -1);            

    for(int[] p : positions) {
        int root = n * p[0] + p[1];     // assume new point is isolated island
        roots[root] = root;             // add new island
        count++;

        for(int[] dir : dirs) {
            int x = p[0] + dir[0]; 
            int y = p[1] + dir[1];
            int nb = n * x + y;
            if(x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1) continue;
            
            int rootNb = findIsland(roots, nb);
            if(root != rootNb) {        // if neighbor is in another island
                roots[root] = rootNb;   // union two islands 
                root = rootNb;          // current tree root = joined tree root
                count--;               
            }
        }

        result.add(count);
    }
    return result;
}

public int findIsland(int[] roots, int id) {
    while(id != roots[id]) id = roots[id];
    return id;
}
*/
