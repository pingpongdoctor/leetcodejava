// 2390. Removing Stars From a String
public class RemovingStarsFromString {
  public String removeStars(String s) {
    StringBuilder ans = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c != '*') {
        ans.append(c);
        continue;
      }
      if (ans.length() > 0) {
        ans.deleteCharAt(ans.length() - 1);
      }
    }
    return ans.toString();
  }
}