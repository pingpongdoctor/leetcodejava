// 101. Symmetric Tree
// Compare left and right branches
// Compare right node of left branch with left node of right branch
// Compare left node of right branch with right node of left branch
public class SymmetricTree {
  private boolean isMirror(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left == null ^ right == null) {
      return false;
    }
    return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
  }

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isMirror(root.left, root.right);
  }
}