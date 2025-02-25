import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// 1268. Search Suggestions System
// Trie and backtracking solution
// using c - 'a' to get index of character and store its value in an array of 26 characters
// convert index to char using (char) (index + 'a')
// use ASCII to calculate char index
// sort products first can make DFS order changed since the prefixed tree is built in different order
public class SearchSuggestionsSystem {
  class TrieNode {
    boolean isEnd = false;
    TrieNode[] children = new TrieNode[26];
  }

  private void insert(String word, TrieNode root) {
    TrieNode cur = root;
    for (char c : word.toCharArray()) {
      if (cur.children[c - 'a'] == null) {
        cur.children[c - 'a'] = new TrieNode();
      }
      cur = cur.children[c - 'a'];
    }
    cur.isEnd = true;
  }

  private void dfs(List<String> ans, TrieNode cur, StringBuilder curStr) {
    if (ans.size() >= 3) {
      return;
    }
    if (cur.isEnd) {
      ans.add(curStr.toString());
    }
    for (int i = 0; i < 26; i++) {
      if (cur.children[i] != null) {
        curStr.append((char) ('a' + i));
        dfs(ans, cur.children[i], curStr);
        curStr.deleteCharAt(curStr.length() - 1);
      }
    }
  }

  private List<String> returnWords(String word, TrieNode root) {
    List<String> ans = new ArrayList<>();
    TrieNode cur = root;
    for (char c : word.toCharArray()) {
      if (cur.children[c - 'a'] == null) {
        return ans;
      }
      cur = cur.children[c - 'a'];
    }
    // Gather all words starting with the current prefix
    StringBuilder curStr = new StringBuilder(word);
    dfs(ans, cur, curStr);
    return ans;
  }

  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    TrieNode root = new TrieNode();
    Arrays.sort(products);
    for (String word : products) {
      insert(word, root);
    }
    List<List<String>> rs = new ArrayList<List<String>>();
    StringBuilder prefix = new StringBuilder();
    for (char c : searchWord.toCharArray()) {
      prefix.append(c);
      List<String> words = returnWords(prefix.toString(), root);
      rs.add(words);
    }
    return rs;
  }

  // solution with max heap
  class TrieNode2 {
    TrieNode2[] children = new TrieNode2[26];
    PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));

    public void addPq(String word) {
      pq.add(word);
      if (pq.size() > 3) {
        pq.poll();
      }
    }

    public List<String> getTopThree() {
      List<String> ans = new ArrayList<>();
      while (!pq.isEmpty()) {
        ans.add(pq.poll());
      }
      Collections.reverse(ans);
      return ans;
    }
  }

  private void insert2(String word, TrieNode2 root) {
    TrieNode2 cur = root;
    for (char c : word.toCharArray()) {
      if (cur.children[c - 'a'] == null) {
        cur.children[c - 'a'] = new TrieNode2();
      }
      cur = cur.children[c - 'a'];
      cur.addPq(word);
    }
  }

  public List<List<String>> suggestedProducts2(String[] products, String searchWord) {
    TrieNode2 root = new TrieNode2();
    for (String word : products) {
      insert2(word, root);
    }
    List<List<String>> rs = new ArrayList<List<String>>();
    StringBuilder prefix = new StringBuilder();
    for (char c : searchWord.toCharArray()) {
      prefix.append(c);
      TrieNode2 cur = root;
      for (char charac : prefix.toString().toCharArray()) {
        if (cur.children[charac - 'a'] == null) {
          cur = null;
          break;
        }
        cur = cur.children[charac - 'a'];
      }
      if (cur != null) {
        rs.add(cur.getTopThree());
      } else {
        rs.add(new ArrayList<>());
      }
    }
    return rs;
  }
}