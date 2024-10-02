import java.util.LinkedList;
import java.util.Queue;

//994. Rotting Oranges
class RottingOranges_Simon {
  public int orangesRotting(int[][] grid) {
    // set up
    int rows = grid.length;
    int cols = grid[0].length;
    Queue<int[]> queue = new LinkedList<int[]>();
    int freshCount = 0;
    for (int k = 0; k < rows; k++) {
      for (int z = 0; z < cols; z++) {
        if (grid[k][z] == 2) {
          int[] newPair = { k, z };
          queue.add(newPair);
        } else if (grid[k][z] == 1) {
          freshCount++;
        }
      }
    }
    if (freshCount == 0) {
      return 0;
    }
    int mins = 0;
    // BFS
    while (!queue.isEmpty()) {
      int curSize = queue.size();
      boolean rotted = false;
      for (int i = 0; i < curSize; i++) {
        int[] coordinate = queue.poll();
        int r = coordinate[0];
        int c = coordinate[1];
        int[][] neighbors = { { r, c + 1 }, { r, c - 1 }, { r + 1, c }, { r - 1, c } };
        for (int j = 0; j < 4; j++) {
          int[] n = neighbors[j];
          int newR = n[0];
          int newC = n[1];
          if (Math.min(newR, newC) < 0 || newR == rows || newC == cols || grid[newR][newC] == 2) {
            continue;
          }
          if (grid[newR][newC] == 1) {
            grid[newR][newC] = 2;
            int[] newRottenOrange = { newR, newC };
            queue.add(newRottenOrange);
            freshCount--;
            rotted = true;
          }
        }
      }
      if (rotted) {
        mins++;
      }
    }
    return freshCount == 0 ? mins : -1;
  }
}