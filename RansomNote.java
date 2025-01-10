import java.util.HashMap;
import java.util.Map;

// 383. Ransom Note
// use map to track characters and number of characters
public class RansomNote {
  public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : magazine.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for (char c1 : ransomNote.toCharArray()) {
      if (map.containsKey(c1) && map.get(c1) > 0) {
        map.put(c1, map.get(c1) - 1);
      } else {
        return false;
      }
    }

    return true;
  }
}