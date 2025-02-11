// 200. Number of Islands
// dfs vertices with value 1 to convert all neighbor values to 0
// increment count variable when encountering value 1
public class NumberIslands {
  private void dfs(char[][] grid, boolean[][] visit, int r, int c) {
    int row = grid.length;
    int column = grid[0].length;

    if (Math.min(r, c) < 0 || r > row - 1 || c > column - 1 || visit[r][c] || grid[r][c] == '0') {
      return;
    }

    grid[r][c] = '0';
    visit[r][c] = true;
    dfs(grid, visit, r + 1, c);
    dfs(grid, visit, r - 1, c);
    dfs(grid, visit, r, c + 1);
    dfs(grid, visit, r, c - 1);
    visit[r][c] = false;
  }

  public int numIslands(char[][] grid) {
    int row = grid.length;
    int column = grid[0].length;
    int count = 0;
    boolean[][] visit = new boolean[row][column];
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < column; c++) {
        if (grid[r][c] == '1') {
          count++;
          dfs(grid, visit, r, c);
        }
      }
    }
    return count;
  }
}
