// Definition for a binary tree node.

class Solution {
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

 //search the left-most node
  public TreeNode minNodeSearch(TreeNode root){
      TreeNode cur = root;
      while (cur!=null&&cur.left!=null){
          cur = cur.left;
      }
      return cur;
  }

  public TreeNode deleteNode(TreeNode root, int key) {
      if(root==null){
          return null;
      }

      if(key>root.val){
          root.right = deleteNode(root.right, key);
      } else if(key<root.val){
          root.left = deleteNode(root.left, key);
      }
      else{
          if(root.left==null){
              return root.right;
          }else if(root.right==null){
              return root.left;
          } else {
            //search the left-most node in right subtree (in-order successor)
              TreeNode minNode = minNodeSearch(root.right);
              root.val = minNode.val;
              root.right = deleteNode(root.right, minNode.val);
          }
      }
      return root;
  }
}