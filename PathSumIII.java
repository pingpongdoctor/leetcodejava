// 437. Path Sum III
//DFS solution with traverse function to dfs from every node of the tree
public class PathSumIII {
  int curPath = 0;

  private void dfs(TreeNode root, long curSum, int targetSum) {
    if (root == null) {
      return;
    }
    curSum += root.val;
    if (curSum == targetSum) {
      curPath++;
    }
    dfs(root.right, curSum, targetSum);
    dfs(root.left, curSum, targetSum);
  }

  private void traverse(TreeNode root, int targetSum) {
    if (root == null) {
      return;
    }
    dfs(root, 0, targetSum);
    traverse(root.right, targetSum);
    traverse(root.left, targetSum);
  }

  public int pathSum(TreeNode root, int targetSum) {
    traverse(root, targetSum);
    return curPath;
  }
}
// Optimized solution