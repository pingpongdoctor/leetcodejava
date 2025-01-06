import java.util.ArrayList;
import java.util.List;

// 54. Spiral Matrix
public class SpiralMatrix {
  public List<Integer> spiralOrder(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    List<Integer> ans = new ArrayList<>();
    boolean[][] visit = new boolean[m][n];
    // 0 right, 1 down, 2 left, 3 up
    int dr = 0;
    int r = 0;
    int c = 0;
    while (ans.size() < m * n) {
      if (!visit[r][c]) {
        ans.add(matrix[r][c]);
        visit[r][c] = true;
      }

      if (dr == 0 && (c == n - 1 || visit[r][c + 1])) {
        dr = 1;
        r++;
        continue;
      }

      if (dr == 1 && (r == m - 1 || visit[r + 1][c])) {
        dr = 2;
        c--;
        continue;
      }

      if (dr == 2 && (c == 0 || visit[r][c - 1])) {
        dr = 3;
        r--;
        continue;
      }

      if (dr == 3 && (r == 0 || visit[r - 1][c])) {
        dr = 0;
        c++;
        continue;
      }

      if (dr == 0) {
        c++;
      } else if (dr == 1) {
        r++;
      } else if (dr == 2) {
        c--;
      } else {
        r--;
      }
    }
    return ans;
  }
}