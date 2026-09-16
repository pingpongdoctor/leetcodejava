
/**
Solution 1: Top down with memoization
The number of way to reach the nth step is equal to the number of way reaching the nth - 1 and nth - 2 step
Base case is the number of way taken to reach to the 1th step is 1 and to 2th step is 2
Time complexity: O(n)
Space complexity: O(n)

Solution 2: Bottom up
Time complexity: O(n)
Space complexity: O(1)

*/

public class Leetcode70 {
    public int climbStairs(int n) {
        if(n==1 || n==2) {
            return n;
        }

        int prev = 1;
        int next = 2;

        for (int i = 2; i < n; i++) {
            int temp = next;
            next = prev + next;
            prev = temp;
        }

        return next;
    }
}