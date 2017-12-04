public class Solution {
    /*
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        if (n != edges.length + 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        UnionFind nodes = new UnionFind(n);
        for (int[] edge : edges) {
            if (nodes.findWithCompressed(edge[0]) == nodes.findWithCompressed(edge[1])) {
                return false;
            }
            nodes.unionWithWeight(edge[0], edge[1]);
        }
        return true;
    }
}

class UnionFind {
    
    int[] parent;
    int[] size;
    
    UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i <n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }
    
    int findWithCompressed(int target) {
        int father = parent[target];
        while (father != parent[father]) {
            father = parent[father];
        }
        while (target != parent[target]) {
            int temp = parent[target];
            parent[target] = father;
            target = temp;
        }
        return father;
    }
    
    void unionWithWeight(int a, int b) {
        int aFather = findWithCompressed(a);
        int bFather = findWithCompressed(b);
        if (aFather != bFather) {
            if (size[aFather] > size[bFather]) {
                 parent[bFather] = aFather;
                 size[aFather] += size[bFather];
            } else {
                parent[aFather] = bFather;
                size[bFather] += size[aFather];
            }
        }
    }
}
