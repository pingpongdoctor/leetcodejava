// dfs from edges of the board to look for invalid regions
// the regions marked with danger marks are not valid for being found as surrounded land
// turn regions that are not danger into water
public class SurroundedRegions {
  private void dfs(char[][] board, boolean[][] danger, int r, int c) {
    int row = board.length;
    int column = board[0].length;

    if (Math.min(r, c) < 0 || r > row - 1 || c > column - 1 || danger[r][c] || board[r][c] == 'X') {
      return;
    }

    danger[r][c] = true;
    dfs(board, danger, r + 1, c);
    dfs(board, danger, r - 1, c);
    dfs(board, danger, r, c + 1);
    dfs(board, danger, r, c - 1);
  }

  public void solve(char[][] board) {
    int row = board.length;
    int column = board[0].length;
    boolean[][] danger = new boolean[row][column];

    for (int r = 0; r < row; r++) {
      if (board[r][0] == 'O') {
        dfs(board, danger, r, 0);
      }
      if (board[r][column - 1] == 'O') {
        dfs(board, danger, r, column - 1);
      }
    }

    for (int c = 0; c < column; c++) {
      if (board[0][c] == 'O') {
        dfs(board, danger, 0, c);
      }
      if (board[row - 1][c] == 'O') {
        dfs(board, danger, row - 1, c);
      }
    }

    for (int r = 0; r < row; r++) {
      for (int c = 0; c < column; c++) {
        if (board[r][c] == 'O' && !danger[r][c]) {
          board[r][c] = 'X';
        }
      }
    }
  }
}
