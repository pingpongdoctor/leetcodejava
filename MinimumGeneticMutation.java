import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 433. Minimum Genetic Mutation
// BFS all possible mutations that are included in the bank
public class MinimumGeneticMutation {
  public int minMutation(String startGene, String endGene, String[] bank) {
    char[] characs = { 'A', 'C', 'G', 'T' };
    Set<String> set = new HashSet<>();
    for (String val : bank) {
      set.add(val);
    }
    Queue<String> queue = new LinkedList<>();
    queue.add(startGene);
    int step = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String cur = queue.poll();
        if (cur.equals(endGene)) {
          return step;
        }
        char[] curCharArr = cur.toCharArray();
        for (int j = 0; j < 8; j++) {
          char origin = curCharArr[j];
          for (int k = 0; k < 4; k++) {
            char newChar = characs[k];
            if (newChar != origin) {
              curCharArr[j] = newChar;
              String newString = String.valueOf(curCharArr);
              if (!set.contains(newString)) {
                continue;
              }
              queue.add(newString);
              set.remove(newString);
            }
          }
          curCharArr[j] = origin;
        }
      }
      step++;
    }
    return -1;
  }
}
