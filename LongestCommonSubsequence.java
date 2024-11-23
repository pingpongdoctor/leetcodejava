// 1143. Longest Common Subsequence
public class LongestCommonSubsequence {
  // bottom up solution
  public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length() + 1;
    int n = text2.length() + 1;
    int[] prevRow = new int[n];
    for (int i = 1; i < m; i++) {
      int[] curRow = new int[n];
      curRow[0] = 0;
      for (int j = 1; j < n; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          curRow[j] = prevRow[j - 1] + 1;
        } else {
          curRow[j] = Math.max(prevRow[j], curRow[j - 1]);
        }
      }
      prevRow = curRow;
    }
    return prevRow[prevRow.length - 1];
  }
}