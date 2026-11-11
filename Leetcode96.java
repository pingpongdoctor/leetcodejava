/**
We have n possible choices for the root node. For each root choice, we calculate the number of possible BSTs by multiplying the number of possible left and right subtrees.
Memoization ensures that we calculate each distinct subtree size only once. However, each subtree size requires iterating through all possible root choices within that subtree.
Therefore, we have n distinct states, and each state takes up to O(n) time to process, resulting in O(n²) time complexity.

Time complexity: O(n^2)
Space complexity: O(n)
*/

public class Leetcode96 {
    public int numTrees(int n) {
        int[] memo = new int[n+1];
        return helper(n, memo);
    }
    private int helper(int n, int[] memo) {
        if(n <= 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        if(n == 3) {
            return 5;
        }
        if(memo[n] != 0) {
            return memo[n];
        }

        int total = 0;

        for(int i = 1; i <= n; i++) {
            total += helper(i - 1, memo) * helper(n-i, memo);
        }
        memo[n] = total;

        return memo[n];
    }
}