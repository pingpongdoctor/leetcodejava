// 530. Minimum Absolute Difference in BST
// dfs
// in BST, if we implement inorder traversal, we can get a list of sorted values in the ascending order
// we can subtract these consecutive sorted values to find the munimum absolute difference
// there is a need to track the prev node using a TreeNode prev instance variable that is initialized with null
// before traversing to the next node from the current node, the prev node is updated to the current node
public class MinimumAbsoluteDifferenceBST {
  int min = Integer.MAX_VALUE;
  TreeNode prev = null;

  private void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    dfs(root.left);
    if (prev != null) {
      min = Math.min(min, Math.abs(root.val - prev.val));
    }
    prev = root;
    dfs(root.right);
  }

  public int getMinimumDifference(TreeNode root) {
    dfs(root);
    return min;
  }
}
