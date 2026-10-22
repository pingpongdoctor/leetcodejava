/*
Solution: dfs to build the clone. One thing to keep in mind. Although we do not traverse to the visited nodes, we return the clone of the node that is visited when we reach it to build the edge.
Time complexity: O(V) time to build the map + 0(V + 2E) time to process V node and number elements in adjacent lists. Since the graph is undirected, 1 edge appears in 2 list so the number of time we traverse on 1 edge is 2 times. That is why the number of elements in adjacent list is double the number of edges
O(V + E)
Space complexity: 0(V) space reserved for a map + O(V) space reserved for number of function in call stack in worst case + O(V + 2E) space reserved for a clone
O(V + E)
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode133 {
    class Node {
    public int val;
    private List<Node> neighbors;

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
        if(node == null) {
            return null;
        }

        HashMap<Node, Node> visited = new HashMap<>();

        return dfs(node,visited);
    }

    private Node dfs(Node node, HashMap<Node,Node> visited) {
        if(visited.containsKey(node)) {
            return visited.get(node);
        }

        Node clone = new Node(node.val);

        visited.put(node,clone);

        List<Node> list = clone.neighbors;

        for(Node n : node.neighbors) {
            Node newNeighbor = dfs(n, visited);
            if(newNeighbor != null) {
                list.add(newNeighbor);
            }
        }

        return clone;
    }
}