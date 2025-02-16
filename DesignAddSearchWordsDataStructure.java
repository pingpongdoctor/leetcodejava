// 211. Design Add and Search Words Data Structure
// Using DFS in trie is reasonable since we need to check every path deeply to find if there is the string found at the leaf node
public class DesignAddSearchWordsDataStructure {
  class TrieNode {
    char val;
    TrieNode[] neighbors;
    boolean isEnd;

    public TrieNode() {
      neighbors = new TrieNode[26];
    }

    public TrieNode(char val) {
      neighbors = new TrieNode[26];
      this.val = val;
    }
  }

  TrieNode root;

  public DesignAddSearchWordsDataStructure() {
    root = new TrieNode();
  }

  public void addWord(String word) {
    TrieNode cur = root;
    for (char c : word.toCharArray()) {
      TrieNode[] neighbors = cur.neighbors;
      int idx = c - 'a';
      if (neighbors[idx] == null) {
        neighbors[idx] = new TrieNode(c);
      }
      cur = neighbors[idx];
    }
    cur.isEnd = true;
  }

  private boolean dfs(String word, int idx, TrieNode node) {
    if (idx == word.length()) {
      return node.isEnd;
    }
    char c = word.charAt(idx);

    if (c == '.') {
      for (TrieNode n : node.neighbors) {
        if (n != null) {
          if (dfs(word, idx + 1, n)) {
            return true;
          }
        }
      }
      return false;
    } else {
      int index = c - 'a';
      TrieNode[] neighbors = node.neighbors;
      return neighbors[index] != null ? dfs(word, idx + 1, neighbors[index]) : false;

    }
  }

  public boolean search(String word) {
    return dfs(word, 0, root);
  }
}
