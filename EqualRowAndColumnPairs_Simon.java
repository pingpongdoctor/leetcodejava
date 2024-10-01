import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//convert row to string and add them at keys into hashmap, values are their frequencies
//compare colum string with row string
class EqualRowAndColumnPairs_Simon {
  public int equalPairs(int[][] grid) {
    int n = grid.length;
    Map<String, Integer> map = new HashMap<String, Integer>();
    for (int[] row : grid) {
      String rowString = Arrays.toString(row);
      map.put(rowString, map.getOrDefault(rowString, 0) + 1);
    }
    int count = 0;
    for (int i = 0; i < n; i++) {
      int[] col = new int[n];
      for (int j = 0; j < n; j++) {
        col[j] = grid[j][i];
      }
      count += map.getOrDefault(Arrays.toString(col), 0);
    }
    return count;
  }
}