import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// 210. Course Schedule II
// Kahn algorithm to BFS traverse nodes in topological sorting order
public class CourseSchedule2 {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
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
    int[] ans = new int[numCourses];
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      ans[count] = cur;
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
    return count == numCourses ? ans : new int[0];
  }
}
