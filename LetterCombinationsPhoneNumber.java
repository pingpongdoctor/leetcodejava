import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//17. Letter Combinations of a Phone Number with DFS and Backtracking solution
//use cur idx to track which level we are being at in the tree
//for example: idx:0 of '234' indicates 'abc' corresponding to number 2. we loop through a,b,c. At a, we dfs to idx 1 as the nextlevel
//com would be 'a', then 'ad', then, 'adj' and backtrack to 'ad' then 'adh', then backtrack to 'ad', then 'adi', then backtrack to 'ad', backtrack to 'a', then move on with 'ae' and so on
public class LetterCombinationsPhoneNumber {
  private void dfs(int idx, String digits, List<String> ans, StringBuilder com, Map<Integer, List<Character>> map) {
    if (idx == digits.length()) {
      ans.add(com.toString());
      return;
    }
    List<Character> curList = map.get(digits.charAt(idx) - '0');
    for (Character c : curList) {
      com.append(c);
      dfs(idx + 1, digits, ans, com, map);
      com.deleteCharAt(com.length() - 1);
    }
  }

  public List<String> letterCombinations(String digits) {
    Map<Integer, List<Character>> map = new HashMap<>();
    Character start = 'a';
    for (int i = 2; i <= 9; i++) {
      int j = 0;
      if (i == 7 || i == 9) {
        j = 4;
      } else {
        j = 3;
      }
      map.put(i, new ArrayList<Character>());
      while (j > 0) {
        map.get(i).add(start);
        start++;
        j--;
      }
    }
    List<String> ans = new ArrayList<>();
    if (digits.length() <= 0) {
      return ans;
    }
    StringBuilder com = new StringBuilder();
    dfs(0, digits, ans, com, map);
    return ans;
  }
}