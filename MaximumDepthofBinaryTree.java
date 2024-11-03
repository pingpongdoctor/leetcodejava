import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthofBinaryTree {
  public int maxDepth(TreeNode root) {
    int lastLevel = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    if (root != null) {
      queue.add(root);
    }
    while (!queue.isEmpty()) {
      int curSize = queue.size();
      for (int i = 0; i < curSize; i++) {
        TreeNode cur = queue.poll();
        if (cur.left != null) {
          queue.add(cur.left);
        }
        if (cur.right != null) {
          queue.add(cur.right);
        }
      }
      lastLevel++;
    }
    return lastLevel;
  }
}