// 114. Flatten Binary Tree to Linked List
// Morris traversal
// go to left then look for the right most node
// connect runner.right = cur.right
// cur.right to the left branch
// move cur pointer downward and repeat the step to check if there is cur.left
public class FlattenBinaryTreeLinkedList {
  public void flatten(TreeNode root) {
    TreeNode cur = root;
    while (cur != null) {
      if (cur.left != null) {
        TreeNode runner = cur.left;
        while (runner != null && runner.right != null) {
          runner = runner.right;
        }
        runner.right = cur.right;
        cur.right = cur.left;
        cur.left = null;
      }
      cur = cur.right;
    }
  }
}