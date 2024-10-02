/* problem
 * 200. Number of Islands
Medium

22943

524

Add to List

Share
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */

package graph_data_structure;

public class problem2 {
    // static int m = 5;
    // static int n = 4;

    public void dfs_traversal(char[][] grid, int r, int c, boolean[][] vis) {
        // Check if out of bounds or if the cell is already visited or water
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0' || vis[r][c]) {
            return;
        }

        // Mark the current cell as visited
        vis[r][c] = true;

        // Explore all four directions
        dfs_traversal(grid, r + 1, c, vis); // down
        dfs_traversal(grid, r - 1, c, vis); // up
        dfs_traversal(grid, r, c + 1, vis); // right
        dfs_traversal(grid, r, c - 1, vis); // left
    }

    public int numIslands(char[][] grid) {
        int counter = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    // visited[i][j]=true;
                    counter++;
                    dfs_traversal(grid, i, j, visited);
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };

        problem2 problem = new problem2();
        System.out.println("Number of islands: " + problem.numIslands(grid)); // Should output 1
    }
}
