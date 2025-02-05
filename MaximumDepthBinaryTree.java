import java.util.LinkedList;
import java.util.Queue;

// 104. Maximum Depth of Binary Tree
// BFS
public class MaximumDepthBinaryTree {
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

  class Solution {
    public int maxDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }

      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      int level = 0;

      while (queue.size() > 0) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          TreeNode cur = queue.poll();
          if (cur.left != null) {
            queue.add(cur.left);
          }
          if (cur.right != null) {
            queue.add(cur.right);
          }
        }
        level++;
      }
      return level;
    }
  }
}