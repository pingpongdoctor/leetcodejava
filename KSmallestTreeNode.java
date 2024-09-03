import java.util.ArrayList;
import java.util.List;

// 230. Kth Smallest Element in a BST
class KSmallestTreeNode {
  List<Integer> l = new ArrayList<Integer>();

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
  private void inorderTraverse(TreeNode root){
      if(root==null){
          return;
      }
      inorderTraverse(root.left);
      l.add(root.val);
      inorderTraverse(root.right);
  }

  private Integer getK(int k){
      return this.l.get(k);
  }

  public int kthSmallest(TreeNode root, int k) {
      inorderTraverse(root);
      return getK(k-1);
  }
}