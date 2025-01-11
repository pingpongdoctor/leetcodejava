import java.util.HashMap;
import java.util.Map;

// 205. Isomorphic Strings
// HashMap solution
public class IsomorphicStrings {
  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> mapS = new HashMap<>();
    Map<Character, Character> mapT = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char sChar = s.charAt(i);
      char tChar = t.charAt(i);

      if (mapS.containsKey(sChar)) {
        if (mapS.get(sChar) != tChar) {
          return false;
        }
      } else {
        mapS.put(sChar, tChar);
      }

      if (mapT.containsKey(tChar)) {
        if (mapT.get(tChar) != sChar) {
          return false;
        }
      } else {
        mapT.put(tChar, sChar);
      }
    }

    return true;
  }
}