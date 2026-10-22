/**
Time complexity: O(m*n) to loop through the table, O(m*n) to dfs every time we encouter 1. Since we mark the visited node as water, each node will only process once.
The final time complexity: O(m*n)
Space complexity: O(m*n)
*/

public class Leetcode695 {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, helper(grid, i, j));
                }
            }
        }

        return max;
    }
    private int helper(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;

        int total = 1;

        total += helper(grid, r, c + 1);
        total += helper(grid, r, c - 1);
        total += helper(grid, r + 1, c);
        total += helper(grid, r - 1, c);

        return total;
    }
}