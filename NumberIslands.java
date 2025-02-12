// 200. Number of Islands
// dfs vertices with value 1 to convert all neighbor values to 0
// increment count variable when encountering value 1
public class NumberIslands {
  private void dfs(char[][] grid, int r, int c) {
    int row = grid.length;
    int column = grid[0].length;

    if (Math.min(r, c) < 0 || r > row - 1 || c > column - 1 || grid[r][c] == '0') {
      return;
    }

    grid[r][c] = '0';
    dfs(grid, r + 1, c);
    dfs(grid, r - 1, c);
    dfs(grid, r, c + 1);
    dfs(grid, r, c - 1);
  }

  public int numIslands(char[][] grid) {
    int row = grid.length;
    int column = grid[0].length;
    int count = 0;
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < column; c++) {
        if (grid[r][c] == '1') {
          count++;
          dfs(grid, r, c);
        }
      }
    }
    return count;
  }
}
