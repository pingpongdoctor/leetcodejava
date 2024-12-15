import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 45. Jump Game II
public class JumpGameII {
  // BFS with visit set
  // In tree, we do not need to use visit set to avoid revisiting the same node
  // since every node is different
  // In this case, it is different since this tree has duplicate nodes and has the
  // same nature as graph
  public int jump(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }
    // queue to process index at every level
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    int jump = 0;
    Set<Integer> visit = new HashSet<>();
    while (!queue.isEmpty()) {
      int curSize = queue.size();
      for (int i = 0; i < curSize; i++) {
        int cur = queue.poll();
        // check if at last index
        if (cur >= nums.length - 1) {
          return jump;
        }
        // get max steps
        int maxSteps = nums[cur];
        // if max steps is 0, it is an invalid path, move to the next value in this
        // level
        if (maxSteps == 0) {
          continue;
        }
        // add values of the next level to the queue
        for (int j = 1; j <= maxSteps; j++) {
          if (visit.contains(cur + j)) {
            continue;
          }
          queue.add(cur + j);
          visit.add(cur + j);
        }
      }
      jump++;
    }
    return 0;
  }

  // topdown solution
  // dfs the tree that has duplicate nodes requires memoization to avoid
  // overlapping calculation
  private int dfs(int[] nums, int idx, Integer[] memo) {
    if (idx >= nums.length - 1) {
      return 0;
    }
    if (idx + nums[idx] >= nums.length - 1) {
      return 1;
    }
    if (nums[idx] == 0) {
      return Integer.MAX_VALUE;
    }
    if (memo[idx] != null) {
      return memo[idx];
    }

    int minJump = Integer.MAX_VALUE;
    for (int i = 1; i <= nums[idx]; i++) {
      int jump = dfs(nums, idx + i, memo);
      // do not update minJump if it is an invalid path
      if (jump != Integer.MAX_VALUE) {
        minJump = Math.min(minJump, jump + 1);
      }
    }
    memo[idx] = minJump;
    return minJump;
  }

  public int jump2(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }
    return dfs(nums, 0, new Integer[nums.length]);
  }
}
