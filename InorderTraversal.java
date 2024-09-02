import java.util.ArrayList;
import java.util.List;

// 94. Binary Tree Inorder Traversal
class InorderTraversal {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
   }
  List<Integer> l = new ArrayList<Integer>();

  private void traverse(TreeNode root){
      if(root==null){
          return;
      }
      inorderTraversal(root.left);
      l.add(root.val);
      inorderTraversal(root.right);
  }
  private List<Integer> getList(){
      return this.l;
  }
  public List<Integer> inorderTraversal(TreeNode root) {
      traverse(root);
      return getList();
  }
}