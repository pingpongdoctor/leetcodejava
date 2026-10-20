import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
Solution: DFS on a graph, using a set to avoid revisiting vertices.

Time complexity:
- O(E) to iterate through the edges list and build the adjacency map.
- O(V + 2E) for the DFS: each vertex is expanded once (V), and each adjacency
  list is scanned once in total, which sums to 2E since an undirected edge
  appears in two lists. Repeat arrivals at a visited vertex return in O(1)
  and are bounded by the 2E edge traversals.
Final time complexity: O(V + E)

Space complexity:
- O(V + 2E) for the adjacency map (V keys, 2E list entries).
- O(V) for the visited set.
- O(V) for the recursion call stack in the worst case (a chain-shaped graph).
Final space complexity: O(V + E)
*/

public class Leetcode1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];

            if(!map.containsKey(v1)) {
                map.put(v1, new ArrayList<>());
            }
            if(!map.containsKey(v2)) {
                map.put(v2, new ArrayList<>());
            }
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }
        HashSet<Integer> visited = new HashSet<>();

        return dfs(map, source, destination, visited);
    }

    private boolean dfs(HashMap<Integer, List<Integer>> map, int cur, int destination, HashSet<Integer> visited){
        if(cur == destination) {
            return true;
        }

        if(visited.contains(cur)) {
            return false;
        }

        visited.add(cur);

        boolean isFound = false;

        for(int v : map.get(cur)) {
            boolean result = dfs(map, v, destination, visited);
            if(result) {
                isFound = true;
                break;
            }
        }

        return isFound;
    }
}