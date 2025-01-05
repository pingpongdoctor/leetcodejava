import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//14. Longest Common Prefix
public class LongestCommonPrefix {
  // Trie
  class TrieNode {
    boolean isEnd;
    Map<Character, TrieNode> children;

    public TrieNode() {
      isEnd = false;
      children = new HashMap<>();
    }
  }

  TrieNode root;

  public LongestCommonPrefix() {
    root = new TrieNode();
  }

  private void insert(String str) {
    TrieNode cur = root;
    for (char c : str.toCharArray()) {
      if (!cur.children.containsKey(c)) {
        cur.children.put(c, new TrieNode());
      }
      cur = cur.children.get(c);
    }
    cur.isEnd = true;
  }

  public String longestCommonPrefix(String[] strs) {
    for (String str : strs) {
      insert(str);
    }
    TrieNode cur = root;
    StringBuilder ans = new StringBuilder();
    while (!cur.isEnd) {
      if (cur.children.size() > 1) {
        break;
      }
      char key = cur.children.keySet().iterator().next();
      ans.append(key);
      cur = cur.children.get(key);
    }
    return ans.toString();
  }

  // using lexicographically sorting the compare first and last word
  // words with common prefix are grouped and if there is any completely different
  // word, it would be positioned at first or last index
  public String longestCommonPrefix2(String[] strs) {
    Arrays.sort(strs);
    String first = strs[0];
    String last = strs[strs.length - 1];
    StringBuilder ans = new StringBuilder();

    if (first.length() == 0) {
      return "";
    }

    if (first.length() == last.length() && first.equals(last)) {
      return first;
    }

    for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
      char l1 = first.charAt(i);
      char l2 = last.charAt(i);
      if (l1 != l2) {
        break;
      }
      ans.append(l1);
    }

    return ans.toString();
  }
}