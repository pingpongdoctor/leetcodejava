/**
Solution 1: Scan the grid cell by cell. Each time we hit a '1' that hasn't been visited, we've found a new island, so we increment the count and run DFS from that cell. The DFS sinks the island by setting every connected '1' (up, down, left, right) to '0'. There is no cell is counted twice and no separate visited array is needed.

Time complexity: O(m*n)
Space complexity: O(m*n)
*/

public class Leetcode200 {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(grid[r][c] == '1') {
                    count++;
                    dfs(grid,r,c);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        if(r >= m || c >= n || r < 0 || c < 0 || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}