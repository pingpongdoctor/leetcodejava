// 1143. Longest Common Subsequence
public class LongestCommonSubsequence {
  // bottom up solution
  public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[] prev = new int[n + 1];
    for (int i = m; i >= 0; i--) {
      int[] cur = new int[n + 1];
      if (i == m) {
        for (int j = n - 1; j >= 0; j--) {
          cur[j] = n - j;
        }
        prev = cur;
        continue;
      }
      cur[n] = m - i;
      for (int k = n - 1; k >= 0; k--) {
        if (word2.charAt(k) == word1.charAt(i)) {
          cur[k] = prev[k + 1];
        } else {
          cur[k] = Math.min(prev[k], Math.min(cur[k + 1], prev[k + 1])) + 1;
        }
      }
      prev = cur;
    }
    return prev[0];
  }
}