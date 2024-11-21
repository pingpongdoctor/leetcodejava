// Unique Paths
// At first, I use dfs with visited array to avoid visitting the same coordinates multiple time but get time exceeded which indicates that the memory is not sufficient
// I try the top down solution with memoization and it works well since I avoid reduntdant computation
public class UniquePaths {
  private int dfs(int rows, int cols, int r, int c, int[][] catches) {
    if (Math.min(r, c) < 0 || r == rows || c == cols) {
      return 0;
    }
    if (r == rows - 1 && c == cols - 1) {
      return 1;
    }
    if (catches[r][c] != 0) {
      return catches[r][c];
    }
    int right = dfs(rows, cols, r, c + 1, catches);
    int down = dfs(rows, cols, r + 1, c, catches);
    catches[r][c] = right + down;
    return catches[r][c];
  }

  public int uniquePaths(int m, int n) {
    int[][] catches = new int[m][n];
    return dfs(m, n, 0, 0, catches);
  }
}