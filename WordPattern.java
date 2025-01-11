import java.util.HashMap;
import java.util.Map;

// 290. Word Pattern
// HashMap
public class WordPattern {
  public boolean wordPattern(String pattern, String s) {
    Map<String, String> map1 = new HashMap<>();
    Map<String, String> map2 = new HashMap<>();

    String[] sArr = s.split(" ");

    if (sArr.length != pattern.length()) {
      return false;
    }
    for (int i = 0; i < pattern.length(); i++) {
      String cur = pattern.substring(i, i + 1);

      if (map1.containsKey(cur)) {
        if (!map1.get(cur).equals(sArr[i])) {
          return false;
        }
      } else {
        map1.put(cur, sArr[i]);
      }

      if (map2.containsKey(sArr[i])) {
        if (!map2.get(sArr[i]).equals(cur)) {
          return false;
        }
      } else {
        map2.put(sArr[i], cur);
      }
    }

    return true;
  }
}