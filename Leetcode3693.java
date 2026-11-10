/**
Top-down DP with memoization. goTo returns the minimum total cost to reach step e. Step e can be reached from e-1, e-2, or e-3, so we recursively compute the cost of reaching each of those and add the cost of the final jump. The base cases are e <= 0 (cost 0), e == 1 and e == 2. The memo array caches results so each step is computed only once.

Time complexity: O(n)
Space complexity: O(n)
*/

public class Leetcode3693 {
    public int climbStairs(int n, int[] costs) {
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return goTo(n, costs, memo);
    }
    private int cost(int s, int e, int[] costs) {
        if(s < 0 || e < 1) {
            return 0;
        }

        return costs[e - 1] + (int) Math.pow(e - s,2);
    }

    private int goTo(int e, int[] costs, int[] memo) {
        if(e <= 0) {
            return 0;
        }

        if(e == 1) {
            return cost(0, 1,costs);
        }

        if(e == 2) {
            return Math.min(cost(0,1,costs) + cost(1,2,costs), cost(0,2,costs));
        }

        if(memo[e - 1] != -1) {
            return memo[e - 1];
        }

        int path1 = cost(e-1,e,costs) + goTo(e-1, costs, memo);
        int path2 = cost(e-2,e,costs) + goTo(e-2, costs, memo);
        int path3 = cost(e-3,e,costs) + goTo(e-3, costs, memo);

        memo[e - 1] =  Math.min(path1, Math.min(path2,path3));
        return memo[e - 1];
    }
}