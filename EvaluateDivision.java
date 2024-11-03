import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// 399. Evaluate Division
public class EvaluateDivision {
  class Pair {
    String node;
    double value;

    public Pair(String node, double value) {
      this.node = node;
      this.value = value;
    }
  }

  public Map<String, List<Pair>> buildAdjList(List<List<String>> equations, double[] values) {
    Map<String, List<Pair>> graph = new HashMap<>();
    for (int i = 0; i < equations.size(); i++) {
      List<String> equation = equations.get(i);
      String fr = equation.get(0);
      String to = equation.get(1);
      if (!graph.containsKey(fr)) {
        graph.put(fr, new ArrayList<Pair>());
      }
      if (!graph.containsKey(to)) {
        graph.put(to, new ArrayList<Pair>());
      }
      graph.get(fr).add(new Pair(to, values[i]));
      graph.get(to).add(new Pair(fr, 1 / values[i]));
    }
    return graph;
  }

  public double bfs(Map<String, List<Pair>> graph, String s, String e) {
    if (!graph.containsKey(s) || !graph.containsKey(e)) {
      return -1;
    }
    if (s.equals(e)) {
      return 1;
    }
    Queue<Pair> queue = new LinkedList<>();
    Set<String> visit = new HashSet<>();
    queue.add(new Pair(s, 1));
    visit.add(s);
    while (!queue.isEmpty()) {
      int curSize = queue.size();
      for (int i = 0; i < curSize; i++) {
        Pair cur = queue.poll();
        String curNode = cur.node;
        double curProduct = cur.value;
        List<Pair> neighbors = graph.get(curNode);
        for (Pair neighbor : neighbors) {
          String nextNode = neighbor.node;
          if (visit.contains(nextNode)) {
            continue;
          }
          double nextProduct = neighbor.value;
          double newProduct = curProduct * nextProduct;
          if (nextNode.equals(e)) {
            return newProduct;
          }
          queue.add(new Pair(nextNode, newProduct));
          visit.add(nextNode);
        }
      }
    }
    return -1;
  }

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Map<String, List<Pair>> graph = buildAdjList(equations, values);
    double[] returnValues = new double[queries.size()];

    for (int i = 0; i < queries.size(); i++) {
      List<String> curQuery = queries.get(i);
      double result = bfs(graph, curQuery.get(0), curQuery.get(1));
      returnValues[i] = result;
    }
    return returnValues;
  }
}
