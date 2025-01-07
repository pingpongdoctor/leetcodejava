import java.util.LinkedList;
import java.util.Queue;

//73. Set Matrix Zeroes
public class SetMatrixZeroes {
  // bfs
  private void bfs(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    boolean[][] visit = new boolean[m][n];
    Queue<int[]> queue = new LinkedList<>();

    boolean[] rows = new boolean[m];
    boolean[] columns = new boolean[n];

    visit[0][0] = true;
    queue.add(new int[2]);

    while (!queue.isEmpty()) {
      int curSize = queue.size();

      for (int i = 0; i < curSize; i++) {
        int[] curCoordinate = queue.poll();
        int r = curCoordinate[0];
        int c = curCoordinate[1];

        if (matrix[r][c] == 0) {
          rows[r] = true;
          columns[c] = true;
        }

        int[][] neighbors = { { r, c + 1 }, { r, c - 1 }, { r + 1, c }, { r - 1, c } };

        for (int[] neighbor : neighbors) {
          int R = neighbor[0];
          int C = neighbor[1];

          if (Math.min(R, C) < 0 || R > m - 1 || C > n - 1 || visit[R][C]) {
            continue;
          }
          queue.add(neighbor);
          visit[R][C] = true;
        }
      }
    }

    for (int j = 0; j < rows.length; j++) {
      if (rows[j]) {
        int c = 0;
        while (c < n) {
          matrix[j][c] = 0;
          c++;
        }
      }
    }

    for (int k = 0; k < columns.length; k++) {
      if (columns[k]) {
        int r = 0;
        while (r < m) {
          matrix[r][k] = 0;
          r++;
        }
      }
    }
  }

  public void setZeroes(int[][] matrix) {
    bfs(matrix);
  }
}