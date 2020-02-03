/*
Bipartite Graph (Function Problem)
Show Topic Tags       
Given an adjacency matrix representation of a graph g having 0 based index your task is to complete the function isBipartite which returns true if the graph is a bipartite graph else returns false.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer v denoting the no of vertices of the graph then in the next line are v*v space separated values of the adjacency matrix representation of the graph g.

Output:
For each test case in a new line output will be 1 if the graph is bipartite else 0.

Constraints:
1<=T<=100
1<=v<=15
0<=g[][]<=1

Example(To be used only for expected output):
Input:
2
4
0 1 0 1 1 0 1 0 0 1 0 1 1 0 1 0
3
0 1 0 0 0 1 1 0 0
Output:
1
0

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.
*/

/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*Complete the function below*/
class GfG
{
    boolean isBipartite(int G[][],int V)
    {
      int[] color = new int[V];
      for (int i = 0; i < V; i++) {
          if (color[i] == 0) {
              if (!dfs(i, color, G, 1)) {
                  return false;
              }
          }
      }
      return true;
    }
        
    boolean dfs(int i, int[] color, int[][] G, int thisColor) {
        int V = color.length;
        color[i] = thisColor;
        for (int j = 0; j < V; j++) {
            if (G[i][j] == 1) {
                if (color[j] == 0) {
                    if (!dfs(j, color, G, -1 * thisColor)) {
                        return false;
                    };
                } else if (color[j] == color[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
