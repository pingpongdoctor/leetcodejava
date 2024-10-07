import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 841. Keys and Rooms
//DFS solution with keys are neighbors
class CanVisitRoom {
  public void dfs(List<List<Integer>> rooms, Set<Integer> visitedRows, int r) {
    if (visitedRows.contains(r)) {
      return;
    }
    visitedRows.add(r);

    for (int key : rooms.get(r)) {
      if (!visitedRows.contains(key)) {
        dfs(rooms, visitedRows, key);
      }
    }
  }

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    Set<Integer> visitedRows = new HashSet<Integer>();
    dfs(rooms, visitedRows, 0);
    return visitedRows.size() == rooms.size();
  }
}