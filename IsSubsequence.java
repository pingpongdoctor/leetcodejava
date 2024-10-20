// 392. Is Subsequence
public class IsSubsequence {
  public boolean isSubsequence(String s, String t) {
    if (s.length() == 0) {
      return true;
    }
    if (s.equals(t)) {
      return true;
    }
    int p1 = 0;
    int p2 = 0;
    String s2 = "";
    while (p1 < t.length() && p2 < s.length()) {
      if (t.charAt(p1) == s.charAt(p2)) {
        s2 += t.charAt(p1);
        p2++;
      }
      p1++;
    }
    return s2.equals(s);
  }
}