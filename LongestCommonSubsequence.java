// 1143. Longest Common Subsequence
public class LongestCommonSubsequence {
  // bottom up solution
  public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();
    int[] prevRow = new int[n + 1];
    for (int i = m - 1; i >= 0; i--) {
      int[] curRow = new int[n + 1];
      curRow[n] = 0;
      for (int j = n - 1; j >= 0; j--) {
        if (text1.charAt(i) == text2.charAt(j)) {
          curRow[j] = prevRow[j + 1] + 1;
        } else {
          curRow[j] = Math.max(prevRow[j], curRow[j + 1]);
        }
      }
      prevRow = curRow;
    }
    return prevRow[0];
  }
}