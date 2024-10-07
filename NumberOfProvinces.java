import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// 547. Number of Provinces
//DFS and BFS have the same performance since we need them to traverse through all vertices
class NumberOfProvinces {
  // DFS solution
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

  public int findCircleNum(int[][] isConnected) {
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
}