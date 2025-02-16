import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// 127. Word Ladder
// BFS through all possible mutations and find the shortest path to the endWord
// step number equals to the time of transformation so the words in the shortest sequence should be step + 1
// Instead returning step + 1, we can initialize step with the initial value 1
// BFS is the best solution since we are finding the shortest path
public class WordLadder {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet<>();
    for (String w : wordList) {
      set.add(w);
    }
    if (!set.contains(endWord)) {
      return 0;
    }
    int n = beginWord.length();
    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);
    int step = 1;

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String cur = queue.poll();
        if (cur.equals(endWord)) {
          return step;
        }
        char[] curCharArr = cur.toCharArray();

        for (int j = 0; j < n; j++) {
          char origin = curCharArr[j];
          for (char k = 'a'; k <= 'z'; k++) {
            if (origin != k) {
              curCharArr[j] = k;
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
    return 0;
  }
}
