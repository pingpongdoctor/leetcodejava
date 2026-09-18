/**
Solution 1: Top down solution + memoization
way1 = rob cur house + func(i + 2, n-1) with i is the cur house index and n is the size of the array
if cur house is the first house, recursively call the func on i + 2 to n - 2
way2 = do not rob the cur house and call func(i+1, n-1);
return Math.max(way1, way2)
Since the helper function recursively called on i and j, we need two memo. 1 is for the case where j is  n - 1 and the other is not

Time complexity: O(n)
Space complexity: O(n)
0   1   2   3   4
1   3   1   3   100

Solution 2: Bottom up solution. Break the current case into two sub problem 0 to n - 2 and 1 to n - 1 and run the bottomUp function on these sub problem to calculate the maximum amount of money robbed from right to left using the base cases of robbing last house and robbing last two houses

Time complexity: O(n)
Space complexity: O(1)
*/

public class Leetcode213 {
    public int rob(int[] nums) {
        int[] memo1 = new int[nums.length];
        int[] memo2 = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            memo1[i] = -1;
            memo2[i] = -1; 
        }
        return helper(nums, 0, nums.length - 1, memo1, memo2);
    }

    private int helper(int[] nums, int i, int j, int[] memo1, int[] memo2) {
        if(i > j) {
            return 0;
        }

        if(j == nums.length - 1 && memo1[i] != -1) {
            return memo1[i];
        }
        
        if(j != nums.length - 1 && memo2[i] != -1) {
            return memo2[i];
        }

        int option1 = nums[i] + helper(nums, i+2, i == 0 ? nums.length - 2 : j, memo1, memo2);
        int option2 = helper(nums, i+1, j, memo1, memo2);

        int max = Math.max(option1, option2);
        if(j == nums.length - 1) {
            memo1[i] = max;
        } else {
            memo2[i] = max;
        }

        return max;
    }

    public int rob2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(bottomUp(nums, 0, nums.length - 2), bottomUp(nums, 1, nums.length - 1));
    }

    private int bottomUp(int[] nums, int i, int j) {
        int next = nums[j];
        int cur = Math.max(nums[j - 1], next);

        for (int k = j - 2; k >= i; k--) {
            int temp = cur;
            cur = Math.max(nums[k] + next, cur);
            next = temp;
        }

        return cur;
    }
}