import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// 207. Course Schedule
public class CourseSchedule {
  // BFS
  // Kahn algorithm to identify cycle in a directed acyclic graph (DAG)
  // This algorithm ensures topological sorting in DAG. If there is a directed
  // edge from A to B. A must appears first before B
  // Nodes that have 0 in-degree (incoming edges) are processed first before
  // moving forward (dependencies are processed first before dependent nodes)
  // If total processed node number is fewer than the total node, it means there
  // are nodes that always have in-degree greater than 0 (we have an extant cycle)
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    int[] inDegree = new int[numCourses];
    for (int i = 0; i < prerequisites.length; i++) {
      int from = prerequisites[i][1];
      int to = prerequisites[i][0];
      map.putIfAbsent(from, new ArrayList<>());
      inDegree[to]++;
      map.get(from).add(to);
    }
    Queue<Integer> queue = new LinkedList<>();

    for (int k = 0; k < numCourses; k++) {
      if (inDegree[k] == 0) {
        queue.add(k);
      }
    }
    int count = 0;

    while (!queue.isEmpty()) {
      int cur = queue.poll();
      count++;
      if (map.get(cur) == null) {
        continue;
      }
      for (int n : map.get(cur)) {
        inDegree[n]--;
        if (inDegree[n] == 0) {
          queue.add(n);
        }
      }
    }
    return count == numCourses;
  }

  // DFS
  // check cycle in graph by marking unvisited - 0, visited - 1,
  // completed - 2
  // If we encouter a visited node in the current DFS path, there is a cycle
  private boolean hasCycle(Map<Integer, List<Integer>> map, int[] visit, int node) {
    if (visit[node] == 1) {
      return true;
    }
    if (visit[node] == 2) {
      return false;
    }
    visit[node] = 1;
    for (int n : map.get(node)) {
      if (hasCycle(map, visit, n)) {
        return true;
      }
    }
    visit[node] = 2;
    return false;
  }

  public boolean canFinish2(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int j = 0; j < numCourses; j++) {
      map.put(j, new ArrayList<>());
    }
    for (int[] p : prerequisites) {
      int from = p[1];
      int to = p[0];
      map.get(from).add(to);
    }
    int[] visit = new int[numCourses];
    for (int k = 0; k < numCourses; k++) {
      if (hasCycle(map, visit, k)) {
        return false;
      }
    }
    return true;
  }
}