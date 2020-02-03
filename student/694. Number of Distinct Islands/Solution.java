class Solution {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        Set<Set<Coordinate>> result = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    Set<Coordinate> ones = new HashSet<>();
                    int[] origin = new int[]{i, j};
                    dfs(new Coordinate(i, j), grid, origin, ones);
                    grid[i][j] = 0;
                    for (Coordinate c : ones) {
                        c.x -= origin[0];
                        c.y -= origin[1];
                    }
                    result.add(new HashSet<>(ones)); // hashcode will not changed one's set is created
                }
            }
        }
        return result.size();
    }
    
    public void dfs(Coordinate cur, int[][] grid, int[] origin, Set<Coordinate> ones) {
        if (cur.x < 0 || cur.y < 0 || cur.x >= grid.length || 
            cur.y >=grid[0].length || grid[cur.x][cur.y] != 1) {
            return;
        }
        // origin = {minX, minY}
        updateOrigin(cur.x, cur.y, origin);
        ones.add(cur);
        grid[cur.x][cur.y] = 0;
        int[][] next = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] delta : next) {
            int nextX = cur.x + delta[0];
            int nextY = cur.y + delta[1];
            dfs(new Coordinate(nextX, nextY), grid, origin, ones);
        }
        return;
    }
    
    public void updateOrigin(int x, int y, int[] origin) {
        origin[0] = Math.min(x, origin[0]);
        origin[1] = Math.min(y, origin[1]);
    }
}

class Coordinate { // may use Arrays.hashCode to simplify
    int x;
    int y;
    
    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        if (this == o) {
            return true;
        }
        Coordinate other = (Coordinate) o;
        return x == other.x && y == other.y;
    }
    
    @Override
    public int hashCode(){
        return x + 13 * y;
    }
    
    @Override
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }
}

/*
class Solution {
   
    int[][] dirs= new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int numDistinctIslands(int[][] grid) {
         Set<String> set= new HashSet<>();
        int res=0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) {
                    StringBuilder sb= new StringBuilder();
                    helper(grid,i,j,0,0, sb);
                    String s=sb.toString();
                    if(!set.contains(s)){
                    res++;
                    set.add(s);
}
                }
            }
        }
            return res;
    }
    
    public  void helper(int[][] grid,int i,int j, int xpos, int ypos,StringBuilder sb){
        grid[i][j]=0;
        sb.append(xpos+""+ypos);
        for(int[] dir : dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]==0) continue;
            helper(grid,x,y,xpos+dir[0],ypos+dir[1],sb);
        }
    }
}
UPDATE: We can use direction string instead of using number string in set.
Below is @wavy code using direction string.

public int numDistinctIslands(int[][] grid) {
    Set<String> set = new HashSet<>();
    for(int i = 0; i < grid.length; i++) {
        for(int j = 0; j < grid[i].length; j++) {
            if(grid[i][j] != 0) {
                StringBuilder sb = new StringBuilder();
                dfs(grid, i, j, sb, "o"); // origin
                grid[i][j] = 0;
                set.add(sb.toString());
            }
        }
    }
    return set.size();
}
private void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
    if(i < 0 || i == grid.length || j < 0 || j == grid[i].length 
       || grid[i][j] == 0) return;
    sb.append(dir);
    grid[i][j] = 0;
    dfs(grid, i-1, j, sb, "u");
    dfs(grid, i+1, j, sb, "d");
    dfs(grid, i, j-1, sb, "l");
    dfs(grid, i, j+1, sb, "r");
    sb.append("b"); // back
}
*/
