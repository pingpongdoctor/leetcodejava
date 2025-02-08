// 222. Count Complete Tree Nodes
// DFS
public class CountCompleteTreeNodes {
  private int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int sum = 1;
    sum += dfs(root.right);
    sum += dfs(root.left);
    return sum;
  }

  public int countNodes(TreeNode root) {
    return dfs(root);
  }
}
