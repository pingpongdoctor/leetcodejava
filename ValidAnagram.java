// 242. Valid Anagram
// array or map solution
public class ValidAnagram {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] map = new int[26];

    for (char c : s.toCharArray()) {
      int idx = 'z' - c;
      map[idx] += 1;
    }

    for (Character c1 : t.toCharArray()) {
      int idx = 'z' - c1;
      if (map[idx] == 0) {
        return false;
      }

      map[idx] -= 1;
    }

    return true;
  }
}