/**
Solution 1: Topdown, check the current characters in both string, decide what to do next. Call function recursively on next characters depending on whether insert, delete or replace is done. if two current characters are the same, just move pointers of both string to the right. by the time either of the string is out of bound, calculate the remaining characters of the inbound string as the number of additional operations and return it.

Time complexity: O(m*n)
Space complexity: O(m*n)
*/

public class Leetcode72 {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for(int i = 0; i < word1.length(); i++) {
            for(int j = 0; j < word2.length(); j++) {
                memo[i][j] = -1;
            }
        }

        if (word1.length() == 0 || word2.length() == 0) {
            return word1.length() > word2.length() ? word1.length() : word2.length();
        }
        
        return helper(word1, word2, 0, 0, memo);
    }

    private int helper(String word1, String word2, int i, int j, int[][] memo) {
        if(i >= word1.length()) {
            return word2.length() - j;
        }

        if(j >= word2.length()) {
            return word1.length() - i;
        }

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        int min = word1.length() + word2.length();

        if(word1.charAt(i) == word2.charAt(j)) {
            min = Math.min(min, helper(word1, word2, i+1, j+1, memo));
        } else {
            min = Math.min(min, 1 + helper(word1, word2, i, j + 1, memo));
            min = Math.min(min, 1 + helper(word1, word2, i + 1, j, memo));
            min = Math.min(min, 1 + helper(word1, word2, i + 1, j + 1, memo));
        }

        memo[i][j] = min;

        return min;
    }
}