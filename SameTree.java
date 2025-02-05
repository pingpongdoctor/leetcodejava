// 100. Same Tree
// DFS
// Using DFS helps check if nodes of both trees are identical based on levels and sides
// Use XOR operator to check if one of two operands is false
public class SameTree {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null ^ q == null) {
      return false;
    }
    return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
