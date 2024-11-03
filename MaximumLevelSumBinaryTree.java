import java.util.LinkedList;
import java.util.Queue;

//1161. Maximum Level Sum of a Binary Tree
//BFS solution
public class MaximumLevelSumBinaryTree {
  public int maxLevelSum(TreeNode root) {
    int maximal = root.val;
    Queue<TreeNode> queue = new LinkedList<>();
    if (root.right == null && root.left == null) {
      return 1;
    }
    int smallestLevel = 1;
    int lastLevel = 0;
    queue.add(root);
    while (!queue.isEmpty()) {
      int curSize = queue.size();
      int sum = 0;
      for (int i = 0; i < curSize; i++) {
        TreeNode cur = queue.poll();
        sum += cur.val;
        if (cur.left != null) {
          queue.add(cur.left);
        }
        if (cur.right != null) {
          queue.add(cur.right);
        }
      }
      lastLevel++;
      if (sum > maximal) {
        maximal = sum;
        smallestLevel = lastLevel;
      }
    }
    return smallestLevel;
  }
}