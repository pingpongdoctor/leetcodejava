import java.util.HashMap;
import java.util.Map;

// 105. Construct Binary Tree from Preorder and Inorder Traversal
class ConstructBinaryTreefromPreorderandInorderTraversal {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  // cache data of inorder in hashmap
  // a function accept preorder, map, start and end indices
  // The solution is creating current node then recursively run the function to
  // modify left and right branches before return it
  // preorder idx is exploited for creating the new node
  // map is utilized to get inorder idx that is employed for calculate ranges of
  // left and right branches
  private TreeNode builder(int[] preorder, int start, int end, Map<Integer, Integer> map, int preorderIdx) {
    if (start > end) {
      return null;
    }
    int rootVal = preorder[preorderIdx];
    TreeNode root = new TreeNode(rootVal);

    int mid = map.get(rootVal);

    root.left = builder(preorder, start, mid - 1, map, preorderIdx + 1);
    root.right = builder(preorder, mid + 1, end, map, preorderIdx + (mid - start) + 1);

    return root;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 1) {
      TreeNode newNode = new TreeNode(preorder[0]);
      return newNode;
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    return builder(preorder, 0, preorder.length - 1, map, 0);
  }
}