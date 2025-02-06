import java.util.HashMap;
import java.util.Map;

// use inorder array to find left and right branches
// identify current node of left and right branch by using post order (tracking from right to left)
// exploit postorderIdx instance variable to consistenly move it to the left in the postorder array to track the current node
public class ConstructBinaryTreeInorderPostorderTraversal {
  int postorderIdx;

  private TreeNode builder(int[] postorder, Map<Integer, Integer> map, int start, int end) {
    if (start > end) {
      return null;
    }

    int rootValue = postorder[postorderIdx];
    postorderIdx--;
    TreeNode root = new TreeNode(rootValue);
    int mid = map.get(rootValue);
    root.right = builder(postorder, map, mid + 1, end);
    root.left = builder(postorder, map, start, mid - 1);

    return root;
  }

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    Map<Integer, Integer> map = new HashMap<>();
    postorderIdx = postorder.length - 1;
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return builder(postorder, map, 0, postorder.length - 1);
  }
}