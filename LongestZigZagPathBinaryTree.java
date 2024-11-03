// 1372. Longest ZigZag Path in a Binary Tree
public class LongestZigZagPathBinaryTree {
  int maxCount = 0;

  private void dfs(TreeNode root, int curBranch, int count) {
    if (root == null) {
      return;
    }
    count++;
    maxCount = Math.max(maxCount, count);
    if (curBranch == 1) {
      dfs(root.right, 2, count);
      dfs(root.left, 1, 1);
    }
    if (curBranch == 2) {
      dfs(root.left, 1, count);
      dfs(root.right, 2, 1);
    }
  }

  public int longestZigZag(TreeNode root) {
    dfs(root, 1, 0);
    dfs(root, 2, 0);
    return maxCount == 0 ? maxCount : maxCount - 1;
  }
}