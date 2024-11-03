import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// 1466. Reorder Routes to Make All Paths Lead to the City Zero

//The adjacency list has keys (cities) and values which are the neighbor list
//Each neighbor element is a list containing vertex value and flag
//The flag indicates if we need to reverse the direction at the current edge
//As we bfs from node 0 to other node, we know that we are moving away from 0 node so if we see any from -> to direction (move away/flag 1), we reverse the direction
class ReorderRoutestoMakeAllPathsLeadToCityZero_Simon {
  private Map<Integer, List<int[]>> buildAdjList(int[][] connections) {
    Map<Integer, List<int[]>> graph = new HashMap<>();

    for (int[] connection : connections) {
      int from = connection[0];
      int to = connection[1];

      // from -> to with flag 1 (requires reversal if traversed)
      if (!graph.containsKey(from)) {
        graph.put(from, new ArrayList<>());
      }
      int[] pair1 = { to, 1 };
      graph.get(from).add(pair1);

      // to -> from with flag 0 (does not require reversal)
      if (!graph.containsKey(to)) {
        graph.put(to, new ArrayList<>());
      }
      int[] pair2 = { from, 0 };
      graph.get(to).add(pair2);
    }

    return graph;
  }

  private Integer bfs(Map<Integer, List<int[]>> graph) {
    Integer changeTime = 0;
    Queue<Integer> queue = new LinkedList<Integer>();
    Set<Integer> visit = new HashSet<>();
    queue.add(0);
    visit.add(0);
    while (!queue.isEmpty()) {
      int curSize = queue.size();
      for (Integer i = 0; i < curSize; i++) {
        Integer curVertex = queue.poll();
        for (int[] neighbor : graph.get(curVertex)) {
          int nextNode = neighbor[0];
          if (visit.contains(nextNode)) {
            continue;
          }
          if (neighbor[1] == 1) {
            changeTime++;
          }
          queue.add(nextNode);
          visit.add(nextNode);
        }
      }
    }

    return changeTime;
  }

  public Integer minReorder(Integer n, int[][] connections) {
    Map<Integer, List<int[]>> graph = buildAdjList(connections);
    return bfs(graph);
  }
}