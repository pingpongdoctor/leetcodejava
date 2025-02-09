import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 637. Average of Levels in Binary Tree
// BFS
public class AverageLevelsBinaryTree {
  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> ans = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (queue.size() > 0) {
      int size = queue.size();
      double sum = 0;
      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        sum += cur.val;
        if (cur.left != null) {
          queue.add(cur.left);
        }
        if (cur.right != null) {
          queue.add(cur.right);
        }
      }
      ans.add(sum / size);
    }
    return ans;
  }
}
