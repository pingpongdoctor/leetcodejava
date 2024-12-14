// 55. Jump Game
public class JumpGame {
  // two pointers
  public boolean canJump(int[] nums) {
    // move the goal to the left if the current idx can reach the goal
    int goal = nums.length - 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      if (nums[i] + i >= goal) {
        goal = i;
      }
    }
    return goal == 0;
  }

  // DP topdown solution
  private boolean dfs(int[] nums, int idx, Boolean[] memo) {
    if (idx >= nums.length - 1 || nums[idx] >= nums.length - 1 - idx) {
      return true;
    }
    if (nums[idx] == 0) {
      return false;
    }
    if (memo[idx] != null) {
      return memo[idx];
    }
    boolean isPossible = false;
    for (int i = 1; i <= nums[idx]; i++) {
      if (dfs(nums, idx + i, memo)) {
        isPossible = true;
      }
    }
    memo[idx] = isPossible;
    return isPossible;
  }

  public boolean canJump2(int[] nums) {
    return dfs(nums, 0, new Boolean[nums.length]);
  }

}
