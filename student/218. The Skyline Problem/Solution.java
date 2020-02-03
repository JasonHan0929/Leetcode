class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        int n = buildings.length;
        int[][] heights = new int[n * 2][2];
        for (int i = 0; i < n; i++) {
            heights[i][0] = buildings[i][0]; heights[i][1] = -buildings[i][2];
            heights[i + n][0] = buildings[i][1]; heights[i + n][1] = buildings[i][2];
        }
        TreeMap<Integer, Integer> heap = new TreeMap<>(Collections.reverseOrder());
        int pre = 0;
        heap.put(0, 1);
        List<int[]> result = new ArrayList<>();
        Arrays.sort(heights, (x, y) -> (x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]));
        for (int[] height : heights) {
            if (height[1] < 0) {
                int count = heap.getOrDefault(-height[1], 0) + 1;
                heap.put(-height[1], count);
            } else {
                int count = heap.get(height[1]);
                if (count == 1) heap.remove(height[1]);
                else heap.put(height[1], count - 1);
            }
            int cur = heap.firstKey();
            if (pre != cur) {
                result.add(new int[]{height[0], cur});
                pre = cur;
            }
        }
        return result;
    }
}
/*
	public List<int[]> getSkyline(int[][] buildings) {
    List<int[]> result = new ArrayList<>();
    List<int[]> height = new ArrayList<>();
    for(int[] b:buildings) {
        height.add(new int[]{b[0], -b[2]});
        height.add(new int[]{b[1], b[2]});
    }
    Collections.sort(height, (a, b) -> {
            if(a[0] != b[0]) 
                return a[0] - b[0];
            return a[1] - b[1];
    });
    Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
    pq.offer(0);
    int prev = 0;
    for(int[] h:height) {
        if(h[1] < 0) {
            pq.offer(-h[1]);
        } else {
            pq.remove(h[1]);
        }
        int cur = pq.peek();
        if(prev != cur) {
            result.add(new int[]{h[0], cur});
            prev = cur;
        }
    }
    return result;
}
*/
/*Thanks for the good solutions. However, there is a small thing that can be improved. pq.remove() is O(n) hence make it slower. I have modified it a little bit to use TreeMap instead of PriorityQueue and the run time is 2.5X faster.

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for (int[] b: buildings) {
            heights.add(new int[]{b[0], - b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        TreeMap<Integer, Integer> heightMap = new TreeMap<>(Collections.reverseOrder());
        heightMap.put(0,1);
        int prevHeight = 0;
        List<int[]> skyLine = new LinkedList<>();
        for (int[] h: heights) {
            if (h[1] < 0) {
                Integer cnt = heightMap.get(-h[1]);
                cnt = ( cnt == null ) ? 1 : cnt + 1;
                heightMap.put(-h[1], cnt);
            } else {
                Integer cnt = heightMap.get(h[1]);
                if (cnt == 1) {
                    heightMap.remove(h[1]);
                } else {
                    heightMap.put(h[1], cnt - 1);
                }
            }
            int currHeight = heightMap.firstKey();
            if (prevHeight != currHeight) {
                skyLine.add(new int[]{h[0], currHeight});
                prevHeight = currHeight;
            }
        }
        return skyLine;
    }
}
*/
