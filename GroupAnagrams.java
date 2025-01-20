import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 49. Group Anagrams
// hashmap solution
// sort string and use it as a key to store values of string that have equivalent values to key after being sorted
public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    List<List<String>> ans = new ArrayList<List<String>>();

    if (strs.length == 1) {
      List<String> newS = new ArrayList<>();
      newS.add(strs[0]);
      ans.add(newS);
      return ans;
    }

    for (String s : strs) {
      char[] c = s.toCharArray();
      Arrays.sort(c);
      String newS = new String(c);

      if (!map.containsKey(newS)) {
        map.put(newS, new ArrayList<String>());
      }

      map.get(newS).add(s);
    }

    for (List<String> v : map.values()) {
      ans.add(v);
    }

    return ans;
  }
}