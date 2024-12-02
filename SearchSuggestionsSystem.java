import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1268. Search Suggestions System
// Trie and backtracking solution
public class SearchSuggestionsSystem {
  class TrieNode {
    boolean isEnd = false;
    Map<Character, TrieNode> edges = new HashMap<>();
  }

  private void insert(String word, TrieNode root) {
    TrieNode cur = root;
    for (char c : word.toCharArray()) {
      if (!cur.edges.containsKey(c)) {
        cur.edges.put(c, new TrieNode());
      }
      cur = cur.edges.get(c);
    }
    cur.isEnd = true;
  }

  private void dfs(List<String> ans, TrieNode cur, StringBuilder curStr) {
    if (cur.isEnd) {
      ans.add(curStr.toString());
    }
    for (Map.Entry<Character, TrieNode> entry : cur.edges.entrySet()) {
      char key = entry.getKey();
      TrieNode value = entry.getValue();
      curStr.append(key);
      dfs(ans, value, curStr);
      curStr.deleteCharAt(curStr.length() - 1);
    }
  }

  private List<String> returnWords(String word, TrieNode root) {
    List<String> ans = new ArrayList<>();
    TrieNode cur = root;
    for (char c : word.toCharArray()) {
      if (!cur.edges.containsKey(c)) {
        return ans;
      }
      cur = cur.edges.get(c);
    }
    // Gather all words starting with the current prefix
    StringBuilder curStr = new StringBuilder(word);
    dfs(ans, cur, curStr);

    // Sort and return up to 3 suggestions
    Collections.sort(ans);
    return ans.size() > 3 ? new ArrayList<>(ans.subList(0, 3)) : ans;
  }

  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    TrieNode root = new TrieNode();
    for (String word : products) {
      insert(word, root);
    }
    List<List<String>> rs = new ArrayList<List<String>>();
    for (int i = 0; i < searchWord.length(); i++) {
      List<String> words = returnWords(searchWord.substring(0, i + 1), root);
      rs.add(words);
    }
    return rs;
  }
}