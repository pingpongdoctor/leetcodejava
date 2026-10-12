/**
Solution 1: dp topdown. recursively call a function to compare characters in both strings and the interleaving string. Since the order of string 1 and 2 are kept unchanged relatively, we keep tracking where are the next character in string 3 that appear in string 1 and 2. If the current characters in string 1 and 2 are the same as the character in string 3, that is where the decision is divided into two paths.

Time complexity: O(m*n)
Space complexity: O(m*n)
*/

public class Leetcode97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        } 

        int[][] memo = new int[s1.length() + 1][s2.length() + 1];

        for(int i = 0; i < s1.length() + 1; i++) {
            for(int j = 0; j < s2.length() + 1; j++) {
                memo[i][j] = -1;
            }
        }
        return helper(0,0,s1,s2,s3, memo);
    }

    private boolean helper(int i, int j, String s1, String s2, String s3, int[][] memo) {
        if(i >= s1.length() && j >= s2.length()) {
            return i + j == s3.length();
        }

        if(memo[i][j] != -1) {
            return memo[i][j] == 1;
        }

        boolean path1 = false;
        boolean path2 = false;

        if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j)) {
            path1 = helper(i+1, j, s1,s2,s3,memo);
        }

        if(j < s2.length() && s2.charAt(j) == s3.charAt(i+j)) {
            path2 = helper(i, j+1, s1,s2,s3,memo);
        }

        boolean result = path1 || path2;

        memo[i][j] = result ? 1 : 0;

        return result;
    }
}