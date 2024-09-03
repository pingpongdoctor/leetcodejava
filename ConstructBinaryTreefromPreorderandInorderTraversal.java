import java.util.Arrays;
// 105. Construct Binary Tree from Preorder and Inorder Traversal
class ConstructBinaryTreefromPreorderandInorderTraversal {
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

  private int lookForIndex(int[] arr, int val){
      int in = 0;
      for (int i = 0;i<arr.length;i++){
          if(arr[i]==val){
              in = i;
          }
      }
      return in;
  }


  public TreeNode buildTree(int[] preorder, int[] inorder) {
      if(preorder.length==0){
          return null;
      }
      
      TreeNode root = new TreeNode(preorder[0]);
      int m = lookForIndex(inorder, preorder[0]);

      root.left = buildTree(Arrays.copyOfRange(preorder,1,m+1), Arrays.copyOfRange(inorder,0,m));
      root.right = buildTree(Arrays.copyOfRange(preorder,m+1,preorder.length), Arrays.copyOfRange(inorder,m+1,inorder.length));
      return root;
  }
}