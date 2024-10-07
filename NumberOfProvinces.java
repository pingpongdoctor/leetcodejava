import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// 547. Number of Provinces
//DFS and BFS have the same performance since we need them to traverse through all vertices
class NumberOfProvinces {
  private Map<Integer, List<Integer>> buildAdjList(int[][] isConnected) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int k = 0; k < isConnected.length; k++) {
      map.put(k, new ArrayList<Integer>());
    }
    for (int i = 0; i < isConnected.length; i++) {
      for (int j = 0; j < isConnected[i].length; j++) {
        if (isConnected[i][j] == 1 && i != j) {
          map.get(i).add(j);
        }
      }
    }
    return map;
  }

  private void dfs(Map<Integer, List<Integer>> adjList, Set<Integer> visitedCities, int r) {
    if (visitedCities.contains(r)) {
      return;
    }
    visitedCities.add(r);
    for (int n : adjList.get(r)) {
      dfs(adjList, visitedCities, n);
    }
  };

  private void bfs(Map<Integer, List<Integer>> adjList, Set<Integer> visitedCities, int r) {
    // set up
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(r);
    visitedCities.add(r);
    while (!queue.isEmpty()) {
      int curSize = queue.size();
      for (int i = 0; i < curSize; i++) {
        int curRow = queue.poll();
        for (int n : adjList.get(curRow)) {
          if (visitedCities.contains(n)) {
            continue;
          }
          queue.add(n);
          visitedCities.add(n);
        }
      }
    }
  };

  // DFS solution
  public int NumberOfProvincesWithDFSSolution(int[][] isConnected) {
    Map<Integer, List<Integer>> adjList = buildAdjList(isConnected);
    Set<Integer> visitedCities = new HashSet<Integer>();
    int province = 0;
    for (int i = 0; i < isConnected.length; i++) {
      if (!visitedCities.contains(i)) {
        dfs(adjList, visitedCities, i);
        province++;
      }
    }
    return province;
  }

  // BFS solution
  public int NumberOfProvincesWithBFSSolution(int[][] isConnected) {
    Map<Integer, List<Integer>> adjList = buildAdjList(isConnected);
    Set<Integer> visitedCities = new HashSet<Integer>();
    int province = 0;
    for (int i = 0; i < isConnected.length; i++) {
      if (!visitedCities.contains(i)) {
        bfs(adjList, visitedCities, i);
        province++;
      }
    }
    return province;
  }
}