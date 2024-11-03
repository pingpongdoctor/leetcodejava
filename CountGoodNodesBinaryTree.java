// 1448. Count Good Nodes in Binary Tree
public class CountGoodNodesBinaryTree {
  private int dfs(TreeNode root, int prev) {
    if (root == null) {
      return 0;
    }
    int count = 0;
    if (root.val >= prev) {
      count++;
    }
    count += dfs(root.left, Math.max(root.val, prev));
    count += dfs(root.right, Math.max(root.val, prev));
    return count;
  }

  public int goodNodes(TreeNode root) {
    return dfs(root, Integer.MIN_VALUE);
  }
}