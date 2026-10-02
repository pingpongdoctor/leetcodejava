/**
Solution: Topdown. Use dfs to traverse deeply and find all possible paths. Use memoization and make it dynamic programming solution
Time complexity: O(m*n)
Space complexity: O(m*n)

Solution bottom up
Time complexity: O(m*n)
Space complexity: O(n)
*/

public class Leetcode62 {
    public int uniquePathsTopdown(int m, int n) {
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        return dfs(m,n,0,0,memo);
    }

    private int dfs(int m, int n, int x, int y, int[][] memo) {
        if(x == m - 1 && y == n - 1) {
            return 1;
        }

        if(x == m || y == n) {
            return 0;
        }

        if(memo[x][y] != -1) {
            return memo[x][y];
        }

        int totalPath = 0;

        totalPath += dfs(m,n,x+1,y,memo);
        totalPath += dfs(m,n,x,y+1,memo);
        memo[x][y] = totalPath;
        return totalPath;
    }

    public int uniquePathsBottomUp(int m, int n) {
        int[] row1 = new int[n];

        for(int i = 0; i < row1.length; i++) {
            row1[i] = 1;
        }

        int[] row2 = new int[n];

        for(int i = 0; i < m - 1; i++) {
            int j = n - 1;
            
            if(j == n - 1) {
                row2[j] = 1;
                j--;
            }

            while(j >= 0) {
                row2[j] = row2[j+1] + row1[j];
                j--;
            }

            row1 = row2;
            row2 = new int[n];
        }

        return row1[0];
    }
}

/**
Solution: Topdown. Use dfs to traverse deeply and find all possible paths. Use memoization and make it dynamic programming solution
Time complexity: O(m*n)
Space complexity: O(m*n)

Solution bottom up

*/
