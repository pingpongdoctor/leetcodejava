import java.util.LinkedList;
import java.util.Queue;

// 289. Game of Life
// bfs
// only check first state when traversing since we want to simultaneously update all vertices
// 2 means dead to live
// 3 means live to dead
public class GameOfLife {
  private int liveNum(int r, int c, int[][] board, int m, int n) {
    int live = 0;
    live += r + 1 <= m - 1 && (board[r + 1][c] == 1 || board[r + 1][c] == 3) ? 1 : 0;
    live += r - 1 >= 0 && (board[r - 1][c] == 1 || board[r - 1][c] == 3) ? 1 : 0;
    live += c + 1 <= n - 1 && (board[r][c + 1] == 1 || board[r][c + 1] == 3) ? 1 : 0;
    live += c - 1 >= 0 && (board[r][c - 1] == 1 || board[r][c - 1] == 3) ? 1 : 0;

    live += r + 1 <= m - 1 && c + 1 <= n - 1 && (board[r + 1][c + 1] == 1 || board[r + 1][c + 1] == 3) ? 1 : 0;
    live += r - 1 >= 0 && c - 1 >= 0 && (board[r - 1][c - 1] == 1 || board[r - 1][c - 1] == 3) ? 1 : 0;
    live += r - 1 >= 0 && c + 1 <= n - 1 && (board[r - 1][c + 1] == 1 || board[r - 1][c + 1] == 3) ? 1 : 0;
    live += r + 1 <= m - 1 && c - 1 >= 0 && (board[r + 1][c - 1] == 1 || board[r + 1][c - 1] == 3) ? 1 : 0;
    return live;
  }

  public void gameOfLife(int[][] board) {
    int m = board.length;
    int n = board[0].length;
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visit = new boolean[m][n];
    queue.add(new int[2]);
    visit[0][0] = true;
    // deadToLive: 2;
    // liveToDead: 3;
    while (!queue.isEmpty()) {
      int curSize = queue.size();

      for (int i = 0; i < curSize; i++) {
        int[] cur = queue.poll();
        int r = cur[0];
        int c = cur[1];

        int live = liveNum(r, c, board, m, n);

        if (board[r][c] == 1 && (live < 2 || live > 3)) {
          board[r][c] = 3;
        }
        if (board[r][c] == 0 && live == 3) {
          board[r][c] = 2;
        }

        int[][] neighbors = { { r, c + 1 }, { r, c - 1 }, { r + 1, c }, { r - 1, c } };
        for (int[] ng : neighbors) {
          int R = ng[0];
          int C = ng[1];
          if (Math.min(R, C) < 0 || R > m - 1 || C > n - 1 || visit[R][C]) {
            continue;
          }
          queue.add(ng);
          visit[R][C] = true;
        }
      }
    }
    for (int j = 0; j < m; j++) {
      for (int k = 0; k < n; k++) {
        if (board[j][k] == 3) {
          board[j][k] = 0;
        }
        if (board[j][k] == 2) {
          board[j][k] = 1;
        }
      }
    }
  }
}