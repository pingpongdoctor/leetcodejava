import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// 133. Clone Graph
// BFS and map
public class CloneGraph {
  class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }

  public Node cloneGraph(Node node) {
    if (node == null) {
      return node;
    }
    Queue<Node> queue = new LinkedList<>();
    Map<Node, Node> map = new HashMap<>();
    queue.add(node);
    map.put(node, new Node(node.val));

    while (queue.size() > 0) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node cur = queue.poll();
        for (Node neighbor : cur.neighbors) {
          if (!map.containsKey(neighbor)) {
            map.put(neighbor, new Node(neighbor.val));
            queue.add(neighbor);
          }
          map.get(cur).neighbors.add(map.get(neighbor));
        }
      }
    }
    return map.get(node);
  }
}
