import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
  //USE MAP TO LOOK FOR ROOT INDEX IN INRODER ARRAY LEADS TO TIME COMPLEXITY n2 AND USE COPYOFRANGE LEAD TO MORE SPACE COMPLEXITY

  // private int lookForIndex(int[] arr, int val){
  //     int in = 0;
  //     for (int i = 0;i<arr.length;i++){
  //         if(arr[i]==val){
  //             in = i;
  //         }
  //     }
  //     return in;
  // }


  // public TreeNode buildTree(int[] preorder, int[] inorder) {
  //     if(preorder.length==0){
  //         return null;
  //     }
      
  //     TreeNode root = new TreeNode(preorder[0]);
  //     int m = lookForIndex(inorder, preorder[0]);

  //     root.left = buildTree(Arrays.copyOfRange(preorder,1,m+1), Arrays.copyOfRange(inorder,0,m));
  //     root.right = buildTree(Arrays.copyOfRange(preorder,m+1,preorder.length), Arrays.copyOfRange(inorder,m+1,inorder.length));
  //     return root;
  // }

  //USE HASHMAP TO CATCH DATA TO LOWER SPACE COMPLEXITY AND AVOID CREATING NEW ARRAYS USING HELPER FUNCTION
  Map<Integer,Integer> map = new HashMap<Integer,Integer>();

  private TreeNode helper(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd){
    if(preStart>preEnd||inStart>inEnd){
      return null;
    }
    TreeNode root = new TreeNode(pre[preStart]);
    int mid = map.get(pre[preStart]);
    int leftTreeSize = mid - inStart;
    root.left=helper(pre,in,preStart+1,preStart+leftTreeSize,inStart,mid-1);
    root.right=helper(pre,in,preStart+leftTreeSize+1,preEnd,mid+1,inEnd);
    return root;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    for(int i = 0; i<inorder.length; i++){
      map.put(inorder[i],i);
    }
    return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
  }
}