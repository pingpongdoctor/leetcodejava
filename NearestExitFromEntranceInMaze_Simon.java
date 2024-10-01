import java.util.LinkedList;
import java.util.Queue;

class NearestExitFromEntranceInMaze_Simon {
  public int nearestExit(char[][] maze, int[] entrance) {
    // set up
    int row = maze.length;
    int col = maze[0].length;
    int[][] visit = new int[row][col];
    Queue<int[]> queue = new LinkedList<int[]>();
    queue.add(entrance);
    visit[entrance[0]][entrance[1]] = 1;
    int steps = 0;
    // base case
    if (maze[entrance[0]][entrance[1]] == '+') {
      return -1;
    }
    // BFS
    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      for (int i = 0; i < queueSize; i++) {
        int[] pair = queue.poll();
        int r = pair[0];
        int c = pair[1];
        // check if we are at the exit
        if ((
        // entrance is not counted as exit
        r != entrance[0] || c != entrance[1]) &&
        // exit is where we reach the border of the grid
            (r == row - 1 || c == col - 1 || r == 0 || c == 0)) {
          return steps;
        }
        int[][] neighbors = { { r, c + 1 }, { r, c - 1 }, { r + 1, c }, { r - 1, c } };
        for (int j = 0; j < 4; j++) {
          int newR = neighbors[j][0];
          int newC = neighbors[j][1];
          if (Math.min(newR, newC) < 0 || newR == row || newC == col || maze[newR][newC] == '+'
              || visit[newR][newC] == 1) {
            continue;
          }
          queue.add(neighbors[j]);
          visit[newR][newC] = 1;
        }
      }
      steps++;
    }
    return -1;
  }
}