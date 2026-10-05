/**
Solution 1: Topdown with memoization
get the text 1 length and form rows, get the text 2 length and form the column. The 2d tables show different nodes. Use DFS to search for the nodes that have matching characters.

Time complexity: O(m*n)
Space complexity: O(m*n)

Solution 2: Bottom-up DP with rolling rows.
Let dp[r][c] be the LCS length of text1[r..] and text2[c..] (the suffixes starting at r and c).
Base case: an empty suffix has LCS 0, so the extra last row and last column are all 0.
Fill the table from the bottom-right toward the top-left:
  - If text1[r] == text2[c], the characters extend the subsequence:
        dp[r][c] = 1 + dp[r+1][c+1]   (diagonal)
  - Otherwise, skip a character from one string or the other:
        dp[r][c] = max(dp[r+1][c], dp[r][c+1])   (below, right)

Time complexity: O(m*n)
Space complexity: O(n)
*/

public class Leetcode1143 {
    public int longestCommonSubsequenceTd(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] memo = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                memo[i][j] = - 1;
            }
        }
        return help(m,n,0,0,memo, text1, text2);
    }

    private int help(int m, int n, int x, int y, int[][] memo, String text1, String text2) {
        if(x == m || y == n) {
            return 0;
        }

        if(memo[x][y] != -1) {
            return memo[x][y];
        }

        int total = 0;

        if (text1.charAt(x) == text2.charAt(y)) {
            total += 1 + help(m,n,x+1,y+1,memo,text1,text2);
        } else {
            total += Math.max(help(m,n,x+1,y,memo,text1,text2), help(m,n,x,y+1,memo,text1,text2));
        }

        memo[x][y] = total;

        return memo[x][y];
    }

    public int longestCommonSubsequencBtu(String text1, String text2) {
        int m = text1.length() + 1;
        int n = text2.length() + 1;
        int[] row1 = new int[n];
        int[] row2 = new int[n];

        for (int r = m - 2; r >= 0; r--) {
            for (int c = n - 2; c >= 0; c--) {
                if(text1.charAt(r) == text2.charAt(c)) {
                    row2[c] = 1 + row1[c+1];
                } else {
                    row2[c] = Math.max(row2[c+1],row1[c]);
                }
            }
            row1 = row2;
            row2 = new int[n];
        }

        return row1[0];
    }
}