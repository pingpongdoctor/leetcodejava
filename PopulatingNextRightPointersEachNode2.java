import java.util.LinkedList;
import java.util.Queue;

// 117. Populating Next Right Pointers in Each Node II
// BFS solution
// memorize the previous node when bfs each level of the tree from left to right
public class PopulatingNextRightPointersEachNode2 {
  class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  };

  public Node connect(Node root) {
    if (root == null || (root.left == null && root.right == null)) {
      return root;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (queue.size() > 0) {
      int size = queue.size();
      Node prev = queue.peek();
      for (int i = 0; i < size; i++) {
        Node cur = queue.poll();
        if (cur.left != null) {
          queue.add(cur.left);
        }
        if (cur.right != null) {
          queue.add(cur.right);
        }
        if (prev != cur) {
          prev.next = cur;
          prev = cur;
        }
      }
    }
    return root;
  }
}