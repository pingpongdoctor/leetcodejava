/**
 * Solution 1: Top down and memoization
Time complexity: O(n)
Space complexity: O(n)

Solution 2: Bottom up
As we know that getting to the first stair and second stair cost 0 fee and the least cost getting to a nth stair is equal to the minimum of
cost taken getting to the n-1 th stair plus the cost to leave the that stair and cost taken getting to the n-2 th stair plus the cost to leave the that stair. We can gradually compute the next stair minimum cost access till we pass the stair to the roof.
Time complexity: O(n)
Space complexity: O(1)
*/

public class Leetcode746 {
    public int minCostClimbingStairs(int[] cost) {
        int size = cost.length;
        int[] memo = new int[cost.length + 1];
        
        for(int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return helper(size, cost, memo);
    }
    private int helper(int idx, int[] cost, int[] memo) {
        if(idx == 0 || idx == 1) {
            return 0;
        }

        if(memo[idx] != -1) {
            return memo[idx];
        }
        
        memo[idx] = Math.min(helper(idx-1, cost, memo) + cost[idx-1], helper(idx-2, cost, memo) + cost[idx - 2]);

        return memo[idx];
    }

        public int minCostClimbingStairs2(int[] cost) {
        if(cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int prev = 0;
        int cur = 0;

        // By the time the last iteration is completed, the prev store the minimum cost taken to access the second last step and the cur store the minimum cost taken to reach to the last step
        for (int i = 2; i <= cost.length; i++) {
            int temp = cur;
            cur = Math.min(prev + cost[i-2], cur + cost[i-1]);
            prev = temp;
        }
        return cur;
    }
}