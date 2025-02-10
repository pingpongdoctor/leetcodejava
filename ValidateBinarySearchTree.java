// 98. Validate Binary Search Tree
// DFS inorder traversal to check if we traverse from the smallest value to the largest value
public class ValidateBinarySearchTree {
  TreeNode prev;
  boolean ans = true;

  private void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    dfs(root.left);
    if (prev != null) {
      if (prev.val >= root.val) {
        ans = false;
        return;
      }
    }
    prev = root;
    dfs(root.right);
  }

  public boolean isValidBST(TreeNode root) {
    dfs(root);
    return ans;
  }
}
