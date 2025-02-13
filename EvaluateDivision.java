import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// 399. Evaluate Division
// bfs to find the shortest path from s to e
public class EvaluateDivision {
  class Pair {
    String node;
    Double val;

    public Pair(String node, Double val) {
      this.node = node;
      this.val = val;
    }
  }

  private Map<String, List<Pair>> buildMap(List<List<String>> equations, double[] values) {
    Map<String, List<Pair>> map = new HashMap<>();

    for (int i = 0; i < equations.size(); i++) {
      List<String> equation = equations.get(i);
      String divisor = equation.get(0);
      String dividend = equation.get(1);

      if (!map.containsKey(divisor)) {
        map.put(divisor, new ArrayList<Pair>());
      }
      if (!map.containsKey(dividend)) {
        map.put(dividend, new ArrayList<Pair>());
      }
      map.get(divisor).add(new Pair(dividend, values[i]));
      map.get(dividend).add(new Pair(divisor, 1 / values[i]));
    }
    return map;
  }

  private double bfs(Map<String, List<Pair>> map, String s, String e) {
    if (!map.containsKey(s) || !map.containsKey(e)) {
      return -1.00000;
    }

    if (s.equals(e)) {
      return 1.00000;
    }

    Queue<Pair> queue = new LinkedList<>();
    Set<String> visit = new HashSet<>();
    queue.add(new Pair(s, 1.00000));
    visit.add(s);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Pair cur = queue.poll();
        String curVal = cur.node;
        double curProduct = cur.val;
        if (curVal.equals(e)) {
          return curProduct;
        }
        for (Pair n : map.get(curVal)) {
          String nextVal = n.node;
          double nextProduct = n.val;
          if (visit.contains(nextVal)) {
            continue;
          }
          queue.add(new Pair(nextVal, curProduct * nextProduct));
          visit.add(nextVal);
        }
      }
    }
    return -1;
  }

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Map<String, List<Pair>> map = buildMap(equations, values);

    double[] ans = new double[queries.size()];
    for (int k = 0; k < queries.size(); k++) {
      String s = queries.get(k).get(0);
      String e = queries.get(k).get(1);
      ans[k] = bfs(map, s, e);
    }
    return ans;
  }
}
