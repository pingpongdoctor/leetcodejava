// 701. Insert into a Binary Search Tree
class InsertTreeNode {
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
  public TreeNode insertIntoBST(TreeNode root, int val) {
      if(root==null){
          return new TreeNode(val);
      }

      if(val>root.val){
          root.right = insertIntoBST(root.right, val);
      } else {
          root.left = insertIntoBST(root.left,val);
      }
      return root;
  }    
}