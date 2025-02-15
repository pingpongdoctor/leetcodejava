import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 909. Snakes and Ladders
// Use bfs to find the shortest path to the last vertex
// Key point is calculating row index based on current value
// Since vertices are allocated zigzag. We can culate column index from left to right if row idx and n are not even or odd at the same time
// Otherwise, we can calculate column index from right to left
public class SnakesLadders {
  public int snakesAndLadders(int[][] board) {
    int n = board.length;
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visit = new HashSet<>();
    queue.add(1);
    visit.add(1);
    int step = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int cur = queue.poll();
        if (cur == n * n) {
          return step;
        }
        for (int j = 1; j <= 6; j++) {
          int next = cur + j;
          if (next > n * n) {
            break;
          }
          int r = n - 1 - ((int) Math.floor((next - 1) / n));
          int c = (r % 2 == (n % 2)) ? (n - 1 - (next - 1) % n) : (next - 1) % n;
          if (board[r][c] != -1) {
            next = board[r][c];
          }
          if (visit.contains(next)) {
            continue;
          }
          queue.add(next);
          visit.add(next);
        }
      }
      step++;
    }
    return -1;
  }
}
