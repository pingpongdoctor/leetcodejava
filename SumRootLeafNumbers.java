// 129. Sum Root to Leaf Numbers
// DFS
public class SumRootLeafNumbers {
  int ans = 0;

  private void dfs(TreeNode node, int sum) {
    if (node == null) {
      return;
    }
    sum = sum * 10 + node.val;
    if (node.left == null && node.right == null) {
      ans += sum;
      return;
    }
    dfs(node.left, sum);
    dfs(node.right, sum);
  }

  public int sumNumbers(TreeNode root) {
    dfs(root, 0);
    return ans;
  }
}