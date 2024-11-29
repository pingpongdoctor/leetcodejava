// 72. Edit Distance
// bottom up solution
public class EditDistance {
  public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[] prev = new int[n + 1];
    for (int i = 0; i < m + 1; i++) {
      int[] cur = new int[n + 1];
      if (i == 0) {
        for (int j = 1; j < n + 1; j++) {
          cur[j] = j;
        }
        prev = cur;
        continue;
      }
      cur[0] = i;
      for (int k = 1; k < n + 1; k++) {
        if (word2.charAt(k - 1) == word1.charAt(i - 1)) {
          cur[k] = prev[k - 1];
        } else {
          cur[k] = Math.min(prev[k], Math.min(cur[k - 1], prev[k - 1])) + 1;
        }
      }
      prev = cur;
    }
    return prev[prev.length - 1];
  }
}