import java.util.HashMap;
import java.util.Map;

// 208. Implement Trie (Prefix Tree)
// Store data set of string using keys
public class ImplementTriePrefixTree {
  class TrieNode {
    boolean isWordEnd;
    Map<Character, TrieNode> edges = new HashMap<>();
  }

  private TrieNode root;

  public ImplementTriePrefixTree() {
    root = new TrieNode();
  }

  private TrieNode findNode(String word) {
    TrieNode cur = root;
    for (char c : word.toCharArray()) {
      if (!cur.edges.containsKey(c)) {
        return null;
      }
      cur = cur.edges.get(c);
    }
    return cur;
  }

  public void insert(String word) {
    TrieNode cur = root;
    for (char c : word.toCharArray()) {
      if (!cur.edges.containsKey(c)) {
        cur.edges.put(c, new TrieNode());
      }
      cur = cur.edges.get(c);
    }
    cur.isWordEnd = true;
  }

  public boolean search(String word) {
    TrieNode ans = findNode(word);
    return ans == null ? false : ans.isWordEnd;
  }

  public boolean startsWith(String prefix) {
    TrieNode ans = findNode(prefix);
    return ans == null ? false : true;
  }
}