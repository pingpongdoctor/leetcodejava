// 226. Invert Binary Tree
// pre-order traversal to access each node and swap left and right branches
public class InvertBinaryTree {
  public TreeNode invertTree(TreeNode root) {
    if (root != null) {
      TreeNode temp = root.right;
      root.right = root.left;
      root.left = temp;
      invertTree(root.left);
      invertTree(root.right);
    }
    return root;
  }
}